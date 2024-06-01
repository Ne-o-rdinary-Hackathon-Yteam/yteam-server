package yteamserver.domain.users.presentation.response;

import lombok.Builder;
import lombok.Getter;
import yteamserver.domain.characters.domain.Kind;
import yteamserver.domain.characters.domain.Characters;
import yteamserver.domain.users.domain.UsersCharacters;

@Getter
@Builder
public class UserCharacterGetResponse {
    private final Long id;
    private final String imageUrl;
    private final Integer levelValue;
    private final String levelName;
    private final Kind kind;
    private final Integer exp;

    public static UserCharacterGetResponse from(Characters characters, UsersCharacters usersCharacters) {
        return UserCharacterGetResponse.builder()
                .id(usersCharacters.getId())
                .imageUrl(characters.getImageUrl())
                .levelValue(characters.getLevel())
                .levelName(characters.getLevelName())
                .kind(characters.getKind())
                .exp(usersCharacters.getExp())
                .build();
    }
}
