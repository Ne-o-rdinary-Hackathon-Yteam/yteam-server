package yteamserver.domain.homepage.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import yteamserver.domain.characters.domain.Kind;
import yteamserver.domain.users.domain.Level;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViewHomepageRes {

    @Schema(description = "광고 목록을 출력합니다.")
    private List<AdvertisementRes> advertisements;

    @Schema(description = "비디오 목록을 출력합니다.")
    private List<VideoRes> videos;

    @Schema(description = "셀러 목록을 출력합니다.")
    private List<StoreRes> stores;

    private CharacterRes characterObjet;


    @Data
    @Builder
    public static class AdvertisementRes {

        @Schema(type = "long", example = "1", description = "광고의 id를 출력합니다.")
        private Long id;

        @Schema(type = "string", example = "딸기가 제일 맛있는 시즌이에요!", description = "광고 제목을 출력합니다.")
        private String title;

        @Schema(type = "string", example = "제철 딸기, 맛있게 먹고 싶다면 담음농장으로", description = "광고 내용을 출력합니다.")
        private String content;

        @Schema(type = "string", example = "https://neordinary.s3.eu-north-1.amazonaws.com/beans.png", description = "광고 이미지를 출력합니다.")
        private String imageUrl;

        @Schema(type = "string", example = "https://smartstore.naver.com", description = "광고 링크로 이동합니다.")
        private String adUrl;
    }

    @Data
    @Builder
    public static class VideoRes {
        @Schema(type = "long", example = "1", description = "비디오 id를 출력합니다.")
        private Long id;

        @Schema(type = "string", example = "고구마 이런 식으로 먹을 수 있어요!", description = "비디오 title을 출력합니다.")
        private String title;

        @Schema(type = "string", example = "https://neordinary.s3.eu-north-1.amazonaws.com/beans.png", description = "비디오 썸네일 url을 출력합니다.")
        private String thumbnailUrl;

        @Schema(type = "boolean", example = "true", description = "북마크 여부를 출력합니다.")
        private Boolean bookmarked;
    }

    @Data
    @Builder
    public static class StoreRes {
        @Schema(type = "long", example = "1", description = "Store id를 출력합니다.")
        private Long id;

        @Schema(type = "string", example = "담음 농장", description = "Store 이름을 출력합니다.")
        private String storeName;

        @Schema(type = "string", example = "https://neordinary.s3.eu-north-1.amazonaws.com/beans.png", description = "Store image URL을 출력합니다.")
        private String imgUrl;

        @Schema(type = "string", example = "체리#비타민#영양가", description = "hashtags를 출력합니다.")
        private String hashtags;
    }

    @Data
    @Builder
    public static class CharacterRes {
        @Schema(type = "enum", example = "당근", description = "캐릭터의 타입을 반환합니다.")
        private Kind kind;

        @Schema(type = "string", example = "https://neordinary.s3.eu-north-1.amazonaws.com/danggeun.png", description = "캐릭터 이미지의 url을 출력합니다.")
        private String cUrl;

        @Schema(type = "integer", example = "3", description = "룰렛 기회를 출력합니다.")
        private Integer chance;

        @Schema(type = "enum", example = "1", description = "캐릭터 레벨을 출력합니다.")
        private Integer level;
    }



}
