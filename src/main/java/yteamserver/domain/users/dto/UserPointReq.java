package yteamserver.domain.users.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class UserPointReq {
    @Schema(description = "사용자 토큰",
            example = "d6f6d982-cb17-4ce5-aab4-ba16e2e5f1d4")
    private String token;
    @Schema(description = "포인트", example = "100 // 100포인트 증가시 +100, 감소시 -100")
    private Integer points;
}
