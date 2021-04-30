package com.icthh.xm.tmf.ms.offering.lep.keyresolver;

import com.icthh.xm.commons.lep.AppendLepKeyResolver;
import com.icthh.xm.lep.api.LepManagerService;
import com.icthh.xm.lep.api.LepMethod;
import com.icthh.xm.lep.api.commons.SeparatorSegmentedLepKey;
import com.icthh.xm.tmf.ms.offering.web.rest.util.HeaderRequestExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProfileChannelKeyResolver extends AppendLepKeyResolver {

    private final HeaderRequestExtractor headerRequestExtractor;

    @Override
    protected String[] getAppendSegments(SeparatorSegmentedLepKey baseKey,
                                         LepMethod method,
                                         LepManagerService managerService) {
        String profile = headerRequestExtractor.get("Profile");
        String channel = headerRequestExtractor.get("Channel");
        return new String[]{translateToLepConvention(profile), translateToLepConvention(channel)};
    }
}
