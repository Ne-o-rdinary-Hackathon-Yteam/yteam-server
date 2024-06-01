package yteamserver.domain.bookmark.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class VideoBookmarkReq {
    private String token;
    private Long videoId;

    @Builder
    public VideoBookmarkReq(String token, Long videoId) {
        this.token = token;
        this.videoId = videoId;
    }
}
