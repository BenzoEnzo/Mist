package pl.bartus.benzo.enzo.cryptoMsgService.domain.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.api.service.BaseMsgService;
import pl.bartus.benzo.enzo.cryptoMsgService.domain.data.repository.MsgRepository;

@Configuration
public class ProfileConfig {
    @Bean
    @Profile("atom")
    public BaseMsgService msgServiceForAtom(MsgRepository atomRepository) {
        return new BaseMsgService(atomRepository);
    }

    @Bean
    @Profile("integration")
    public BaseMsgService msgServiceForIntegration(MsgRepository integrationRepository) {
        return new BaseMsgService(integrationRepository);
    }
}
