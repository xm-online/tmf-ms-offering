package com.icthh.xm.tmf.ms.offering.config;

import com.icthh.xm.commons.config.client.service.TenantConfigService;
import com.icthh.xm.commons.lep.commons.CommonsService;
import com.icthh.xm.commons.permission.service.PermissionCheckService;
import com.icthh.xm.tmf.ms.offering.lep.XmMsLepProcessingApplicationListener;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class LepAppEventListenerConfiguration {

    @Bean
    XmMsLepProcessingApplicationListener buildLepProcessingApplicationListener(
        TenantConfigService tenantConfigService,
        @Qualifier("loadBalancedRestTemplate") RestTemplate restTemplate,
        CommonsService commonsService,
        PermissionCheckService permissionCheckService) {

        return new XmMsLepProcessingApplicationListener(
            tenantConfigService,
            restTemplate,
            commonsService,
            permissionCheckService);
    }
}
