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
import yteamserver.domain.video.dto.CreateVideoRes;
import yteamserver.domain.video.dto.GetVidedoRes;
import yteamserver.global.config.s3.S3Service;

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
    public CreateVideoRes createVideo(CreateVideoReq createVideoReq) {

        // To-do 유저 도메인 구현되고 수정해야함.
        Users users = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        // Store
        Store store = storeRepository.findByStoreName(createVideoReq.getStoreName()).orElseThrow(RuntimeException::new);
        System.out.println("store = " + store.getStoreName());

        Video video = Video.builder()
                .users(users)
                .title(createVideoReq.getTitle())
                .viewCount(0)
                .store(store)
                .videoUrl(s3Service.uploadImageToS3(createVideoReq.getVideo())) // 비디오 업로드 기능 구현 후 입력
                .build();


        videoRepository.save(video);

        return CreateVideoRes.builder()
                .id(video.getId())
                .build();

    }

    @Transactional
    public Page<GetVidedoRes> getVideo(Pageable pageable) {
        Page<Video> videosPage = videoRepository.findAll(pageable);

        List<GetVidedoRes> findVideoResList = videosPage.getContent().stream()
                .map(video -> {
                    boolean isBookmarked = videoBookmarkRepository.findByUserIdAndVideoId(1L, video.getId()).isPresent();
                    return GetVidedoRes.builder()
                            .id(video.getId())
                            .title(video.getTitle())
                            .userName(video.getUsers() != null ? video.getUsers().getName() : video.getStore().getStoreName())
                            .viewCount(video.getViewCount())
                            .videoUrl(video.getVideoUrl())
                            .ThumbnailUrl(video.getThumbnailUrl())
                            .bookmarked(isBookmarked)
                            .build();
                })
                .collect(Collectors.toList());

        return new PageImpl<>(findVideoResList, pageable, videosPage.getTotalElements());
    }
}
