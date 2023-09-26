package pl.bartus.benzo.enzo.mist.model.dto.response;


import java.time.LocalDateTime;

public record GetAllMessegesResponse(
        String id,
        String content,
        String key,
        LocalDateTime sendAt,
        LocalDateTime openAt,
        LocalDateTime deleteAt,
        boolean isSuccess,
        int deleteAfter
) {}
