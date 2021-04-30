package com.icthh.xm.tmf.ms.offering.web.rest;

import com.icthh.xm.commons.lep.LogicExtensionPoint;
import com.icthh.xm.commons.lep.spring.LepService;
import com.icthh.xm.commons.permission.annotation.PrivilegeDescription;
import com.icthh.xm.tmf.ms.offering.lep.keyresolver.ProfileKeyResolver;
import com.icthh.xm.tmf.ms.offering.web.api.CategoryApiDelegate;
import com.icthh.xm.tmf.ms.offering.web.api.model.Category;
import io.micrometer.core.annotation.Timed;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@LepService(group = "service")
public class OfferingCatalogDelegate implements CategoryApiDelegate {

    @Timed
    @Override
    @PrivilegeDescription("Privilege to list a product offering category")
    @LogicExtensionPoint(value = "ListCategory", resolver = ProfileKeyResolver.class)
    @PreAuthorize("hasPermission({'profile': @headerRequestExtractor.get('profile'), 'channelId': @headerRequestExtractor.get('channel')}, 'OFFERING.CATEGORY.LIST')")
    public ResponseEntity<List<Category>> listCategory(String fields, Integer offset, Integer limit) {
        return ResponseEntity.ok().build();
    }
}
