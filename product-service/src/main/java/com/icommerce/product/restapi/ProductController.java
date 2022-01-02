package com.icommerce.product.restapi;

import com.icommerce.product.restapi.dto.CustomResponseBody;
import com.icommerce.product.service.product.dto.ProductDTO;

import java.util.List;

public interface ProductController {

    CustomResponseBody<List<ProductDTO>> find(String search, String sort, Integer size, Integer page);
    CustomResponseBody<String> create(ProductDTO dto);
    CustomResponseBody<ProductDTO> findById(String id);
    CustomResponseBody<ProductDTO> update(String id, ProductDTO dto);
}
