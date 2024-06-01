package yteamserver.domain.store.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class GetTopStoresRes {
    @Schema(description = "인기 셀러 리스트")
    private List<TopStoreRes> sellers;

    @Builder
    public GetTopStoresRes(List<TopStoreRes> sellers) {
        this.sellers = sellers;
    }
}
