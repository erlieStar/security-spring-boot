package com.javashitang.security.autoconfigure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityMarkerConfiguration {

    @Bean
    public Marker securityMarkerBean() {
        return new Marker();
    }

    class Marker {

    }
}
