package com.icommerce.cart.delivery;

import java.util.List;

import com.icommerce.cart.core.ShopCart;
import com.icommerce.cart.delivery.dto.BaseResponse;

public interface ShopCardController {

    BaseResponse<List<ShopCart>> findAll();
    BaseResponse<ShopCart> findByCustomer(String customer);
    BaseResponse<ShopCart> update(String customer, ShopCart dto);
    BaseResponse<ShopCart> create(ShopCart dto);
    BaseResponse<Void> delete(String customer);
}
