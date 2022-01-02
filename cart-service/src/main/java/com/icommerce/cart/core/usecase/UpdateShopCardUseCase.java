package com.icommerce.cart.core.usecase;

import com.icommerce.cart.core.ShopCart;

public interface UpdateShopCardUseCase {

    ShopCart execute(String customer, ShopCart shopCart);
}
