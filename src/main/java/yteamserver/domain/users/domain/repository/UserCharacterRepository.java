package yteamserver.domain.users.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yteamserver.domain.users.domain.Users;
import yteamserver.domain.users.domain.UsersCharacters;

import java.util.List;

public interface UserCharacterRepository extends JpaRepository<UsersCharacters, Long> {
    List<UsersCharacters> findByUsers(Users user);
}
