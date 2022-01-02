package com.icommerce.cart.core.usecase.impl;

import java.util.List;

import com.icommerce.cart.core.ShopCart;
import com.icommerce.cart.core.port.ShopCardPort;
import com.icommerce.cart.core.usecase.FindAllShopCardsUseCase;

public class FindAllShopCardsUseCaseImpl implements FindAllShopCardsUseCase {

    private ShopCardPort shopCardPort;

    public FindAllShopCardsUseCaseImpl(ShopCardPort shopCardPort) {
        this.shopCardPort = shopCardPort;
    }

    @Override
    public List<ShopCart> execute() {
        return shopCardPort.findAll();
    }
}
