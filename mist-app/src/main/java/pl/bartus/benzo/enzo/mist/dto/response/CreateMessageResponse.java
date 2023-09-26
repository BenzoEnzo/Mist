package pl.bartus.benzo.enzo.mist.dto.response;
import java.time.LocalDateTime;

public record CreateMessageResponse(
        String id,
        LocalDateTime sendAt
){}
