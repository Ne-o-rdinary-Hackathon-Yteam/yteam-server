package yteamserver.domain.characters.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import yteamserver.domain.common.BaseEntity;
import yteamserver.domain.users.repository.Users;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users_characters")
public class UsersCharacters extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id")
    private Characters characters;

    @Column(name = "exp", nullable = false)
    private Integer exp;

    @Builder
    public UsersCharacters(Users users, Characters characters, Integer exp) {
        this.users = users;
        this.characters = characters;
        this.exp = exp;
    }
}
