package yteamserver.domain.users.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class UserPointReq {
    @Schema(description = "사용자 토큰",
            example = "odkaj183-ga94-9aj3-1d81-djal194ns93")
    private String token;
    @Schema(description = "포인트", example = "100 // 100포인트 증가시 +100, 감소시 -100")
    private Integer points;
}
