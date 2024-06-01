package yteamserver.domain.store.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class GetTopStoresRes {
    private List<TopStoreRes> sellers;

    @Builder
    public GetTopStoresRes(List<TopStoreRes> sellers) {
        this.sellers = sellers;
    }
}
