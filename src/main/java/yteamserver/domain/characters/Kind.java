package yteamserver.domain.characters;

import lombok.Getter;

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
}
