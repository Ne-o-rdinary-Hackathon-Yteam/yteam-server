package yteamserver.domain.video.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Builder
@AllArgsConstructor
public class CreateVideoReq {

    @Schema(type = "string", example = "eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2NTI3OTgxOTh9.6CoxHB_siOuz6PxsxHYQCgUT1_QbdyKTUwStQDutEd1-cIIARbQ0cyrnAmpIgi3IBoLRaqK7N1vXO42nYy4g5g", description = "유저 액세스 토큰")
    @NotNull
    private String accessToken;

    @Schema(type = "string", example = "오늘의 할인 과일", description = "숏폼에 들어갈 제목")
    private String title;

    @Schema(type = "string", example = "오늘까지 최대 30% 까지 할인합니다!", description = "숏폼 짧은 영상 소개 내용")
    private String content;

    @Schema(type = "string", example = "청년 농부", description = "가게 이름")
    private String storeName;

    @Schema(type = "string", description = "첨부할 동영상 파일", format = "binary")
    private MultipartFile video;
}
