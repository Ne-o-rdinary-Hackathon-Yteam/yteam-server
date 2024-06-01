package yteamserver.domain.bookmark.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
public class VideoBookmarkReq {
    @Schema(description = "사용자 토큰",
            example = "d6f6d982-cb17-4ce5-aab4-ba16e2e5f1d4")
    @NotNull
    private String token;

    @Schema(description = "북마크할 비디오 아이디", example = "47")
    private Long videoId;

    @Builder
    public VideoBookmarkReq(String token, Long videoId) {
        this.token = token;
        this.videoId = videoId;
    }
}
