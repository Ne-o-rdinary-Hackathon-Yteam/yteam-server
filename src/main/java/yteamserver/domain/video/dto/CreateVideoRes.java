package yteamserver.domain.video.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
public class CreateVideoRes {

    @Schema( type = "string", example = "1" , description="생성된 video id를 입력합니다.")
    private Long id;


    @Builder
    public CreateVideoRes(Long id) {
        this.id = id;
    }
}
