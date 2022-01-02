package com.icommerce.cart.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.icommerce.cart.core.port.ShopCardPort;
import com.icommerce.cart.core.usecase.CreateShopCardUseCase;
import com.icommerce.cart.core.usecase.DeleteShopCardUseCase;
import com.icommerce.cart.core.usecase.FindAllShopCardsUseCase;
import com.icommerce.cart.core.usecase.FindShopCardsByCustomerUseCase;
import com.icommerce.cart.core.usecase.UpdateShopCardUseCase;
import com.icommerce.cart.core.usecase.impl.CreateShopCardUseCaseImpl;
import com.icommerce.cart.core.usecase.impl.DeleteShopCardUseCaseImpl;
import com.icommerce.cart.core.usecase.impl.FindAllShopCardsUseCaseImpl;
import com.icommerce.cart.core.usecase.impl.FindShopCardsByCustomerUseCaseImpl;
import com.icommerce.cart.core.usecase.impl.UpdateShopCardUseCaseImpl;
import com.icommerce.cart.persistence.impl.ShopCardPortImpl;

@Configuration
public class ShopCardUseCaseConfiguration {

    @Bean
    public ShopCardPort shopCardPort() {
        return new ShopCardPortImpl();
    }

    @Bean
    public DeleteShopCardUseCase deleteShopCardUseCase(ShopCardPort shopCardPort) {
        return new DeleteShopCardUseCaseImpl(shopCardPort);
    }

    @Bean
    public UpdateShopCardUseCase updateShopCardUseCase(ShopCardPort shopCardPort) {
        return new UpdateShopCardUseCaseImpl(shopCardPort);
    }

    @Bean
    public FindAllShopCardsUseCase findAllShopCardsUseCase(ShopCardPort shopCardPort) {
        return new FindAllShopCardsUseCaseImpl(shopCardPort);
    }

    @Bean
    public FindShopCardsByCustomerUseCase findShopCardsByCustomerUseCase(ShopCardPort shopCardPort) {
        return new FindShopCardsByCustomerUseCaseImpl(shopCardPort);
    }

    @Bean
    public CreateShopCardUseCase createShopCardUseCase(ShopCardPort shopCardPort) {
        return new CreateShopCardUseCaseImpl(shopCardPort);
    }
}
