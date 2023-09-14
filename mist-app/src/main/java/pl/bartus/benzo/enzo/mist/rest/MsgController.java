package pl.bartus.benzo.enzo.mist.rest;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bartus.benzo.enzo.mist.model.dto.request.CreateMessageRequest;
import pl.bartus.benzo.enzo.mist.model.dto.request.ReadMessageRequest;
import pl.bartus.benzo.enzo.mist.model.dto.request.VerifyKeyRequest;
import pl.bartus.benzo.enzo.mist.model.dto.response.CreateMessageResponse;
import pl.bartus.benzo.enzo.mist.model.dto.response.GetAllMessegesResponse;
import pl.bartus.benzo.enzo.mist.model.dto.response.ReadMessageResponse;
import pl.bartus.benzo.enzo.mist.model.dto.response.VerifyKeyResponse;
import pl.bartus.benzo.enzo.mist.resources.external.crypto.key.CryptoKeyApi;
import pl.bartus.benzo.enzo.mist.resources.external.crypto.msg.CryptoMessageApi;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/mist")
public class MsgController {
    private final CryptoMessageApi cryptoMessageApi;
    private final CryptoKeyApi cryptoKeyApi;

    public MsgController(CryptoMessageApi cryptoMessageApi, CryptoKeyApi cryptoKeyApi) {
        this.cryptoMessageApi = cryptoMessageApi;
        this.cryptoKeyApi = cryptoKeyApi;
    }
    @GetMapping
    public ResponseEntity<Mono<List<GetAllMessegesResponse>>> getMessages(){
        return cryptoMessageApi.getMessages();
    }

    @PostMapping(value = "/create-message", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<CreateMessageResponse>> createMessage(@RequestBody CreateMessageRequest createMessageRequest){
        return cryptoMessageApi.createMessage(createMessageRequest);
    }

    @PostMapping(value = "/read-message", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<ReadMessageResponse>> readMessage(@RequestBody ReadMessageRequest readMessageRequest){
        return cryptoMessageApi.readMessage(readMessageRequest);
    }

    @PostMapping(value = "/verify-token", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<VerifyKeyResponse>> verifySecurityToken(VerifyKeyRequest verifyKeyRequest){
        return cryptoKeyApi.verifySecurityToken(verifyKeyRequest);
    }
}
