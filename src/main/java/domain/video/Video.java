package domain.video;

import domain.store.Store;
import domain.users.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "user_id")
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "store_id", nullable = true)
    private Store store;

    @Column(name = "video_url")
    private String videoUrl;
}
