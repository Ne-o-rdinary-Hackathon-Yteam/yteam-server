package yteamserver.domain.bookmark.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yteamserver.domain.bookmark.domain.VideoBookmark;

public interface VideoBookmarkRepository extends JpaRepository<VideoBookmark, Long> {
    Boolean existsByUser_IdAndVideo_Id(Long userId, Long videoId);
}
