package yteamserver.domain.store.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import yteamserver.domain.store.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {

    Optional<Store> findByStoreName(String storeName);

    @Query(value = "SELECT s.* FROM store s\n" +
            "JOIN ( \n" +
            "    SELECT DISTINCT v.store_id FROM video v ORDER BY v.view_count DESC\n" +
            ") AS top_stores\n" +
            "ON s.id = top_stores.store_id LIMIT 6", nativeQuery = true)
    List<Store> findAllByViewCount();

    @Query(value = "SELECT s.* FROM store s\n" +
            " JOIN video v" +
            " ON s.id = v.store_id ORDER BY v.created_at DESC LIMIT 10", nativeQuery = true)
    List<Store> findRecentlyTop();
}
