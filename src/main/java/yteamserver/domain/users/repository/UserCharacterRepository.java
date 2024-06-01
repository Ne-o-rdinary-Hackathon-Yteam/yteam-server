package yteamserver.domain.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCharacterRepository extends JpaRepository<UsersCharacters, Long> {
    Optional<UsersCharacters> findByUsers(Users user);
}
