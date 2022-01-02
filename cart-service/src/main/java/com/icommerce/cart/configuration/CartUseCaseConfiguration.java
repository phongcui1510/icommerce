package com.icommerce.cart.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.icommerce.cart.core.port.CartPort;
import com.icommerce.cart.core.usecase.CreateCartUseCase;
import com.icommerce.cart.core.usecase.DeleteCartUseCase;
import com.icommerce.cart.core.usecase.FindAllCartUseCase;
import com.icommerce.cart.core.usecase.FindCartByCustomerUseCase;
import com.icommerce.cart.core.usecase.UpdateCartUseCase;
import com.icommerce.cart.core.usecase.impl.CreateShopCardUseCaseImpl;
import com.icommerce.cart.core.usecase.impl.DeleteShopCardUseCaseImpl;
import com.icommerce.cart.core.usecase.impl.FindAllShopCardsUseCaseImpl;
import com.icommerce.cart.core.usecase.impl.FindShopCardsByCustomerUseCaseImpl;
import com.icommerce.cart.core.usecase.impl.UpdateShopCardUseCaseImpl;
import com.icommerce.cart.persistence.impl.CartPortImpl;

@Configuration
public class CartUseCaseConfiguration {

    @Bean
    public CartPort shopCardPort() {
        return new CartPortImpl();
    }

    @Bean
    public DeleteCartUseCase deleteShopCardUseCase(CartPort shopCardPort) {
        return new DeleteShopCardUseCaseImpl(shopCardPort);
    }

    @Bean
    public UpdateCartUseCase updateShopCardUseCase(CartPort shopCardPort) {
        return new UpdateShopCardUseCaseImpl(shopCardPort);
    }

    @Bean
    public FindAllCartUseCase findAllShopCardsUseCase(CartPort shopCardPort) {
        return new FindAllShopCardsUseCaseImpl(shopCardPort);
    }

    @Bean
    public FindCartByCustomerUseCase findShopCardsByCustomerUseCase(CartPort shopCardPort) {
        return new FindShopCardsByCustomerUseCaseImpl(shopCardPort);
    }

    @Bean
    public CreateCartUseCase createShopCardUseCase(CartPort shopCardPort) {
        return new CreateShopCardUseCaseImpl(shopCardPort);
    }
}
