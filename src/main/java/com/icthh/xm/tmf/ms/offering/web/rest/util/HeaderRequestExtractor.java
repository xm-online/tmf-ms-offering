package com.icthh.xm.tmf.ms.offering.web.rest.util;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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
