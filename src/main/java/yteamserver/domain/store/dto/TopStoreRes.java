package yteamserver.domain.store.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class TopStoreRes {
    private String storeName;
    private String imgUrl;
    private Integer likeCount;
    private List<String> hashtags;

    @Builder
    public TopStoreRes(String storeName, String imgUrl, Integer likeCount, String hashtags) {
        this.storeName = storeName;
        this.imgUrl = imgUrl;
        this.likeCount = likeCount;

        if(hashtags == null) {
           return;
        }

        String[] hashtagList = hashtags.split("#");

        this.hashtags = List.of(hashtagList);
    }
}
