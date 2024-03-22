package pl.bartus.benzo.enzo.cryptoMsgService.domain.data.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@Getter
public class Msg {

    private String id;
    private String content;
    private String key;
    private LocalDateTime sendAt;
    private LocalDateTime openAt;
    private LocalDateTime deleteAt;
    private int deleteAfter;

    public Msg(){}

    public Msg(String content, int deleteAfter, LocalDateTime deleteAt, LocalDateTime sendAt) {
        this.content = content;
        this.deleteAfter = deleteAfter;
        this.deleteAt = deleteAt;
        this.sendAt = sendAt;
    }

    public Msg(String content){
        this.content = content;
    }
}
