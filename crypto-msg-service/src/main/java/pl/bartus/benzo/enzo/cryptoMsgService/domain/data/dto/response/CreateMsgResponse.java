package pl.bartus.benzo.enzo.cryptoMsgService.domain.data.dto.response;

import java.time.LocalDateTime;

public record CreateMsgResponse(String id, LocalDateTime sendAt) {}
