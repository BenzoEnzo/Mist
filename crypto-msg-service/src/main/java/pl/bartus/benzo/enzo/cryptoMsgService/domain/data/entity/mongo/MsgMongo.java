package pl.bartus.benzo.enzo.cryptoMsgService.domain.data.entity.mongo;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.entity.Msg;

import java.time.LocalDateTime;

@Document
@Collation(value = "Msgs")
public class MsgMongo extends Msg {
    @Id
    private String id;

    @Indexed(expireAfterSeconds = 1)
    private LocalDateTime deleteAtMongo;

    public MsgMongo() {}

    public MsgMongo(Msg msg) {
        setContent(msg.getContent());
        setKey(msg.getKey());
        setSendAt(msg.getSendAt());
        setOpenAt(msg.getOpenAt());
        setDeleteAt(msg.getDeleteAt());
        setDeleteAfter(msg.getDeleteAfter());
        this.deleteAtMongo = msg.getDeleteAt();
    }

    @Override
    public LocalDateTime getDeleteAt() {
        return deleteAtMongo;
    }

    @Override
    public void setDeleteAt(LocalDateTime deleteAt) {
        super.setDeleteAt(deleteAt);
        this.deleteAtMongo = deleteAt;
    }
}
