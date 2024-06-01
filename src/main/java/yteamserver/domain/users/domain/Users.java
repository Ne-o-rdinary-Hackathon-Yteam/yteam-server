package yteamserver.domain.users.domain;

import lombok.Builder;
import yteamserver.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class Users extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "profile_url")
    private String profileUrl;

    @Column(name = "points")
    private Integer points;

    @Column(name = "token")
    private String token;

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<UsersCharacters> usersCharacters;

    @Builder
    public Users(String name, String profileUrl, Integer points, String token, List<UsersCharacters> usersCharacters) {
        this.name = name;
        this.profileUrl = profileUrl;
        this.points = points;
        this.token = token;
        this.usersCharacters = usersCharacters;
    }
}
