package pl.bartus.benzo.enzo.mist.resources;

import org.springframework.http.ResponseEntity;
import pl.bartus.benzo.enzo.mist.model.dto.request.CreateMessageRequest;
import pl.bartus.benzo.enzo.mist.model.dto.request.ReadMessageRequest;

public interface CryptoMessageApi {
    ResponseEntity<String> getMessages();
    ResponseEntity<String> createMessage(CreateMessageRequest createMessageRequest);
    ResponseEntity<String> readMessage(ReadMessageRequest readMessageRequest);
}
