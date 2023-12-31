package pl.bartus.benzo.enzo.mist.accessory;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class TokenUtil {
    private static final String SECRET = "BENZOENZO";

    public static String createToken(String key) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        return JWT.create()
                .withIssuer("crypto")
                .withClaim("security-key", key)
                .withExpiresAt(new Date(System.currentTimeMillis() + 3600 * 1000))
                .sign(algorithm);
    }
}
