package yteamserver.domain.video.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import yteamserver.domain.bookmark.domain.VideoBookmark;
import yteamserver.domain.video.domain.Video;

import java.util.List;
import java.util.Optional;

public interface VideoRepository extends JpaRepository<Video, Long> {
    @Query(value = "SELECT * FROM video ORDER BY created_at DESC LIMIT 5", nativeQuery = true)
    List<Video> findRecentlyFive();

    @Query("SELECT vb FROM VideoBookmark vb WHERE vb.user.id = :userId AND vb.video.id = :videoId")
    Optional<VideoBookmark> findByUserIdAndVideoId(@Param("userId") Long userId, @Param("videoId") Long videoId);
}
