package pl.bartus.benzo.enzo.mist.web;

import org.springframework.http.ResponseEntity;
import pl.bartus.benzo.enzo.mist.dto.request.CreateMessageRequest;
import pl.bartus.benzo.enzo.mist.dto.request.ReadMessageRequest;
import pl.bartus.benzo.enzo.mist.dto.response.CreateMessageResponse;
import pl.bartus.benzo.enzo.mist.dto.response.GetAllMessegesResponse;
import pl.bartus.benzo.enzo.mist.dto.response.ReadMessageResponse;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CryptoMessageApi {
    ResponseEntity<Mono<List<GetAllMessegesResponse>>> getMessages();
    ResponseEntity<Mono<CreateMessageResponse>> createMessage(CreateMessageRequest createMessageRequest);
    ResponseEntity<Mono<ReadMessageResponse>> readMessage(ReadMessageRequest readMessageRequest);
}
