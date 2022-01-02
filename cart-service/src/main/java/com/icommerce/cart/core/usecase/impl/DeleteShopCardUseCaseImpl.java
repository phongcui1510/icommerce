package com.icommerce.cart.core.usecase.impl;

import com.icommerce.cart.core.port.CartPort;
import com.icommerce.cart.core.usecase.DeleteCartUseCase;

public class DeleteShopCardUseCaseImpl implements DeleteCartUseCase {

    private CartPort shopCardPort;

    public DeleteShopCardUseCaseImpl(CartPort shopCardPort) {
        this.shopCardPort = shopCardPort;
    }

    @Override
    public void execute(String customer) {
        shopCardPort.delete(customer);
    }
}
