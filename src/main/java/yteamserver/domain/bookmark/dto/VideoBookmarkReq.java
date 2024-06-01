package yteamserver.domain.bookmark.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
public class VideoBookmarkReq {
    @Schema(description = "사용자 토큰",
            example = "odkaj183-ga94-9aj3-1d81-djal194ns93")
    @NotNull
    private String token;

    @Schema(description = "북마크할 비디오 아이디", example = "1")
    private Long videoId;

    @Builder
    public VideoBookmarkReq(String token, Long videoId) {
        this.token = token;
        this.videoId = videoId;
    }
}
