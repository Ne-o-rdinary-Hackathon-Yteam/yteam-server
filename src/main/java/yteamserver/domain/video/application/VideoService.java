package yteamserver.domain.video.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yteamserver.domain.store.domain.Store;
import yteamserver.domain.store.domain.repository.StoreRepository;
import yteamserver.domain.users.repository.UserRepository;
import yteamserver.domain.users.repository.Users;
import yteamserver.domain.video.domain.Video;
import yteamserver.domain.video.domain.repository.VideoRepository;
import yteamserver.domain.video.dto.CreateVideoReq;
import yteamserver.domain.video.dto.CreateVideoRes;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class VideoService {

    private final VideoRepository videoRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    @Transactional
    public CreateVideoRes createVideo(CreateVideoReq createVideoReq) {

        // To-do 유저 도메인 구현되고 수정해야함.
        Users users = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        // Store
        Store store = storeRepository.findByStoreName(createVideoReq.getStoreName()).orElseThrow(RuntimeException::new);
        System.out.println("store = " + store.getStoreName());

        Video video = Video.builder()
                .users(users)
                .title(createVideoReq.getTitle())
                .content(createVideoReq.getContent())
                .store(store)
                .videoUrl("temp") // 비디오 업로드 기능 구현 후 입력
                .build();


        videoRepository.save(video);

        return CreateVideoRes.builder()
                .id(video.getId())
                .build();

    }
}
