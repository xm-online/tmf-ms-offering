package com.icthh.xm.tmf.ms.offering.web.rest.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

@Component
public class HeaderRequestExtractor {

    public String get(String headerName) {
        HttpServletRequest request =
            ((ServletRequestAttributes) requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        return request.getHeader(headerName);
    }
}
