package yteamserver.domain.users.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yteamserver.domain.users.domain.Users;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByToken(String token);
}
