package yteamserver.domain.video.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetVidedoRes {
    @Schema(description = "비디오 id", example = "1")
    private Long id;
    @Schema(description = "유저 이름", example = "홍길동")
    private String userName;
    @Schema(description = "비디오 제목", example = "비디오 제목")
    private String title;
    @Schema(description = "썸네일 이미지", example = "https://neordinary.s3.eu-north-1.amazonaws.com/apple_store_thumbnail.png")
    private String ThumbnailUrl;
    @Schema(description = "조회수", example = "100")
    private Integer viewCount;
    @Schema(description = "비디오 url", example = "https://neordinary.s3.eu-north-1.amazonaws.com/APPLE_STORE.mp4")
    private String videoUrl;
    @Schema(description = "상품 구매 링크", example = "https://smartstore.naver.com/sweetfarmers/products/5300481447?")
    private String storeLink;
}
