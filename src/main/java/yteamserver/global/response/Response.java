package yteamserver.global.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import yteamserver.global.error.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@RequiredArgsConstructor
public class Response {
    private final Boolean success;
    private final Integer code;
    private final String message;
    @JsonInclude(Include.NON_NULL)
    private final Object data;

    // HttpStatus에 대한 응답
    public static ResponseEntity<Response> of(HttpStatus status) {
        return new ResponseEntity<>(
                new Response(true, status.value(), status.getReasonPhrase(), null),
                status
        );
    }

    // ErrorCode에 대한 응답
    public static ResponseEntity<Response> of(ErrorCode errorCode) {
        return of(errorCode, null);
    }

    public static ResponseEntity<Response> of(ErrorCode errorCode, String message) {
        return new ResponseEntity<>(
                new Response(false, errorCode.getCode(), errorCode.getErrorMessage(message), null),
                errorCode.getHttpStatus()
        );
    }

    // 데이터에 대한 응답
    public static ResponseEntity<Response> of(HttpStatus status, Object data) {
        return new ResponseEntity<>(
                new Response(true, status.value(), status.getReasonPhrase(), data),
                status
        );
    }
}

