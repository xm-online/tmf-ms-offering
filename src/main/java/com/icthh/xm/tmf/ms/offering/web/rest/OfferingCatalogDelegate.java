package com.icthh.xm.tmf.ms.offering.web.rest;

import com.icthh.xm.commons.lep.LogicExtensionPoint;
import com.icthh.xm.commons.lep.spring.LepService;
import com.icthh.xm.commons.permission.annotation.PrivilegeDescription;
import com.icthh.xm.tmf.ms.offering.lep.keyresolver.ProfileChannelKeyResolver;
import com.icthh.xm.tmf.ms.offering.web.api.CategoryApiDelegate;
import com.icthh.xm.tmf.ms.offering.web.api.model.Category;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.asList;

@Slf4j
@Component
@LepService(group = "service", name = "default")
public class OfferingCatalogDelegate implements CategoryApiDelegate {

    @Timed
    @Override
    @PrivilegeDescription("Privilege to get a product offering category")
    @LogicExtensionPoint(value = "ListCategory", resolver = ProfileChannelKeyResolver.class)
    @PreAuthorize("hasPermission({'profile': @headerRequestExtractor.get('Profile')}, 'QUALIFICATION.PRODUCT.OFFERING.GET')")
    public ResponseEntity<List<Category>> listCategory(String channel,
                                                       String profile,
                                                       String acceptLanguage,
                                                       Integer offset,
                                                       Integer limit) {
        getRequest().ifPresent(request -> log.info("Native request {}", getRequest().get().getNativeRequest()));
        return ResponseEntity.ok(asList(new Category()));
    }
}
