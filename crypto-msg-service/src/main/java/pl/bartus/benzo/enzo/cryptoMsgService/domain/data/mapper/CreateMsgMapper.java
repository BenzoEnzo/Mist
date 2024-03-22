package pl.bartus.benzo.enzo.cryptoMsgService.domain.data.mapper;

import org.springframework.web.context.annotation.ApplicationScope;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.dto.request.CreateMsgRequest;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.dto.response.CreateMsgResponse;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.entity.Msg;
import pl.bartus.benzo.enzo.cryptoMsgService.resource.TimeConverter;

import java.time.LocalDateTime;

@ApplicationScope
public class CreateMsgMapper {

    public Msg requestMapper(CreateMsgRequest createMsgRequest) {
        final LocalDateTime sendAt = LocalDateTime.now();
        final LocalDateTime deleteAt = TimeConverter.addMinutes(sendAt, createMsgRequest.deleteAfterTime());
        return new Msg(createMsgRequest.content(),createMsgRequest.deleteAfterTime(),deleteAt,sendAt);
    }

    public CreateMsgResponse responseMapper(Msg msg) {
        return new CreateMsgResponse(msg.getId(),msg.getSendAt());
    }

}
