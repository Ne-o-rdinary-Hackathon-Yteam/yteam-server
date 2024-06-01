package yteamserver.global.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Optional;
import java.util.function.Predicate;

@Getter
public enum ErrorCode {
    INVALID_ACCESS_TOKEN(HttpStatus.UNAUTHORIZED, "유효하지 않은 엑세스 토큰입니다."),
    EXPIRED_ACCESS_TOKEN(HttpStatus.UNAUTHORIZED, "만료된 엑세스 토큰입니다."),
    INVALID_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, "유효하지 않은 리프레시 토큰입니다."),
    EXPIRED_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, "만료된 리프레시 토큰입니다."),

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다."),

    PAGE_NOT_FOUND(HttpStatus.NOT_FOUND, "요청한 페이지를 찾을 수 없습니다."),

    VIDEO_NOT_FOUND(HttpStatus.NOT_FOUND, "비디오가 존재하지 않습니다."),
    VIDEO_ALREADY_BOOKMARKED(HttpStatus.BAD_REQUEST, "이미 북마크로 등록된 비디오입니다."),
    VIDEO_BOOKMARK_NOT_FOUND(HttpStatus.BAD_REQUEST, "북마크로 등록되지 않은 비디오입니다."),

    CHARACTER_NOT_FOUND(HttpStatus.BAD_REQUEST, "캐릭터가 존재하지 않습니다."),
    USER_CHARACTER_NOT_FOUND(HttpStatus.BAD_REQUEST, "사용자의 캐릭터가 존재하지 않습니다"),

    VALIDATION_ERROR(HttpStatus.BAD_REQUEST, "입력값이 올바르지 않습니다."),
    IMAGE_NOT_FOUND(HttpStatus.BAD_REQUEST, "이미지가 존재하지 않습니다."),

    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 문제 발생, 다음에 시도해주세요.");

    public final HttpStatus httpStatus;
    public final String errorMessage;

    ErrorCode(HttpStatus httpStatus, String errorMessage) {
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

    public Integer getCode() {
        return this.httpStatus.value();
    }

    public String getErrorMessage(Throwable e) {
        return this.getErrorMessage(e.getMessage());
    }

    public String getErrorMessage(String message) {
        return Optional.ofNullable(message)
                .filter(Predicate.not(String::isBlank))
                .orElse(this.getErrorMessage());
    }
}
