package yteamserver.domain.users.domain;

import lombok.Getter;

@Getter
public enum Level {
    SEED(1, "씨앗"),
    SPROUT(2, "새싹"),
    CARROT(3, "당근"),
    CORN(3, "옥수수"),
    SWEET_POTATO(3, "고구마"),
    CABBAGE(3, "양배추"),
    APPLE(3, "사과"),
    POTATO(3, "감자");

    private final Integer levelValue;
    private final String levelName;

    Level(Integer levelValue, String levelName) {
        this.levelValue = levelValue;
        this.levelName = levelName;
    }
}
