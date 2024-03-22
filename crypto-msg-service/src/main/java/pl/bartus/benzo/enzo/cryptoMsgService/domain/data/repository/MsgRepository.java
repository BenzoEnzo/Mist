package pl.bartus.benzo.enzo.cryptoMsgService.domain.data.repository;

import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.entity.Msg;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.repository.abstraction.BaseRepository;

import java.util.List;
import java.util.Optional;

public interface MsgRepository extends BaseRepository<Msg,String> {

    void save(Msg msg);

    Optional<Msg> findById(String id);

    List<Msg> findAll();

    void deleteById(String id);
}
