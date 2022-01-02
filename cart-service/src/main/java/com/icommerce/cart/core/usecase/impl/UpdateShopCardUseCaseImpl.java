package com.icommerce.cart.core.usecase.impl;

import com.icommerce.cart.core.ShopCart;
import com.icommerce.cart.core.port.CartPort;
import com.icommerce.cart.core.shared.UpdatingValidationGroup;
import com.icommerce.cart.core.usecase.UpdateCartUseCase;

public class UpdateShopCardUseCaseImpl implements UpdateCartUseCase {

    private CartPort shopCardPort;

    public UpdateShopCardUseCaseImpl(CartPort shopCardPort) {
        this.shopCardPort = shopCardPort;
    }

    @Override
    public ShopCart execute(String customer, ShopCart shopCart) {
        shopCart.setCustomer(customer);
        shopCart.validateSelf(UpdatingValidationGroup.class);
        return shopCardPort.update(customer, shopCart);
    }
}
