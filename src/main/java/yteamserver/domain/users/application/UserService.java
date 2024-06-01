package yteamserver.domain.users.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yteamserver.domain.users.presentation.response.UserCharacterResponse;
import yteamserver.domain.users.repository.UserCharacterRepository;
import yteamserver.domain.users.repository.UserRepository;
import yteamserver.domain.users.repository.Users;
import yteamserver.domain.users.repository.UsersCharacters;
import yteamserver.global.error.ErrorCode;
import yteamserver.global.error.GeneralException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserCharacterRepository userCharacterRepository;

    public UserCharacterResponse getUserCharacter(Long userId) {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new GeneralException(ErrorCode.USER_NOT_FOUND));

        UsersCharacters usersCharacters = userCharacterRepository.findByUsers(user)
                .orElseThrow(() -> new GeneralException(ErrorCode.USER_CHARACTER_NOT_FOUND));

        UserCharacterResponse response = UserCharacterResponse.from(usersCharacters.getCharacters(), usersCharacters);

        return response;
    }
}
