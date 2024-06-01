package yteamserver.domain.store.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import yteamserver.domain.store.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {

    Optional<Store> findByStoreName(String storeName);

    @Query(value = "SELECT * FROM store s INNER JOIN video v on s.id = v.store_id ORDER BY v.view_count DESC LIMIT 6", nativeQuery = true)
    List<Store> findAllByViewCount();
}
