package pl.bartus.benzo.enzo.mist.resources;

import org.springframework.http.ResponseEntity;
import pl.bartus.benzo.enzo.mist.model.dto.request.CreateMessageRequest;
import pl.bartus.benzo.enzo.mist.model.dto.request.ReadMessageRequest;
import pl.bartus.benzo.enzo.mist.model.dto.response.GetAllMessegesResponse;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CryptoMessageApi {
    ResponseEntity<Mono<List<GetAllMessegesResponse>>> getMessages();
    ResponseEntity<String> createMessage(CreateMessageRequest createMessageRequest);
    ResponseEntity<String> readMessage(ReadMessageRequest readMessageRequest);
}
