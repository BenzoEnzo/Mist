package pl.bartus.benzo.enzo.cryptoMsgService.domain.data.dto.request;

public record CreateMsgRequest(String content, int deleteAfterTime) {
}
