package yteamserver.domain.video.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yteamserver.domain.video.domain.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
