package pl.bartus.benzo.enzo.cryptoMsgService.domain.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.entity.Msg;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.repository.MsgRepository;

@Service
@RequiredArgsConstructor
public class BaseMsgService {
    private final MsgRepository msgRepository;

    public void saveMsg(Msg msg){
        msgRepository.save(msg);
    }

    public void deleteMsg(String id){
        msgRepository.deleteById(id);
    }
    public Msg findMsgById(String id){
        return msgRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Message with ID" + id + " doesnt exist"));
    }
}
