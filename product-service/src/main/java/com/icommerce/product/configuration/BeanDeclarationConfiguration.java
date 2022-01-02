package com.icommerce.product.configuration;

import com.icommerce.product.service.product.port.ProductPersistencePort;
import com.icommerce.product.service.product.usecase.CreateProductUseCase;
import com.icommerce.product.service.product.usecase.FindProductsUseCase;
import com.icommerce.product.service.product.usecase.UpdateProductUseCase;
import com.icommerce.product.service.product.usecase.impl.CreateProductUseCaseImpl;
import com.icommerce.product.service.product.usecase.impl.FindProductsUseCaseImpl;
import com.icommerce.product.service.product.usecase.impl.UpdateProductUseCaseImpl;
import com.icommerce.product.service.product.port.impl.ProductPersistencePortImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanDeclarationConfiguration {

    @Bean
    public ProductPersistencePort productPersistencePort() {
        return new ProductPersistencePortImpl();
    }

    @Bean
    public CreateProductUseCase createProductUseCase(ProductPersistencePort port) {
        return new CreateProductUseCaseImpl(port);
    }

    @Bean
    public FindProductsUseCase findProductsUseCase(ProductPersistencePort port) {
        return new FindProductsUseCaseImpl(port);
    }

    @Bean
    public UpdateProductUseCase updateProductUseCase(ProductPersistencePort port) {
        return new UpdateProductUseCaseImpl(port);
    }
}
