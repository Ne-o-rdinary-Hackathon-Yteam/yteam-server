package yteamserver.domain.store.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class TopStoreRes {
    @Schema(description = "셀러 이름", example = "담음농장")
    private String storeName;

    @Schema(description = "셀러 로고 이미지 URL", example = "https://yteam.s3.ap-northeast-2.amazonaws.com/store/1.jpg")
    private String imgUrl;

    @Schema(description = "좋아요 수", example = "100")
    private Integer likeCount;

    @Schema(description = "해시태그 리스트", example = "[\"담음농장\", \"유기농\",  \"농장\"]")
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
