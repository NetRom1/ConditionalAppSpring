package ru.nrv.conditionalappspring.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.nrv.conditionalappspring.system_profile.DevProfile;
import ru.nrv.conditionalappspring.system_profile.ProductionProfile;
import ru.nrv.conditionalappspring.system_profile.SystemProfile;

@Configuration
public class JavaConfig {

    @Bean
    @ConditionalOnProperty(value = "netology.profile.dev",
            havingValue = "true",
            matchIfMissing = true
    )
    public SystemProfile devProfile() {
        return new DevProfile();
    }


    @Bean
    @ConditionalOnProperty(value = "netology.profile.dev",
            havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
