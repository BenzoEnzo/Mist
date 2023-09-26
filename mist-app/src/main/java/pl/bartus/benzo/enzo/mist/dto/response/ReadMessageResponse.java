package pl.bartus.benzo.enzo.mist.dto.response;



import java.time.LocalDateTime;

public record ReadMessageResponse(
        String content,
        LocalDateTime openedAt,
        boolean isSuccess
) {}
