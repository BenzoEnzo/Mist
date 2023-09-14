package pl.bartus.benzo.enzo.mist.resources.external;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@PropertySource(value = "classpath:api.integration.properties")
@ConfigurationProperties(prefix = "crypto")
public class ExternalApi {
    private String msg;
}
