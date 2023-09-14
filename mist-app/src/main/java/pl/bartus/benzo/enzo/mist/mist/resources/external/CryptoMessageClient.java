package pl.bartus.benzo.enzo.mist.application.resources.external;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import pl.bartus.benzo.enzo.mist.application.model.dto.request.CreateMessageRequest;
import pl.bartus.benzo.enzo.mist.application.model.dto.request.ReadMessageRequest;
import pl.bartus.benzo.enzo.mist.application.resources.CryptoMessageApi;

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

    public ResponseEntity<String> getMessages(){
        return webClient.get()
                .retrieve()
                .bodyToMono(String.class)
                .map(responseBody -> ResponseEntity.ok().body(responseBody))
                .block();
    }

    public ResponseEntity<String> createMessage(CreateMessageRequest createMessageRequest){
        return webClient.post()
                .uri("/create")
                .bodyValue(createMessageRequest)
                .retrieve()
                .bodyToMono(String.class)
                .map(responseBody -> ResponseEntity.ok().body(responseBody))
                .block();
    }

    public ResponseEntity<String> readMessage(ReadMessageRequest readMessageRequest){
        return webClient.post()
                .uri("/create")
                .bodyValue(readMessageRequest)
                .retrieve()
                .bodyToMono(String.class)
                .map(responseBody -> ResponseEntity.ok().body(responseBody))
                .block();
    }
}
