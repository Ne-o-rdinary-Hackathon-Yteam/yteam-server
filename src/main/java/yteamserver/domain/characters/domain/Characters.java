package yteamserver.domain.characters.domain;

import yteamserver.domain.characters.Kind;
import yteamserver.domain.common.BaseEntity;
import yteamserver.domain.users.repository.Users;
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

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "level", nullable = false)
    private Integer level;

    @Column(name = "kind", nullable = false)
    private Kind kind;
}
