package pl.bartus.benzo.enzo.mist.model.dto.response;
import java.time.LocalDateTime;

public record CreateMessageResponse(
        String id,
        LocalDateTime sendAt
){}
