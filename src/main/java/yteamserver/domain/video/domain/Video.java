package yteamserver.domain.video.domain;

import yteamserver.domain.common.BaseEntity;
import yteamserver.domain.store.Store;
import yteamserver.domain.users.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Video")
public class Video extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = true)
    private Store store;

    @Column(name = "video_url")
    private String videoUrl;
}
