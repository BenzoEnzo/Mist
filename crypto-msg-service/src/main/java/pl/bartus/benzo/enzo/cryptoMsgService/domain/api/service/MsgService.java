package pl.bartus.benzo.enzo.cryptoMsgService.domain.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.api.MsgApi;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.dto.request.CreateMsgRequest;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.dto.request.ReadMsgRequest;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.dto.response.CreateMsgResponse;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.dto.response.ReadMsgResponse;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.entity.Msg;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.mapper.CreateMsgMapper;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.mapper.ReadMsgMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MsgService implements MsgApi {

    private final BaseMsgService baseMsgService;



    @Override
    public ReadMsgResponse readCryptoMessage(ReadMsgRequest readMsgRequest){
        ReadMsgMapper readMsgMapper = new ReadMsgMapper();
        Msg msg = baseMsgService.findMsgById(readMsgRequest.id());
        ReadMsgResponse readMsgResponse = readMsgMapper.responseMapper(msg);

        baseMsgService.deleteMsg(readMsgRequest.id());

        return readMsgResponse;
    }

    @Override
    public CreateMsgResponse createCryptoMessage(CreateMsgRequest createMsgRequest) {
        CreateMsgMapper createMsgMapper = new CreateMsgMapper();
        Msg msg = createMsgMapper.requestMapper(createMsgRequest);

        baseMsgService.saveMsg(msg);

        return createMsgMapper.responseMapper(msg);
    }
}
