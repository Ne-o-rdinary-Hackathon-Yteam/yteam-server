package yteamserver.domain.bookmark.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import yteamserver.domain.bookmark.domain.VideoBookmark;

import java.util.Optional;

public interface VideoBookmarkRepository extends JpaRepository<VideoBookmark, Long> {
    Boolean existsByUser_IdAndVideo_Id(Long userId, Long videoId);
    void deleteByUser_IdAndVideo_Id(Long userId, Long videoId);
    Integer countByVideo_Id(Long videoId);

    @Query("SELECT vb FROM VideoBookmark vb WHERE vb.user.id = :userId AND vb.video.id = :videoId")
    Optional<VideoBookmark> findByUserIdAndVideoId(@Param("userId") Long userId, @Param("videoId") Long videoId);
}
