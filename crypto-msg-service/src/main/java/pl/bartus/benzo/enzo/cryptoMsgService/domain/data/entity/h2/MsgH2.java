package pl.bartus.benzo.enzo.cryptoMsgService.domain.data.entity.h2;

import jakarta.persistence.Column;

import jakarta.persistence.Id;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.entity.Msg;

import java.time.LocalDateTime;

public class MsgH2 extends Msg {
    @Id
    private String id;
    @Column(name = "CONTENT")
    private String content;
    @Column(name = "key_msg")
    private String key;
    @Column(name = "sendAt_msg")
    private LocalDateTime sendAt;
    @Column(name = "openAt_msg")
    private LocalDateTime openAt;
    @Column(name = "deleteAt_msg")
    private LocalDateTime deleteAt;
    @Column(name = "deleteAfter_msg")
    private int deleteAfter;

    public MsgH2(Msg msg) {
        this.setId(msg.getId());
        this.setContent(msg.getContent());
        this.setKey(msg.getKey());
        this.setSendAt(msg.getSendAt());
        this.setOpenAt(msg.getOpenAt());
        this.setDeleteAt(msg.getDeleteAt());
        this.setDeleteAfter(msg.getDeleteAfter());
    }

    public MsgH2(){}

    @Override
    public String getId(){
        return id;
    }
    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public LocalDateTime getSendAt() {
        return sendAt;
    }

    @Override
    public LocalDateTime getOpenAt() {
        return openAt;
    }

    @Override
    public LocalDateTime getDeleteAt() {
        return deleteAt;
    }

    @Override
    public int getDeleteAfter() {
        return deleteAfter;
    }
}
