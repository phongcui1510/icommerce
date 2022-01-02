package com.icommerce.product.service.product.usecase.impl;

import com.icommerce.product.service.product.dto.ProductDTO;
import com.icommerce.product.service.product.port.ProductPersistencePort;
import com.icommerce.product.service.product.usecase.CreateProductUseCase;
import com.icommerce.product.service.shared.CreationValidationGroup;

public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private ProductPersistencePort productPersistencePort;

    /**
     * @param productPersistencePort
     */
    public CreateProductUseCaseImpl(ProductPersistencePort productPersistencePort) {
        this.productPersistencePort = productPersistencePort;
    }

    /**
     *
     */
    @Override
    public String execute(ProductDTO product) {
        product.validateSelf(CreationValidationGroup.class);
        return productPersistencePort.create(product);
    }
}
