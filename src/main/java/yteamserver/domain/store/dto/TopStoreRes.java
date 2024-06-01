package yteamserver.domain.store.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class TopStoreRes {
    private String storeName;
    private String imgUrl;
    private List<String> hashtags;

    @Builder
    public TopStoreRes(String storeName, String imgUrl, String hashtags) {
        this.storeName = storeName;
        this.imgUrl = imgUrl;

        if(hashtags == null) {
           return;
        }

        String[] hashtagList = hashtags.split("#");

        for (String hashtag : hashtagList) {
            this.hashtags.add(hashtag);
        }
    }
}
