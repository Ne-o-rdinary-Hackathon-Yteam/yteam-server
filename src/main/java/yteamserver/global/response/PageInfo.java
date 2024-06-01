package yteamserver.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PageInfo {

    private Integer page;
    private Integer size;
    private Boolean hasNext;
    private Long totalElements;
}