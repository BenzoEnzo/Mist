package pl.bartus.benzo.enzo.mist.resources.external.crypto.key;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import pl.bartus.benzo.enzo.mist.model.dto.request.CreateMessageRequest;
import pl.bartus.benzo.enzo.mist.model.dto.request.VerifyKeyRequest;
import pl.bartus.benzo.enzo.mist.model.dto.response.CreateMessageResponse;
import pl.bartus.benzo.enzo.mist.model.dto.response.VerifyKeyResponse;
import pl.bartus.benzo.enzo.mist.resources.external.ExternalApi;
import pl.bartus.benzo.enzo.mist.resources.external.Logger;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class CryptoKeyClient implements CryptoKeyApi {
    private WebClient webClient;
    @Autowired
    public CryptoKeyClient(WebClient.Builder webClientBuilder, ExternalApi externalApi){
        this.webClient = webClientBuilder
                .baseUrl(externalApi.getKey())
                .filter(Logger.logRequest())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public ResponseEntity<Mono<VerifyKeyResponse>> verifySecurityToken(VerifyKeyRequest verifyKeyRequest){
        Mono<VerifyKeyResponse> responseBody = webClient.post()
                .uri("/verify")
                .bodyValue(verifyKeyRequest)
                .retrieve()
                .bodyToMono(VerifyKeyResponse.class);
        return ResponseEntity.ok().body(responseBody);
    }
}
