package com.icommerce.cart.core.usecase;

import com.icommerce.cart.core.ShopCart;

public interface FindShopCardsByCustomerUseCase {

    ShopCart execute(String customer);
}
