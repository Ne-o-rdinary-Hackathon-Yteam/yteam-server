package global.error;

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

    PAGE_NOT_FOUND(HttpStatus.NOT_FOUND, "요청한 페이지를 찾을 수 없습니다."),

    EMPTY_USER_PASSWORD(HttpStatus.BAD_REQUEST, "비밀번호를 입력해주세요."),
    EMPTY_USER_NAME(HttpStatus.BAD_REQUEST, "닉네임을 입력해주세요."),
    EMPTY_USER_EMAIL(HttpStatus.BAD_REQUEST, "이메일을 입력해주세요."),
    USER_EMAIL_DUPLICATED(HttpStatus.BAD_REQUEST, "이미 가입된 이메일 주소입니다"),
    USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "회원 정보가 존재하지 않습니다."),
    USER_UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "로그인이 필요한 서비스 입니다"),
    USER_WRONG_PASSWORD(HttpStatus.BAD_REQUEST, "비밀번호가 틀렸습니다."),

    GENRE_NOT_FOUND(HttpStatus.BAD_REQUEST, "존재하지 않는 장르입니다."),
    CHARACTER_NOT_FOUND(HttpStatus.BAD_REQUEST, "캐릭터가 존재하지 않습니다."),
    MAP_NOT_FOUND(HttpStatus.BAD_REQUEST, "맵 정보가 존재하지 않습니다."),
    SCRIPT_NOT_FOUND(HttpStatus.BAD_REQUEST, "스크립트가 존재하지 않습니다."),
    GOAL_NOT_FOUND(HttpStatus.BAD_REQUEST, "존재하지 않는 목표 타입입니다."),
    ITEM_TYPE_NOT_FOUND(HttpStatus.BAD_REQUEST, "존재하지 않는 아이템 타입입니다."),
    ITEM_NOT_FOUND(HttpStatus.BAD_REQUEST, "존재하지 않는 아이템입니다."),
    INVENTORY_NOT_FOUND(HttpStatus.BAD_REQUEST, "인벤토리에 등록되지 않은 아이템입니다."),

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
