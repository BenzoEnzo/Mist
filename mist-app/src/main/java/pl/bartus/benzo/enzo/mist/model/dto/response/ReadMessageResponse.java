package pl.bartus.benzo.enzo.mist.model.dto.response;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReadMessageResponse {
    String content;
    LocalDateTime openedAt;
    boolean isSuccess;
}
