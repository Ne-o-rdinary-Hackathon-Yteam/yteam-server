package yteamserver.domain.characters.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yteamserver.domain.characters.domain.Characters;
import yteamserver.domain.characters.domain.Kind;

import java.util.Optional;

public interface CharacterRepository extends JpaRepository<Characters, Long> {
    Optional<Characters> findByKind(Kind kind);
}
