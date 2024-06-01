package yteamserver.domain.users.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yteamserver.domain.users.presentation.response.UserCharacterResponse;
import yteamserver.domain.users.domain.repository.UserCharacterRepository;
import yteamserver.domain.users.domain.repository.UserRepository;
import yteamserver.domain.users.domain.Users;
import yteamserver.domain.users.domain.UsersCharacters;
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

    public void updateUserPoints(String token, Integer points) {
        Users user = userRepository.findByToken(token)
                .orElseThrow(() -> new GeneralException(ErrorCode.USER_NOT_FOUND));

        Integer updatedPoints = user.getPoints() + points;

        if(updatedPoints < 0) {
            throw new GeneralException(ErrorCode.POINTS_NOT_ENOUGH);
        }

        user.builder()
                .points(updatedPoints)
                .build();

        userRepository.save(user);
    }
}
