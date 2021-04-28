package com.icthh.xm.tmf.ms.offering.lep.keyresolver;

import com.icthh.xm.commons.lep.AppendLepKeyResolver;
import com.icthh.xm.lep.api.LepManagerService;
import com.icthh.xm.lep.api.LepMethod;
import com.icthh.xm.lep.api.commons.SeparatorSegmentedLepKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProfileChannelKeyResolver extends AppendLepKeyResolver {

    @Override
    protected String[] getAppendSegments(SeparatorSegmentedLepKey baseKey,
                                         LepMethod method,
                                         LepManagerService managerService) {
        log.info(" params {} ", method.getMethodSignature().getName() );
        log.info(" params {} ", method.getMethodArgValues());
        log.info(" params {}  ", method.getMethodSignature().getMethod().getName());
        String profile = getRequiredParam(method, "profile", String.class);
        String channel = getRequiredParam(method, "channel", String.class);
        return new String[]{translateToLepConvention(profile), translateToLepConvention(channel)};
    }
}
