package com.icthh.xm.tmf.ms.offering.config;

import com.icthh.xm.commons.config.client.service.TenantConfigService;
import com.icthh.xm.commons.lep.api.BaseLepContext;
import com.icthh.xm.commons.logging.trace.TraceService.TraceServiceField;
import com.icthh.xm.commons.permission.service.PermissionCheckService;
import org.springframework.web.client.RestTemplate;

public class LepContext extends BaseLepContext implements TraceServiceField {

    public LepTemplates templates;
    public LepServices services;

    public static class LepTemplates {

        public RestTemplate rest;
    }

    public static class LepServices {

        public TenantConfigService tenantConfigService;
        public PermissionCheckService permissionService;
    }

}
