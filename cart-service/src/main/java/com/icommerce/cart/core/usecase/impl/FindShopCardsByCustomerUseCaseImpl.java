package com.icommerce.cart.core.usecase.impl;

import com.icommerce.cart.core.ShopCart;
import com.icommerce.cart.core.port.ShopCardPort;
import com.icommerce.cart.core.usecase.FindShopCardsByCustomerUseCase;

public class FindShopCardsByCustomerUseCaseImpl implements FindShopCardsByCustomerUseCase {

    private ShopCardPort shopCardPort;

    public FindShopCardsByCustomerUseCaseImpl(ShopCardPort shopCardPort) {
        this.shopCardPort = shopCardPort;
    }

    @Override
    public ShopCart execute(String customer) {
        return shopCardPort.findByCustomer(customer);
    }
}
