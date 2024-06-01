package yteamserver.domain.users.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yteamserver.domain.characters.domain.Characters;
import yteamserver.domain.characters.domain.Kind;
import yteamserver.domain.characters.domain.repository.CharacterRepository;
import yteamserver.domain.users.presentation.request.UserCharacterCreateRequest;
import yteamserver.domain.users.presentation.response.UserCharacterCreateResponse;
import yteamserver.domain.users.presentation.response.UserCharacterGetResponse;
import yteamserver.domain.users.domain.repository.UserCharacterRepository;
import yteamserver.domain.users.domain.repository.UserRepository;
import yteamserver.domain.users.domain.Users;
import yteamserver.domain.users.domain.UsersCharacters;
import yteamserver.global.error.ErrorCode;
import yteamserver.global.error.GeneralException;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserCharacterRepository userCharacterRepository;
    private final CharacterRepository characterRepository;

    public UserCharacterGetResponse getUserCharacter(Long userId) {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new GeneralException(ErrorCode.USER_NOT_FOUND));

        List<UsersCharacters> usersCharactersList = userCharacterRepository.findByUsers(user);

        if (usersCharactersList.isEmpty()) {
            throw new GeneralException(ErrorCode.USER_CHARACTER_NOT_FOUND);
        }

        UsersCharacters maxLevelUsersCharacters = usersCharactersList.stream()
                .max(Comparator.comparing(uc -> uc.getCharacters().getLevel()))
                .orElseThrow(() -> new GeneralException(ErrorCode.USER_CHARACTER_NOT_FOUND));

        UserCharacterGetResponse response = UserCharacterGetResponse.from(maxLevelUsersCharacters.getCharacters(), maxLevelUsersCharacters);

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

    @Transactional
    public UserCharacterCreateResponse createUserCharacter(Long userId, UserCharacterCreateRequest request) {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new GeneralException(ErrorCode.USER_NOT_FOUND));

        Characters character = characterRepository.findByKindAndLevel(Kind.fromKind(request.getCharacterName()), 1)
                .orElseThrow(() -> new GeneralException(ErrorCode.CHARACTER_NOT_FOUND));

        UsersCharacters usersCharacters = UsersCharacters.builder()
                .users(user)
                .characters(character)
                .exp(0)
                .build();

        usersCharacters = userCharacterRepository.save(usersCharacters);

        return UserCharacterCreateResponse.from(usersCharacters);
    }
}
