package yteamserver.domain.video.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetVidedoRes {
    private Long id;
    private String userName;
    private Long storeId;
    private String title;
    private String ThumbnailUrl;
    private Integer viewCount;
    private String videoUrl;
}
