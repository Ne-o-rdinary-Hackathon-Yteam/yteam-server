package yteamserver.domain.users.repository;

import lombok.Builder;
import yteamserver.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Column(name = "token")
    private String token;


    @Builder
    public Users(String name, String profileUrl, String token) {
        this.name = name;
        this.profileUrl = profileUrl;
        this.token = token;
    }
}
