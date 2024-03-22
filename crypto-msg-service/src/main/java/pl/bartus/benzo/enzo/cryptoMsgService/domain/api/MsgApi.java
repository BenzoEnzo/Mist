package pl.bartus.benzo.enzo.cryptoMsgService.domain.api;

import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.dto.request.CreateMsgRequest;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.dto.request.ReadMsgRequest;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.dto.response.CreateMsgResponse;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.dto.response.ReadMsgResponse;

public interface MsgApi {
    CreateMsgResponse createCryptoMessage(CreateMsgRequest createMsgRequest);
    ReadMsgResponse readCryptoMessage(ReadMsgRequest readMsgRequest);

}
