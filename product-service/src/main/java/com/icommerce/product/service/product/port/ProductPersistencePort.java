package com.icommerce.product.service.product.port;

import java.util.List;

import com.icommerce.product.service.product.dto.ProductDTO;

public interface ProductPersistencePort {

    List<ProductDTO> find(String search, String sort, Integer size, Integer page);
    String create(ProductDTO product);
    ProductDTO find(String id);
    ProductDTO update(String id, ProductDTO product);
}
