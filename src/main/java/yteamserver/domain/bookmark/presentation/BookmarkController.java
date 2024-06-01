package yteamserver.domain.bookmark.presentation;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yteamserver.domain.bookmark.application.BookmarkService;
import yteamserver.domain.bookmark.dto.CreateVideoBookmarkReq;
import yteamserver.global.response.Response;

@Tag(name = "Bookmark", description = "Bookmark API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/bookmarks")
public class BookmarkController {
    private final BookmarkService bookmarkService;

    @PostMapping("/videos")
    public ResponseEntity<Response> createVideoBookmark(@RequestBody CreateVideoBookmarkReq req) {
        bookmarkService.createVideoBookmark(req.getToken(), req.getVideoId());
        return Response.of(HttpStatus.OK);
    }
}
