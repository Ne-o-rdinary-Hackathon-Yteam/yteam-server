package yteamserver.domain.store.repository;

import lombok.Builder;
import yteamserver.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import yteamserver.domain.store.Category;

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

//    @Column(name = "category")
//    private Category category;


    @Builder
    public Store(String storeName) {
        this.storeName = storeName;
    }
}
