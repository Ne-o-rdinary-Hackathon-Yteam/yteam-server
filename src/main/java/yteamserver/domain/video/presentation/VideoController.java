package yteamserver.domain.video.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yteamserver.domain.video.application.VideoService;
import yteamserver.domain.video.dto.CreateVideoReq;
import yteamserver.domain.video.dto.GetVidedoRes;
import yteamserver.global.response.Response;


@Tag(name = "Video", description = "Video API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/videos")
public class VideoController {

    private final VideoService videoService;


    @Operation(summary = "숏폼 비디오 업로드", description = "숏폼 비디오를 업로드합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "비디오 생성 성공", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "400", description = "비디오 생성 실패", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))})
    })
    @PostMapping("/create")
    public ResponseEntity<Response> createVideo(
            @Parameter(description = "게시물의 id를 입력해주세요.") @ModelAttribute CreateVideoReq createVideoReq
    ) {
        videoService.createVideo(createVideoReq);
        return Response.of(HttpStatus.CREATED);
    }

    @Operation(summary = "숏폼 비디오 조회", description = "숏폼 비디오를 10개 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "비디오 조회 성공", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "400", description = "비디오 조회 실패", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))})
    })
    @GetMapping("/get")
    public ResponseEntity<Response> getVideo(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by(Sort.Order.desc("createdAt")));
        Page<GetVidedoRes> videos = videoService.getVideo(pageable);
        return Response.of(HttpStatus.OK, videos);
    }


}
