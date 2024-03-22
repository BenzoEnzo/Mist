package pl.bartus.benzo.enzo.cryptoMsgService.domain;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.api.MsgApi;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.dto.request.CreateMsgRequest;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.dto.request.ReadMsgRequest;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.dto.response.CreateMsgResponse;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.dto.response.ReadMsgResponse;

@RestController
@RequestMapping("/api/msg")
public class MsgController {
    private final MsgApi msgApi;

    public MsgController(MsgApi msgApi) {
        this.msgApi = msgApi;
    }


    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateMsgResponse> create(@RequestBody CreateMsgRequest createMsgRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(msgApi.createCryptoMessage(createMsgRequest));
    }

    @PostMapping(value = "/read", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReadMsgResponse> read(@RequestBody ReadMsgRequest readMsgRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(msgApi.readCryptoMessage(readMsgRequest));
    }
}
