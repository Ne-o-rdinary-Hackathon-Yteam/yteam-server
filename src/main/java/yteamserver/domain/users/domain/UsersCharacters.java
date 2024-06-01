package yteamserver.domain.users.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import yteamserver.domain.characters.domain.Characters;
import yteamserver.domain.common.BaseEntity;
import yteamserver.domain.users.domain.Level;
import yteamserver.domain.users.domain.Users;

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

    @Enumerated(value = EnumType.STRING)
    @Column(name = "level", nullable = false)
    private Level level;

    @Column(name = "exp", nullable = false)
    private Integer exp;

    @Builder
    public UsersCharacters(Users users, Characters characters, Level level, Integer exp) {
        this.users = users;
        this.characters = characters;
        this.level = level;
        this.exp = exp;
    }
}
