package yteamserver.domain.bookmark.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yteamserver.domain.bookmark.domain.StoreBookmark;

public interface StoreBookmarkRepository extends JpaRepository<StoreBookmark, Long> {
    Integer countByStoreId(Long storeId);
}
