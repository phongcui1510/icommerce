package com.icommerce.cart.core.usecase;

import java.util.List;

import com.icommerce.cart.core.ShopCart;

public interface FindAllCartUseCase {

    List<ShopCart> execute();
}
