package com.icthh.xm.tmf.ms.offering.config;

import static org.mockito.Mockito.mock;

import com.icthh.xm.commons.config.client.repository.CommonConfigRepository;
import com.icthh.xm.commons.config.client.repository.TenantListRepository;
import com.icthh.xm.commons.config.client.service.TenantAliasService;
import com.icthh.xm.commons.config.client.service.TenantAliasServiceImpl;
import com.icthh.xm.commons.lep.groovy.GroovyLepEngineConfiguration;
import com.icthh.xm.commons.lep.spring.LepUpdateMode;
import com.icthh.xm.commons.logging.config.LoggingConfigService;
import com.icthh.xm.commons.logging.config.LoggingConfigServiceStub;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestLepConfiguration extends GroovyLepEngineConfiguration {

    public TestLepConfiguration(@Value("${spring.application.name}") String appName) {
        super(appName);
    }

    @Override
    public LepUpdateMode lepUpdateMode() {
        return LepUpdateMode.SYNCHRONOUS;
    }

    @Bean
    public LoggingConfigService LoggingConfigService() {
        return new LoggingConfigServiceStub();
    }

    @Bean
    public TenantAliasService tenantAliasService() {
        return new TenantAliasServiceImpl(mock(CommonConfigRepository.class), mock(TenantListRepository.class));
    }

}
