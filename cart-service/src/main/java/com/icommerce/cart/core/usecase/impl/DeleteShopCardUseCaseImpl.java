package com.icommerce.cart.core.usecase.impl;

import com.icommerce.cart.core.port.ShopCardPort;
import com.icommerce.cart.core.usecase.DeleteShopCardUseCase;

public class DeleteShopCardUseCaseImpl implements DeleteShopCardUseCase {

    private ShopCardPort shopCardPort;

    public DeleteShopCardUseCaseImpl(ShopCardPort shopCardPort) {
        this.shopCardPort = shopCardPort;
    }

    @Override
    public void execute(String customer) {
        shopCardPort.delete(customer);
    }
}
