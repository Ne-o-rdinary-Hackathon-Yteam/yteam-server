package yteamserver.domain.users.domain;

import lombok.Getter;

@Getter
public enum Level {
    SEED(1, "씨앗"),
    SPROUT(2, "새싹"),
    HOST(3, "성체");

    private final Integer levelValue;
    private final String levelName;

    Level(Integer levelValue, String levelName) {
        this.levelValue = levelValue;
        this.levelName = levelName;
    }
}
