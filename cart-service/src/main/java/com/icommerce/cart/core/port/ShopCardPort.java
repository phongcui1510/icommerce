package com.icommerce.cart.core.port;

import com.icommerce.cart.core.ShopCart;

import java.util.List;

public interface ShopCardPort {

    List<ShopCart> findAll();
    ShopCart findByCustomer(String customer);
    void delete(String customer);
    ShopCart update(String customer, ShopCart shopCart);
    ShopCart create(ShopCart shopCart);
}
