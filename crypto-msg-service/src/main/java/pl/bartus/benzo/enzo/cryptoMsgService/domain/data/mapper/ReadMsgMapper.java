package pl.bartus.benzo.enzo.cryptoMsgService.domain.data.mapper;

import org.springframework.web.context.annotation.ApplicationScope;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.dto.response.ReadMsgResponse;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.entity.Msg;

@ApplicationScope
public class ReadMsgMapper {
    public ReadMsgResponse responseMapper(Msg msg) {
        return new ReadMsgResponse(msg.getContent());
    }
}