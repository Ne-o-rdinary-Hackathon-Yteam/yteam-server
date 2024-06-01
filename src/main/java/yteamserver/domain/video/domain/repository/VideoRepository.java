package yteamserver.domain.video.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import yteamserver.domain.video.domain.Video;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {
    @Query(value = "SELECT * FROM video ORDER BY created_at DESC LIMIT 5", nativeQuery = true)
    List<Video> findRecentlyFive();
}
