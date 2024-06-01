package yteamserver.domain.bookmark.application;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yteamserver.domain.bookmark.domain.VideoBookmark;
import yteamserver.domain.bookmark.domain.repository.VideoBookmarkRepository;
import yteamserver.domain.users.repository.UserRepository;
import yteamserver.domain.users.repository.Users;
import yteamserver.domain.video.domain.Video;
import yteamserver.domain.video.domain.repository.VideoRepository;
import yteamserver.global.error.ErrorCode;
import yteamserver.global.error.GeneralException;

@Service
@RequiredArgsConstructor
public class BookmarkService {
    private final VideoBookmarkRepository videoBookmarkRepository;
    private final VideoRepository videoRepository;
    private final UserRepository userRepository;

    public void createVideoBookmark(String token, Long videoId) {
        // 유저 토큰 검증
        Users user = userRepository.findByToken(token)
                .orElseThrow(() -> new GeneralException(ErrorCode.USER_NOT_FOUND));
        // 숏폼 영상 검증
        Video video = videoRepository.findById(videoId)
                .orElseThrow(() -> new GeneralException(ErrorCode.VIDEO_NOT_FOUND));

        // 이미 북마크로 등록된 영상인지 검증
        if (videoBookmarkRepository.existsByUser_IdAndVideo_Id(user.getId(), video.getId())) {
            throw new GeneralException(ErrorCode.VIDEO_ALREADY_BOOKMARKED);
        }

        VideoBookmark videoBookmark = VideoBookmark.builder()
                .user(user)
                .video(video)
                .build();

        videoBookmarkRepository.save(videoBookmark);
    }

    @Transactional
    public void deleteVideoBookmark(String token, Long videoId) {
        // 유저 토큰 검증
        Users user = userRepository.findByToken(token)
                .orElseThrow(() -> new GeneralException(ErrorCode.USER_NOT_FOUND));
        // 숏폼 영상 검증
        Video video = videoRepository.findById(videoId)
                .orElseThrow(() -> new GeneralException(ErrorCode.VIDEO_NOT_FOUND));

        // 북마크로 등록되지 않은 영상인지 검증
        if (!videoBookmarkRepository.existsByUser_IdAndVideo_Id(user.getId(), video.getId())) {
            throw new GeneralException(ErrorCode.VIDEO_BOOKMARK_NOT_FOUND);
        }

        videoBookmarkRepository.deleteByUser_IdAndVideo_Id(user.getId(), video.getId());
    }
}
