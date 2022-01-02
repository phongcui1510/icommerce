package com.icommerce.cart.core.usecase;

import com.icommerce.cart.core.ShopCart;

public interface FindCartByCustomerUseCase {

    ShopCart execute(String customer);
}
