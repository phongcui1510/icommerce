package com.icommerce.cart.core.usecase.impl;

import com.icommerce.cart.core.ShopCart;
import com.icommerce.cart.core.port.ShopCardPort;
import com.icommerce.cart.core.shared.UpdatingValidationGroup;
import com.icommerce.cart.core.usecase.UpdateShopCardUseCase;

public class UpdateShopCardUseCaseImpl implements UpdateShopCardUseCase {

    private ShopCardPort shopCardPort;

    public UpdateShopCardUseCaseImpl(ShopCardPort shopCardPort) {
        this.shopCardPort = shopCardPort;
    }

    @Override
    public ShopCart execute(String customer, ShopCart shopCart) {
        shopCart.setCustomer(customer);
        shopCart.validateSelf(UpdatingValidationGroup.class);
        return shopCardPort.update(customer, shopCart);
    }
}
