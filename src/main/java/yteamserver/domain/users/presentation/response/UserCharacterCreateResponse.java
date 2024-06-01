package yteamserver.domain.users.presentation.response;

import lombok.Builder;
import lombok.Getter;
import yteamserver.domain.users.domain.UsersCharacters;

@Getter
@Builder
public class UserCharacterCreateResponse {
    private final Long id;

    public static UserCharacterCreateResponse from(UsersCharacters usersCharacters) {
        return UserCharacterCreateResponse.builder()
                .id(usersCharacters.getId())
                .build();
    }
}
