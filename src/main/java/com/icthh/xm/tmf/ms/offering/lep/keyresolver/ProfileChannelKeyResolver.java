package com.icthh.xm.tmf.ms.offering.lep.keyresolver;

import com.icthh.xm.lep.api.LepKeyResolver;
import com.icthh.xm.lep.api.LepMethod;
import com.icthh.xm.tmf.ms.offering.web.rest.util.HeaderRequestExtractor;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProfileChannelKeyResolver implements LepKeyResolver {

    private final HeaderRequestExtractor headerRequestExtractor;

    @Override
    public List<String> segments(LepMethod method) {
        String profile = headerRequestExtractor.get("Profile");
        String channel = headerRequestExtractor.get("Channel");

        return List.of(profile, channel);
    }
}
