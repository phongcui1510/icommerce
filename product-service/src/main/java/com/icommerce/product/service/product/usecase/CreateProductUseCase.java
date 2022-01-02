package com.icommerce.product.service.product.usecase;

import com.icommerce.product.service.product.dto.ProductDTO;

public interface CreateProductUseCase {

    String execute(ProductDTO product);
}
