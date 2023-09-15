package pl.bartus.benzo.enzo.mist.resources.external.crypto.key;

import org.springframework.http.ResponseEntity;
import pl.bartus.benzo.enzo.mist.model.dto.request.VerifyRequest;
import pl.bartus.benzo.enzo.mist.model.dto.response.VerifyResponse;
import reactor.core.publisher.Mono;

public interface CryptoKeyApi {
    ResponseEntity<Mono<VerifyResponse>> verifySecurityToken(VerifyRequest verifyRequest);
}
