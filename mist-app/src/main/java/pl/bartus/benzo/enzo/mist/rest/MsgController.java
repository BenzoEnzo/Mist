package pl.bartus.benzo.enzo.mist.rest;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bartus.benzo.enzo.mist.model.dto.request.CreateMessageRequest;
import pl.bartus.benzo.enzo.mist.model.dto.request.ReadMessageRequest;
import pl.bartus.benzo.enzo.mist.resources.CryptoMessageApi;

@RestController
@RequestMapping("/api/mist")
public class MsgController {
    private final CryptoMessageApi cryptoMessageApi;

    public MsgController(CryptoMessageApi cryptoMessageApi) {
        this.cryptoMessageApi = cryptoMessageApi;
    }
    @GetMapping
    public ResponseEntity<String> getMessages(){
        return cryptoMessageApi.getMessages();
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createMessage(@RequestBody CreateMessageRequest createMessageRequest){
        return cryptoMessageApi.createMessage(createMessageRequest);
    }

    @PostMapping(value = "/read", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> readMessage(@RequestBody ReadMessageRequest readMessageRequest){
        return cryptoMessageApi.readMessage(readMessageRequest);
    }
}
