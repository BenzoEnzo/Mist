package pl.bartus.benzo.enzo.mist.resources.external.crypto.msg;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import pl.bartus.benzo.enzo.mist.model.dto.request.CreateMessageRequest;
import pl.bartus.benzo.enzo.mist.model.dto.request.ReadMessageRequest;
import pl.bartus.benzo.enzo.mist.model.dto.response.CreateMessageResponse;
import pl.bartus.benzo.enzo.mist.model.dto.response.GetAllMessegesResponse;
import pl.bartus.benzo.enzo.mist.model.dto.response.ReadMessageResponse;
import pl.bartus.benzo.enzo.mist.resources.external.ExternalApi;
import pl.bartus.benzo.enzo.mist.resources.external.Logger;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Component
public class CryptoMessageClient implements CryptoMessageApi {
    private WebClient webClient;
    @Autowired
    public CryptoMessageClient(WebClient.Builder webClientBuilder, ExternalApi externalApi){
        this.webClient = webClientBuilder
                .baseUrl(externalApi.getMsg())
                .filter(Logger.logRequest())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public ResponseEntity<Mono<List<GetAllMessegesResponse>>> getMessages(){
        Mono<List<GetAllMessegesResponse>> responseBody = webClient.get()
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
        return ResponseEntity.ok().body(responseBody);
    }

    public ResponseEntity<Mono<CreateMessageResponse>>createMessage(CreateMessageRequest createMessageRequest){
        Mono<CreateMessageResponse> responseBody = webClient.post()
                .uri("/create")
                .bodyValue(createMessageRequest)
                .retrieve()
                .bodyToMono(CreateMessageResponse.class);
        return ResponseEntity.ok().body(responseBody);
    }

    public ResponseEntity<Mono<ReadMessageResponse>> readMessage(ReadMessageRequest readMessageRequest) {
        Mono<ReadMessageResponse> responseBody = webClient.post()
                .uri("/read")
                .bodyValue(readMessageRequest)
                .retrieve()
                .bodyToMono(ReadMessageResponse.class);
        return ResponseEntity.ok().body(responseBody);
    }
}