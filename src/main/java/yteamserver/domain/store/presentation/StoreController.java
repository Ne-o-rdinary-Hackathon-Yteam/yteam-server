package yteamserver.domain.store.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yteamserver.domain.store.application.StoreService;
import yteamserver.domain.store.dto.GetTopStoresRes;
import yteamserver.global.response.Response;

@Tag(name = "Store", description = "Store API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {
    private final StoreService storeService;

    @Operation(summary = "요즘 뜨는 셀러 TOP6", description = "메인 화면에서 숏폼 영상 조회수 상위 6개의 업체를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요즘 뜨는 셀러 TOP6 조회 성공",
                    content = @Content(schema = @Schema(implementation = GetTopStoresRes.class))),
            @ApiResponse(responseCode = "500", description = "서버 에러 발생",
                    content = @Content(schema = @Schema(implementation = Response.class)))
    })
    @GetMapping("/top")
    public ResponseEntity<Response> getTopStore() {
        return Response.of(HttpStatus.OK, storeService.getTopStore());
    }
}
