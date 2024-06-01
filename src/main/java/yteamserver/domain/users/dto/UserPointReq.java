package yteamserver.domain.users.dto;

import lombok.Getter;

@Getter
public class UserPointReq {
    private String token;
    private Integer points;
}
