package yteamserver.domain.users.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yteamserver.domain.users.domain.Users;
import yteamserver.domain.users.domain.UsersCharacters;

import java.util.Optional;

public interface UserCharacterRepository extends JpaRepository<UsersCharacters, Long> {
    Optional<UsersCharacters> findByUsers(Users user);
}
