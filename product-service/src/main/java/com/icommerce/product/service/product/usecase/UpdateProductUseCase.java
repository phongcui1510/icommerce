package com.icommerce.product.service.product.usecase;

import com.icommerce.product.service.product.dto.ProductDTO;

public interface UpdateProductUseCase {

    ProductDTO execute(String id, ProductDTO product);
}
