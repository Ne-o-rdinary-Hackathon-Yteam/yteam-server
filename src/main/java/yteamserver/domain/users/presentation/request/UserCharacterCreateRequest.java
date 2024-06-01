package yteamserver.domain.users.presentation.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserCharacterCreateRequest {
    @Schema(description = "캐릭터 이름",
            example = "당근")
    private String characterName;
}
