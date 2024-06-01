package yteamserver.domain.store.domain;

import lombok.Builder;
import yteamserver.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "store")
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "store_name")
    private String storeName;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "store_link")
    private String storeLink;

    @Column(name = "hashtags")
    private String hashtags;

    @Builder
    public Store(String storeName, String imgUrl, String hashtags) {
        this.storeName = storeName;
        this.imgUrl = imgUrl;
        this.hashtags = hashtags;
    }
}
