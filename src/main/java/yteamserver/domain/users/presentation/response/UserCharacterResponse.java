package yteamserver.domain.users.presentation.response;

import lombok.Builder;
import lombok.Getter;
import yteamserver.domain.characters.Kind;
import yteamserver.domain.characters.domain.Characters;
import yteamserver.domain.users.repository.UsersCharacters;

@Getter
@Builder
public class UserCharacterResponse {
    private Long id;
    private String imageUrl;
    private Integer level;
    private Kind kind;
    private Integer exp;

    public static UserCharacterResponse from(Characters characters, UsersCharacters usersCharacters) {
        return UserCharacterResponse.builder()
                .id(usersCharacters.getId())
                .imageUrl(characters.getImageUrl())
                .level(usersCharacters.getLevel())
                .kind(characters.getKind())
                .exp(usersCharacters.getExp())
                .build();
    }
}
