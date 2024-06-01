package yteamserver.domain.video.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Builder
@AllArgsConstructor
public class CreateVideoReq {

    @Schema(type = "string", example = "d6f6d982-cb17-4ce5-aab4-ba16e2e5f1d4", description = "유저 구분용 토큰")
    private String token;

    @Schema(type = "string", example = "오늘의 할인 과일", description = "숏폼에 들어갈 제목")
    private String title;

    @Schema(type = "string", example = "오늘까지 최대 30% 까지 할인합니다!", description = "숏폼 짧은 영상 소개 내용")
    private String content;

    @Schema(type = "string", example = "청년 농부", description = "업로더 이름")
    private String name;

    @Schema(type = "Boolean", example = "true", description = "업로더 업체인지 유저인지 구분")
    private Boolean isStore;

    @Schema(type = "MultipartFile", description = "첨부할 동영상 파일", format = "binary")
    private MultipartFile video;
}
