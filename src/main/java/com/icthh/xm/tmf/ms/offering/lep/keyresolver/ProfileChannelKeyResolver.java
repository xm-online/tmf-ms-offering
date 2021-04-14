package com.icthh.xm.tmf.ms.offering.lep.keyresolver;

import com.icthh.xm.commons.lep.AppendLepKeyResolver;
import com.icthh.xm.lep.api.LepManagerService;
import com.icthh.xm.lep.api.LepMethod;
import com.icthh.xm.lep.api.commons.SeparatorSegmentedLepKey;
import org.springframework.stereotype.Component;

@Component
public class ProfileChannelKeyResolver extends AppendLepKeyResolver {

    @Override
    protected String[] getAppendSegments(SeparatorSegmentedLepKey baseKey,
                                         LepMethod method,
                                         LepManagerService managerService) {
        String profile = getRequiredParam(method, "Profile", String.class);
        String channel = getRequiredParam(method, "Channel", String.class);
        return new String[]{translateToLepConvention(profile), translateToLepConvention(channel)};
    }
}
