package yteamserver.domain.video.application;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yteamserver.domain.bookmark.domain.repository.VideoBookmarkRepository;
import yteamserver.domain.store.domain.Store;
import yteamserver.domain.store.domain.repository.StoreRepository;
import yteamserver.domain.users.domain.repository.UserRepository;
import yteamserver.domain.users.domain.Users;
import yteamserver.domain.video.domain.Video;
import yteamserver.domain.video.domain.repository.VideoRepository;
import yteamserver.domain.video.dto.CreateVideoReq;
import yteamserver.domain.video.dto.GetVidedoRes;
import yteamserver.global.config.s3.S3Service;
import yteamserver.global.error.ErrorCode;
import yteamserver.global.error.GeneralException;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class VideoService {

    private final VideoRepository videoRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;
    private final VideoBookmarkRepository videoBookmarkRepository;

    private final S3Service s3Service;

    @Transactional
    public void createVideo(CreateVideoReq createVideoReq) {

        // To-do 유저 도메인 구현되고 수정해야함.
        Users users = userRepository.findByToken(createVideoReq.getToken())
                .orElseThrow(() -> new GeneralException(ErrorCode.USER_NOT_FOUND));

        // 업로더가 업체인 경우
        if(createVideoReq.getIsStore()) {
            // Store
            Store store = storeRepository.findByStoreName(createVideoReq.getName())
                    .orElseThrow(() -> new GeneralException(ErrorCode.STORE_NOT_FOUND));

            Video video = Video.builder()
                    .title(createVideoReq.getTitle())
                    .viewCount(0)
                    .store(store)
                    .videoUrl(s3Service.uploadImageToS3(createVideoReq.getVideo()))
                    .build();

            videoRepository.save(video);
            return;
        }

        // User인 경우
        Users user = userRepository.findByName(createVideoReq.getName())
                .orElseThrow(() -> new GeneralException(ErrorCode.USER_NOT_FOUND));

        Video video = Video.builder()
                .title(createVideoReq.getTitle())
                .viewCount(0)
                .user(user)
                .videoUrl(s3Service.uploadImageToS3(createVideoReq.getVideo()))
                .build();


        videoRepository.save(video);
    }

    @Transactional
    public Page<GetVidedoRes> getVideo(Pageable pageable, String token) {
        Page<Video> videosPage = videoRepository.findAll(pageable);
        Users user = userRepository.findByToken(token).orElse(null);

        List<GetVidedoRes> findVideoResList = videosPage.getContent().stream()
                .map(video -> {
                    boolean isBookmarked = false;
                    if(user != null) {
                        isBookmarked = videoBookmarkRepository.findByUserIdAndVideoId(user.getId(), video.getId()).isPresent();
                    }
                    Integer bookmarkedCount = videoBookmarkRepository.countByVideo_Id(video.getId());
                    return GetVidedoRes.builder()
                            .id(video.getId())
                            .title(video.getTitle())
                            .userName(video.getUser() != null ? video.getUser().getName() : video.getStore().getStoreName())
                            .viewCount(video.getViewCount())
                            .videoUrl(video.getVideoUrl())
                            .ThumbnailUrl(video.getThumbnailUrl())
                            .bookmarked(isBookmarked)
                            .bookmarkCount(bookmarkedCount)
                            .storeLink(video.getStore() != null ? video.getStore().getStoreLink() : null)
                            .build();
                })
                .collect(Collectors.toList());

        return new PageImpl<>(findVideoResList, pageable, videosPage.getTotalElements());
    }
}
