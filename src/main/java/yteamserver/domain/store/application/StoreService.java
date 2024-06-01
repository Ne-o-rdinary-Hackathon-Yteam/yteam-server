package yteamserver.domain.store.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yteamserver.domain.store.domain.Store;
import yteamserver.domain.store.domain.repository.StoreRepository;
import yteamserver.domain.store.dto.GetTopStoresRes;
import yteamserver.domain.store.dto.TopStoreRes;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;


    public GetTopStoresRes getTopStore() {
        // 비디오 테이블 참조하여 조회수 상위 6개 업체 조회
        List<Store> stores = storeRepository.findAllByViewCount();
        List<TopStoreRes> topStoreResList = new ArrayList<>();

        for (Store store : stores) {
            topStoreResList.add(TopStoreRes.builder()
                    .storeName(store.getStoreName())
                    .imgUrl(store.getImgUrl())
                    .hashtags(store.getHashtags())
                    .build());
        }

        return new GetTopStoresRes(topStoreResList);
    }
}
