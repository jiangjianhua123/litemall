package org.linlinjava.litemall.core.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "litemall.paypal")
public class PayPalProperties {

    private String clientId;

    private String secret;

    private String cancelUrl;

    private String successUrl;

    private String env;

}
