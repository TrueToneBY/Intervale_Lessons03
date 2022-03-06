package com.intervale.cources.library.external.alfabank.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "integration.alfa-bank")
@Data
public class AlfaBankConfig {
    private String baseUrl;
}
