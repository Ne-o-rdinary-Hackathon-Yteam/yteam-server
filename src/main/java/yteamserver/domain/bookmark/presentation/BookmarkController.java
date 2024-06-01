package yteamserver.domain.bookmark.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yteamserver.domain.bookmark.application.BookmarkService;
import yteamserver.domain.bookmark.dto.VideoBookmarkReq;
import yteamserver.global.response.Response;

@Tag(name = "Bookmark", description = "Bookmark API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/bookmarks")
public class BookmarkController {
    private final BookmarkService bookmarkService;

    @Operation(summary = "영상 북마크 등록", description = "유저가 영상의 북마크 아이콘을 눌렀을 때 북마크를 등록합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "영상 북마크 등록 성공", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = VideoBookmarkReq.class))}),
            @ApiResponse(responseCode = "400", description = "이미 북마크로 등록된 비디오입니다.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없습니다.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "404", description = "비디오가 존재하지 않습니다.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "500", description = "영상 북마크 등록 실패", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))})
    })
    @PostMapping("/videos")
    public ResponseEntity<Response> createVideoBookmark(@RequestBody VideoBookmarkReq req) {
        bookmarkService.createVideoBookmark(req.getToken(), req.getVideoId());
        return Response.of(HttpStatus.OK);
    }

    @Operation(summary = "영상 북마크 삭제", description = "유저가 북마크한 영상을 북마크에서 제거합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "영상 북마크 삭제 성공", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = VideoBookmarkReq.class))}),
            @ApiResponse(responseCode = "400", description = "북마크로 등록되지 않은 비디오입니다.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없습니다.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "404", description = "비디오가 존재하지 않습니다.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "500", description = "영상 북마크 삭제 실패", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))})
    })
    @DeleteMapping("/videos")
    public ResponseEntity<Response> deleteVideoBookmark(@RequestBody VideoBookmarkReq req) {
        bookmarkService.deleteVideoBookmark(req.getToken(), req.getVideoId());
        return Response.of(HttpStatus.OK);
    }
}
