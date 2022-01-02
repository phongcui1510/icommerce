package com.icommerce.product.service.product.usecase.impl;

import com.icommerce.product.service.product.dto.ProductDTO;
import com.icommerce.product.service.product.port.ProductPersistencePort;
import com.icommerce.product.service.product.usecase.UpdateProductUseCase;
import com.icommerce.product.service.shared.UpdatingValidationGroup;

public class UpdateProductUseCaseImpl implements UpdateProductUseCase {

    private ProductPersistencePort productPersistencePort;

    public UpdateProductUseCaseImpl(ProductPersistencePort productPersistencePort) {
        this.productPersistencePort = productPersistencePort;
    }

    @Override
    public ProductDTO execute(String id, ProductDTO product) {
        product.setId(id);
        product.validateSelf(UpdatingValidationGroup.class);
        return productPersistencePort.update(id, product);
    }
}
