package yteamserver.domain.bookmark.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateVideoBookmarkReq {
    private String token;
    private Long videoId;

    @Builder
    public CreateVideoBookmarkReq(String token, Long videoId) {
        this.token = token;
        this.videoId = videoId;
    }
}
