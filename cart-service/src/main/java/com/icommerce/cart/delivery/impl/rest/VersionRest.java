package com.icommerce.cart.delivery.impl.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icommerce.cart.core.shared.ConstantUtils;
import com.icommerce.cart.delivery.VersionController;

@RestController
public class VersionRest implements VersionController {

    @GetMapping(ConstantUtils.RESOURCE_VERSION)
    @Override
    public String getVersion() {
        return "v.1.0.0";
    }
}
