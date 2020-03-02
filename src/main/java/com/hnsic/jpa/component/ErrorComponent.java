package com.hnsic.jpa.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class ErrorComponent extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("hnsic", "made in 刘广");
        Map<String, Object> excmap = (Map<String, Object>) webRequest.getAttribute("ext", 0);
        System.out.println(webRequest.getAttribute("status", 0));
        map.put("ext", excmap);
        return map;
    }

}
