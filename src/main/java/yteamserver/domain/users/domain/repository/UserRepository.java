package yteamserver.domain.users.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import yteamserver.domain.users.domain.Users;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByToken(String token);

    @Query("SELECT u FROM Users u JOIN FETCH u.usersCharacters uc JOIN FETCH uc.characters c WHERE u.id = :id")
    Optional<Users> findById2(@Param("id") long id);


}
