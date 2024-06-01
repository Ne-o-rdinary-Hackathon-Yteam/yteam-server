package yteamserver.domain.common.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TokenDto {
    @NotBlank
    private String token;
}
