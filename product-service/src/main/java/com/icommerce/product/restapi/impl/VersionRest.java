package com.icommerce.product.restapi.impl;

import com.icommerce.product.service.shared.Constants;
import com.icommerce.product.restapi.VersionController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionRest implements VersionController {

    @GetMapping(Constants.RESOURCE_VERSION)
    @Override
    public String getVersion() {
        return "v.1.0.0";
    }
}
