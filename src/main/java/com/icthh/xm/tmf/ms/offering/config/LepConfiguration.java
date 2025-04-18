package com.icthh.xm.tmf.ms.offering.config;

import com.icthh.xm.commons.lep.TenantScriptStorage;
import com.icthh.xm.commons.lep.groovy.GroovyLepEngineConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LepConfiguration extends GroovyLepEngineConfiguration {

    @Value("${application.lep.tenant-script-storage}")
    private TenantScriptStorage tenantScriptStorageType;

    public LepConfiguration(@Value("${spring.application.name}") String appName) {
        super(appName);
    }

    @Override
    protected TenantScriptStorage getTenantScriptStorageType() {
        return tenantScriptStorageType;
    }
}
