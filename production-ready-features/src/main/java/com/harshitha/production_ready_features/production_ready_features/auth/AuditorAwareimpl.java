package com.harshitha.production_ready_features.production_ready_features.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareimpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        //get the spring context
        //get the authentication
        //get the principle
        //get the username
        return Optional.of("Harshitha Balabhadruni");
    }
}
