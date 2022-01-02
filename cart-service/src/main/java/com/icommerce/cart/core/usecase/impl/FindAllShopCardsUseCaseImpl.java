package com.icommerce.cart.core.usecase.impl;

import java.util.List;

import com.icommerce.cart.core.ShopCart;
import com.icommerce.cart.core.port.CartPort;
import com.icommerce.cart.core.usecase.FindAllCartUseCase;

public class FindAllShopCardsUseCaseImpl implements FindAllCartUseCase {

    private CartPort shopCardPort;

    public FindAllShopCardsUseCaseImpl(CartPort shopCardPort) {
        this.shopCardPort = shopCardPort;
    }

    @Override
    public List<ShopCart> execute() {
        return shopCardPort.findAll();
    }
}
