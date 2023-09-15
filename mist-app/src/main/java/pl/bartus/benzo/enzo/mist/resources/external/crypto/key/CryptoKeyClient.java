package pl.bartus.benzo.enzo.mist.resources.external.crypto.key;


import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import pl.bartus.benzo.enzo.mist.model.dto.request.VerifyRequest;
import pl.bartus.benzo.enzo.mist.model.dto.response.VerifyResponse;
import pl.bartus.benzo.enzo.mist.resources.external.ExternalApi;
import pl.bartus.benzo.enzo.mist.resources.external.Logger;
import pl.bartus.benzo.enzo.mist.resources.external.TokenUtil;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Slf4j
@Component
public class CryptoKeyClient implements CryptoKeyApi {
    private WebClient webClient;

    @Autowired
    public CryptoKeyClient(WebClient.Builder webClientBuilder, ExternalApi externalApi) {
        this.webClient = webClientBuilder
                .baseUrl(externalApi.getKey())
                .filter(Logger.logRequest())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public ResponseEntity<Mono<VerifyResponse>> verifySecurityToken(VerifyRequest verifyRequest) {
      Mono<VerifyResponse> verifyResponse = webClient.post()
                .uri("/verify")
                .bodyValue(verifyRequest)
                .retrieve()
                .bodyToMono(VerifyResponse.class);
      VerifyResponse verifyResponse1 = Objects.requireNonNull(ResponseEntity.ok().body(verifyResponse).getBody()).block();
        if(verifyResponse1.isSuccess()){
          String token = TokenUtil.createToken(verifyRequest.encryptedKey());
          return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + token).body(verifyResponse);
      } else {
          return ResponseEntity.status(400).body(verifyResponse);
      }
    }
}
