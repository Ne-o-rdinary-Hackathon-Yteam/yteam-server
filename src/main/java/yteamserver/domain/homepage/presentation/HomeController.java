package yteamserver.domain.homepage.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yteamserver.domain.common.dto.TokenDto;
import yteamserver.domain.homepage.application.HomeService;
import yteamserver.domain.homepage.dto.ViewHomepageRes;
import yteamserver.domain.video.dto.CreateVideoReq;
import yteamserver.domain.video.dto.CreateVideoRes;
import yteamserver.global.response.Response;

@Tag(name = "Homepage", description = "Homepage API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {

    private final HomeService homeService;

    @Operation(summary = "홈 화면 조회", description = "홈 화면을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "홈 화면 조회 성공", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ViewHomepageRes.class))}),
            @ApiResponse(responseCode = "400", description = "홈 화면 조회 실패", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))})
    })
    @GetMapping("/view")
    public ResponseEntity<Response> viewHomepage(
//            @Parameter(description = "token을 입력해주세요.") @RequestBody TokenDto tokenDto
            ) {
        // 항상 로그인 했다고 생각
//        String token = tokenDto.getToken();
        ViewHomepageRes viewHomepageRes = homeService.viewHomepage();
        return Response.of(HttpStatus.OK, viewHomepageRes);
    }


}
