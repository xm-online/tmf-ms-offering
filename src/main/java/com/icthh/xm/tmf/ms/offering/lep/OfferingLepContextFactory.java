package com.icthh.xm.tmf.ms.offering.lep;

import com.icthh.xm.commons.config.client.service.TenantConfigService;
import com.icthh.xm.commons.lep.api.BaseLepContext;
import com.icthh.xm.commons.lep.api.LepContextFactory;
import com.icthh.xm.commons.permission.service.PermissionCheckService;
import com.icthh.xm.lep.api.LepMethod;
import com.icthh.xm.tmf.ms.offering.config.LepContext;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;

/**
 * The {@link OfferingLepContextFactory} class.
 */
@RequiredArgsConstructor
public class OfferingLepContextFactory implements LepContextFactory {

    private final TenantConfigService tenantConfigService;

    private final RestTemplate restTemplate;

    private final PermissionCheckService permissionCheckService;

    @Override
    public BaseLepContext buildLepContext(LepMethod lepMethod) {
        LepContext lepContext = new LepContext();
        lepContext.services = new LepContext.LepServices();
        lepContext.services.permissionService = permissionCheckService;
        lepContext.services.tenantConfigService = tenantConfigService;
        lepContext.templates = new LepContext.LepTemplates();
        lepContext.templates.rest = restTemplate;
        return lepContext;
    }

}
