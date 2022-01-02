package com.icommerce.product.service.product.usecase.impl;

import com.icommerce.product.service.product.dto.ProductDTO;
import com.icommerce.product.service.product.port.ProductPersistencePort;
import com.icommerce.product.service.product.usecase.FindProductsUseCase;

import java.util.List;

public class FindProductsUseCaseImpl implements FindProductsUseCase {

    private ProductPersistencePort productPersistencePort;

    public FindProductsUseCaseImpl(ProductPersistencePort productPersistencePort) {
        this.productPersistencePort = productPersistencePort;
    }

    @Override
    public List<ProductDTO> execute(String search, String sort, Integer size, Integer page) {
        return productPersistencePort.find(search, sort, size, page);
    }

    @Override
    public ProductDTO execute(String id) {
        return productPersistencePort.find(id);
    }
}
