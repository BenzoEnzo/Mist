package pl.bartus.benzo.enzo.mist.web;

import org.springframework.http.ResponseEntity;
import pl.bartus.benzo.enzo.mist.dto.request.VerifyRequest;
import pl.bartus.benzo.enzo.mist.dto.response.VerifyResponse;
import reactor.core.publisher.Mono;

public interface CryptoKeyApi {
    ResponseEntity<Mono<VerifyResponse>> verifySecurityToken(VerifyRequest verifyRequest);
}
