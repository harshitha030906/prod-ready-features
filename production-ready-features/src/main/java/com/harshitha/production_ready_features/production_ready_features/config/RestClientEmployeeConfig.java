package com.harshitha.production_ready_features.production_ready_features.config;

import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Configuration
public class RestClientEmployeeConfig {

    @Value("${employee.base.url}")
    private String Base_URL;

    @Bean
    RestClient getEmployeeRestClient(){
        return RestClient.builder()
                .baseUrl(Base_URL)
                .defaultHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .defaultStatusHandler(HttpStatusCode::is5xxServerError,(req, res) -> {
                    System.out.println(new String(res.getBody().readAllBytes()));
                    throw new RuntimeException("Server error");
                })
                .build();
    }
}
