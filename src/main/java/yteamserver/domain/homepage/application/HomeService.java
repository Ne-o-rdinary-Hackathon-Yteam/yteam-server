package yteamserver.domain.homepage.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yteamserver.domain.bookmark.domain.repository.VideoBookmarkRepository;
import yteamserver.domain.homepage.domain.Advertisement;
import yteamserver.domain.homepage.domain.repository.AdvertisementRepository;
import yteamserver.domain.homepage.dto.ViewHomepageRes;
import yteamserver.domain.store.domain.Store;
import yteamserver.domain.store.domain.repository.StoreRepository;
import yteamserver.domain.users.domain.Users;
import yteamserver.domain.users.domain.repository.UserRepository;
import yteamserver.domain.video.domain.Video;
import yteamserver.domain.video.domain.repository.VideoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HomeService {

    private final AdvertisementRepository advertisementRepository;
    private final VideoRepository videoRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;
    private final VideoBookmarkRepository videoBookmarkRepository;

    @Transactional
    public ViewHomepageRes viewHomepage() {

        // 유저 파싱
//        Users users = userRepository.findJoinedUserById(1L).orElseThrow(RuntimeException::new);
        Users users = userRepository.findById2(1L).orElseThrow(RuntimeException::new);


        // 광고 목록 가져오기
        List<Advertisement> recentlyFiveAdvertisement = advertisementRepository.findRecentlyFive();
        List<ViewHomepageRes.AdvertisementRes> advertisementResList = recentlyFiveAdvertisement.stream()
                .map(ad -> ViewHomepageRes.AdvertisementRes.builder()
                        .id(ad.getId())
                        .title(ad.getTitle())
                        .content(ad.getContent())
                        .imageUrl(ad.getImageUrl())
                        .adUrl(ad.getAdUrl())
                        .build())
                .collect(Collectors.toList());

        // 비디오 목록 가져오기
        List<Video> recentlyFiveVideo = videoRepository.findRecentlyFive();
        List<ViewHomepageRes.VideoRes> videoResList = recentlyFiveVideo.stream()
                .map(video -> {
                    boolean isBookmarked = videoBookmarkRepository.findByUserIdAndVideoId(users.getId(), video.getId()).isPresent();
                    return ViewHomepageRes.VideoRes.builder()
                            .id(video.getId())
                            .title(video.getTitle())
                            .thumbnailUrl(video.getThumbnailUrl())
                            .bookmarked(isBookmarked)
                            .build();
                })
                .collect(Collectors.toList());

        // 요즘 뜨는 셀러 가져오기
        List<Store> recentlyTop10Seller = storeRepository.findRecentlyTop();
        List<ViewHomepageRes.StoreRes> storeResList = recentlyTop10Seller.stream()
                .map(store -> ViewHomepageRes.StoreRes.builder()
                        .id(store.getId())
                        .storeName(store.getStoreName())
                        .imgUrl(store.getImgUrl())
                        .hashtags(store.getHashtags())
                        .build())
                .collect(Collectors.toList());

//        룰렛 돌리러 고고
        Users newUser = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        int chance = newUser.getPoints() / 10;
        ViewHomepageRes.CharacterRes characterRes = ViewHomepageRes.CharacterRes.builder()
                .chance(chance)
                .imageUrl(users.getUsersCharacters().get(0).getCharacters().getImageUrl())
                .level(users.getUsersCharacters().get(0).getCharacters().getLevel())
                .kind(users.getUsersCharacters().get(0).getCharacters().getKind())
                .build();


        // 합쳐서 리턴하기
        ViewHomepageRes viewHomepageRes = ViewHomepageRes.builder()
                .advertisements(advertisementResList)
                .videos(videoResList)
                .stores(storeResList)
                .characterObject(characterRes)
                .build();

        return viewHomepageRes;

    }
}
