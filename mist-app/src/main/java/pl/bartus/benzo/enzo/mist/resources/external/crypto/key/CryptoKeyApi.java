package pl.bartus.benzo.enzo.mist.resources.external.crypto.key;

import org.springframework.http.ResponseEntity;
import pl.bartus.benzo.enzo.mist.model.dto.request.VerifyKeyRequest;
import pl.bartus.benzo.enzo.mist.model.dto.response.VerifyKeyResponse;
import reactor.core.publisher.Mono;

public interface CryptoKeyApi {
    ResponseEntity<Mono<VerifyKeyResponse>> verifySecurityToken(VerifyKeyRequest verifyKeyRequest);
}
