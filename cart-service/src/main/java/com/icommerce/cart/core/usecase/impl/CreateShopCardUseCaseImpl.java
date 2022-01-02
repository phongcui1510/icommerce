package com.icommerce.cart.core.usecase.impl;

import com.icommerce.cart.core.ShopCart;
import com.icommerce.cart.core.port.CartPort;
import com.icommerce.cart.core.shared.CreationValidationGroup;
import com.icommerce.cart.core.usecase.CreateCartUseCase;

public class CreateShopCardUseCaseImpl implements CreateCartUseCase {

    private CartPort shopCardPort;

    public CreateShopCardUseCaseImpl(CartPort shopCardPort) {
        this.shopCardPort = shopCardPort;
    }

    @Override
    public ShopCart execute(ShopCart shopCart) {
        shopCart.validateSelf(CreationValidationGroup.class);
        return shopCardPort.create(shopCart);
    }
}
