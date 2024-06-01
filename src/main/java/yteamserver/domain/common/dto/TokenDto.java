package yteamserver.domain.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto {
    @NotBlank
    @Schema(type = "string", description = "사용자 토큰",
            example = "d6f6d982-cb17-4ce5-aab4-ba16e2e5f1d4")
    private String token;
}
