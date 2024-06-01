package yteamserver.domain.homepage.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import yteamserver.domain.homepage.domain.Advertisement;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
    @Query(value = "SELECT * FROM advertisement ORDER BY created_at DESC LIMIT 5", nativeQuery = true)
    List<Advertisement> findRecentlyFive();
}
