package pl.bartus.benzo.enzo.mist.model.dto.response;



import java.time.LocalDateTime;

public record ReadMessageResponse(
        String content,
        LocalDateTime openedAt,
        boolean isSuccess
) {}
