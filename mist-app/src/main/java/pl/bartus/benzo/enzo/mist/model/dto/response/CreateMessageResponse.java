package pl.bartus.benzo.enzo.mist.model.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateMessageResponse {
    String id;
    LocalDateTime sendAt;
}
