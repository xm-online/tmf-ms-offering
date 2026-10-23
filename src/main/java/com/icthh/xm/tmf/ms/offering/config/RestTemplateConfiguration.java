package com.icthh.xm.tmf.ms.offering.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Rest templates, moved from the removed legacy OAuth2 {@code SecurityConfiguration} unchanged:
 * the load balancer customizer is applied unless {@code ribbon.http.client.enabled} is false.
 */
@Slf4j
@Configuration
public class RestTemplateConfiguration {

    @Value("${ribbon.http.client.enabled:true}")
    private Boolean loadBalancerEnabled;

    @Bean
    @Qualifier("loadBalancedRestTemplate")
    public RestTemplate loadBalancedRestTemplate(ObjectProvider<RestTemplateCustomizer> customizerProvider) {
        RestTemplate restTemplate = new RestTemplate();

        if (loadBalancerEnabled) {
            log.info("loadBalancedRestTemplate: using Spring Cloud load balancer");
            customizerProvider.ifAvailable(customizer -> customizer.customize(restTemplate));
        }
        return restTemplate;
    }

    @Bean
    @Qualifier("vanillaRestTemplate")
    public RestTemplate vanillaRestTemplate() {
        return new RestTemplate();
    }
}
