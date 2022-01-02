package com.icommerce.cart.core.usecase.impl;

import com.icommerce.cart.core.ShopCart;
import com.icommerce.cart.core.port.ShopCardPort;
import com.icommerce.cart.core.shared.CreationValidationGroup;
import com.icommerce.cart.core.usecase.CreateShopCardUseCase;

public class CreateShopCardUseCaseImpl implements CreateShopCardUseCase {

    private ShopCardPort shopCardPort;

    public CreateShopCardUseCaseImpl(ShopCardPort shopCardPort) {
        this.shopCardPort = shopCardPort;
    }

    @Override
    public ShopCart execute(ShopCart shopCart) {
        shopCart.validateSelf(CreationValidationGroup.class);
        return shopCardPort.create(shopCart);
    }
}
