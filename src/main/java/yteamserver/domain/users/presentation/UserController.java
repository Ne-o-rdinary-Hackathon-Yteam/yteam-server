package yteamserver.domain.users.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yteamserver.domain.users.application.UserService;
import yteamserver.domain.users.presentation.request.UserCharacterCreateRequest;
import yteamserver.domain.users.presentation.response.UserCharacterCreateResponse;
import yteamserver.domain.users.presentation.response.UserCharacterGetResponse;
import yteamserver.domain.users.dto.UserPointReq;
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

    @Operation(summary = "유저 포인트 업데이트", description = "유저의 포인트를 업데이트합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "포인트 업데이트 성공", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "400", description = "북마크로 등록되지 않은 비디오입니다.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없습니다.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "404", description = "비디오가 존재하지 않습니다.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "500", description = "영상 북마크 삭제 실패", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))})
    })
    @PatchMapping("/points")
    public ResponseEntity<Response> updateUserPoints(@RequestBody UserPointReq request) {
        userService.updateUserPoints(request.getToken(), request.getPoints());

        return Response.of(HttpStatus.OK);
    }

    @PostMapping("/{user_id}/character")
    public ResponseEntity<Response> createUserCharacter(@PathVariable("user_id") Long userId,
                                                        @RequestBody UserCharacterCreateRequest request) {
        UserCharacterCreateResponse response = userService.createUserCharacter(userId, request);

        return Response.of(HttpStatus.CREATED, response);
    }

}
