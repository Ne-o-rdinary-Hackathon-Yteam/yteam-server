package yteamserver;

import yteamserver.global.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public ResponseEntity<Response> test() {
        return Response.of(HttpStatus.OK);
    }

    @GetMapping("/test2")
    public ResponseEntity<Response> test2() {
        return Response.of(HttpStatus.OK, "Hello, World!");
    }


//    @GetMapping("/test3")
//    public ResponseCustom<?> test2() {
//        return ResponseCustom.OK(new Message("a"));
//    }

}
