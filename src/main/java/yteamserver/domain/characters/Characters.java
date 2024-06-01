package yteamserver.domain.characters;

import yteamserver.domain.common.BaseEntity;
import yteamserver.domain.users.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "characters")
public class Characters extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "level")
    private Integer level;

    @Column(name = "exp")
    private Integer exp;


}
