package yteamserver.domain.users.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yteamserver.domain.users.application.UserService;
import yteamserver.domain.users.presentation.request.UserCharacterCreateRequest;
import yteamserver.domain.users.presentation.response.UserCharacterCreateResponse;
import yteamserver.domain.users.presentation.response.UserCharacterGetResponse;
import yteamserver.global.response.Response;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{user_id}/character")
    public ResponseEntity<Response> getUserCharacter(@PathVariable("user_id") Long userId) {
        UserCharacterGetResponse response = userService.getUserCharacter(userId);

        return Response.of(HttpStatus.OK, response);
    }

    @PostMapping("/{user_id}/character")
    public ResponseEntity<Response> createUserCharacter(@PathVariable("user_id") Long userId,
                                                        @RequestBody UserCharacterCreateRequest request) {
        UserCharacterCreateResponse response = userService.createUserCharacter(userId, request);

        return Response.of(HttpStatus.CREATED, response);
    }

}
