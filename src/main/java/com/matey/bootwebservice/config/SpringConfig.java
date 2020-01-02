package com.matey.bootwebservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;
import java.util.UUID;

@Configuration
public class SpringConfig {
    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> Optional.of(UUID.randomUUID().toString());
    }
}
