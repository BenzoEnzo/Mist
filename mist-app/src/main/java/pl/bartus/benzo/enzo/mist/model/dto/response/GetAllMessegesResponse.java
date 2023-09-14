package pl.bartus.benzo.enzo.mist.model.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class GetAllMessegesResponse {

    private String id;
    private String content;
    private String key;
    private LocalDateTime sendAt;
    private LocalDateTime openAt;
    private LocalDateTime deleteAt;
    private boolean isSuccess;
    private int deleteAfter;

}
