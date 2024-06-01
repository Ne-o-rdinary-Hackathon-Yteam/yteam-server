package yteamserver.domain.video.domain;

import lombok.Builder;
import yteamserver.domain.common.BaseEntity;
import yteamserver.domain.store.domain.Store;
import yteamserver.domain.users.domain.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "video")
public class Video extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "view_count")
    private Integer viewCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(name = "video_url")
    private String videoUrl;

    @Column(name = "thumbnail_url")
    private String thumbnailUrl;


    @Builder
    public Video(String title, Integer viewCount, Users user, Store store, String videoUrl, String thumbnailUrl) {
        this.title = title;
        this.viewCount = viewCount;
        this.user = user;
        this.store = store;
        this.videoUrl = videoUrl;
        this.thumbnailUrl = thumbnailUrl;
    }
}
