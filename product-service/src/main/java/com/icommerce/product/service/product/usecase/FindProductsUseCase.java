package com.icommerce.product.service.product.usecase;

import java.util.List;

import com.icommerce.product.service.product.dto.ProductDTO;

public interface FindProductsUseCase {

    List<ProductDTO> execute(String search, String sort, Integer size, Integer page);
    ProductDTO execute(String id);
}
