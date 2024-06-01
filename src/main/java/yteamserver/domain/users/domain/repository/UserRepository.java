package yteamserver.domain.users.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import yteamserver.domain.users.domain.Users;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByToken(String token);

//    @Query("SELECT * FROM Users u JOIN UsersCharacters uc JOIN Characters c ON" +
//            " u.id = uc.users AND uc.characters = c.id")
//    Optional<Object> findJoinedUserById(long l);
}
