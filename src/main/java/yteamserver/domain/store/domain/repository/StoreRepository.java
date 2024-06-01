package yteamserver.domain.store.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yteamserver.domain.store.domain.Store;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {

    Optional<Store> findByStoreName(String storeName);
}
