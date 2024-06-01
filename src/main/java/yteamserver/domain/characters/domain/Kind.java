package yteamserver.domain.characters.domain;

import lombok.Getter;
import yteamserver.global.error.ErrorCode;
import yteamserver.global.error.GeneralException;

@Getter
public enum Kind {
    CARROT("당근"),
    CORN("옥수수"),
    SWEET_POTATO("고구마"),
    CABBAGE("양배추"),
    APPLE("사과"),
    POTATO("감자");

    private final String kind;

    Kind(String kind) {
        this.kind = kind;
    }

    public static Kind fromKind(String kind) {
        for (Kind k : Kind.values()) {
            if (k.getKind().equals(kind)) {
                return k;
            }
        }
        throw new GeneralException(ErrorCode.CHARACTER_NOT_FOUND);
    }
}
