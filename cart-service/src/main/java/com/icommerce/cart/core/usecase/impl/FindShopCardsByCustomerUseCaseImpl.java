package com.icommerce.cart.core.usecase.impl;

import com.icommerce.cart.core.ShopCart;
import com.icommerce.cart.core.port.CartPort;
import com.icommerce.cart.core.usecase.FindCartByCustomerUseCase;

public class FindShopCardsByCustomerUseCaseImpl implements FindCartByCustomerUseCase {

    private CartPort shopCardPort;

    public FindShopCardsByCustomerUseCaseImpl(CartPort shopCardPort) {
        this.shopCardPort = shopCardPort;
    }

    @Override
    public ShopCart execute(String customer) {
        return shopCardPort.findByCustomer(customer);
    }
}
