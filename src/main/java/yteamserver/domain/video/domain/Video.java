package yteamserver.domain.video.domain;

import lombok.Builder;
import yteamserver.domain.common.BaseEntity;
import yteamserver.domain.store.repository.Store;
import yteamserver.domain.users.repository.Users;
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

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = true)
    private Store store;

    @Column(name = "video_url")
    private String videoUrl;


    @Builder
    public Video(String title, String content, Users users, Store store, String videoUrl) {
        this.title = title;
        this.content = content;
        this.users = users;
        this.store = store;
        this.videoUrl = videoUrl;
    }
}
