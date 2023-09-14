package pl.bartus.benzo.enzo.mist.resources.external.crypto.msg;

import org.springframework.http.ResponseEntity;
import pl.bartus.benzo.enzo.mist.model.dto.request.CreateMessageRequest;
import pl.bartus.benzo.enzo.mist.model.dto.request.ReadMessageRequest;
import pl.bartus.benzo.enzo.mist.model.dto.response.CreateMessageResponse;
import pl.bartus.benzo.enzo.mist.model.dto.response.GetAllMessegesResponse;
import pl.bartus.benzo.enzo.mist.model.dto.response.ReadMessageResponse;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CryptoMessageApi {
    ResponseEntity<Mono<List<GetAllMessegesResponse>>> getMessages();
    ResponseEntity<Mono<CreateMessageResponse>> createMessage(CreateMessageRequest createMessageRequest);
    ResponseEntity<Mono<ReadMessageResponse>> readMessage(ReadMessageRequest readMessageRequest);
}
