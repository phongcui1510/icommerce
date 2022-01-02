package com.icommerce.cart.delivery.impl.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icommerce.cart.core.ShopCart;
import com.icommerce.cart.core.shared.ConstantUtils;
import com.icommerce.cart.core.usecase.CreateCartUseCase;
import com.icommerce.cart.core.usecase.DeleteCartUseCase;
import com.icommerce.cart.core.usecase.FindAllCartUseCase;
import com.icommerce.cart.core.usecase.FindCartByCustomerUseCase;
import com.icommerce.cart.core.usecase.UpdateCartUseCase;
import com.icommerce.cart.delivery.CartController;
import com.icommerce.cart.delivery.dto.BaseResponse;

@RestController
@RequestMapping(ConstantUtils.API_VERSION_1 + ConstantUtils.RESOURCE_CART)
public class CartRest implements CartController {

    @Autowired
    private FindAllCartUseCase findAllCartUseCase;
    @Autowired
    private UpdateCartUseCase updateCartUseCase;
    @Autowired
    private FindCartByCustomerUseCase findCartsByCustomerUseCase;
    @Autowired
    private DeleteCartUseCase deleteCartUseCase;
    @Autowired
    private CreateCartUseCase createCartUseCase;

    @PostMapping
    @Override
    public BaseResponse<ShopCart> create(@RequestBody ShopCart dto) {
        final ShopCart result = createCartUseCase.execute(dto);
        return new BaseResponse<>(String.valueOf(HttpStatus.OK), ConstantUtils.SUCCESS, result);
    }

    @GetMapping
    @Override
    public BaseResponse<List<ShopCart>> findAll() {
        final List<ShopCart> result = findAllCartUseCase.execute();
        return new BaseResponse<>(String.valueOf(HttpStatus.OK), ConstantUtils.SUCCESS, result);
    }

    @GetMapping("/{customer}")
    @Override
    public BaseResponse<ShopCart> findByCustomer(@PathVariable("customer") String customer) {
        final ShopCart result = findCartsByCustomerUseCase.execute(customer);
        return new BaseResponse<>(String.valueOf(HttpStatus.OK), ConstantUtils.SUCCESS, result);
    }

    @PutMapping("/{customer}")
    @Override
    public BaseResponse<ShopCart> update(@PathVariable("customer") String customer,
                                            @RequestBody ShopCart dto) {
        final ShopCart result = updateCartUseCase.execute(customer, dto);
        return new BaseResponse<>(String.valueOf(HttpStatus.OK), ConstantUtils.SUCCESS, result);
    }

    @DeleteMapping("/{customer}")
    @Override
    public BaseResponse<Void> delete(@PathVariable("customer") String customer) {
        deleteCartUseCase.execute(customer);
        return new BaseResponse<>(String.valueOf(HttpStatus.OK), ConstantUtils.SUCCESS);
    }
}
