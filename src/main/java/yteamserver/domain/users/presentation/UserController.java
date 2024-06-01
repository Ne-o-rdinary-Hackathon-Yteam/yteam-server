package yteamserver.domain.users.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yteamserver.domain.users.application.UserService;
import yteamserver.domain.users.presentation.response.UserCharacterResponse;
import yteamserver.global.response.Response;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{user_id}")
    public ResponseEntity<Response> getUserCharacter(@PathVariable("user_id") Long userId) {
        UserCharacterResponse response = userService.getUserCharacter(userId);

        return Response.of(HttpStatus.OK, response);
    }
}
