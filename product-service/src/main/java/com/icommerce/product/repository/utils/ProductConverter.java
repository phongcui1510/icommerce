package com.icommerce.product.repository.utils;

import com.icommerce.product.repository.entity.ProductEntity;
import com.icommerce.product.service.product.dto.ProductDTO;

import org.springframework.beans.BeanUtils;

import java.util.function.Function;

public interface ProductConverter {

    Function<ProductEntity, ProductDTO> toModel = entity -> {
        final ProductDTO product = new ProductDTO();
        BeanUtils.copyProperties(entity, product);
        return product;
    };

    Function<ProductDTO, ProductEntity> toEntity = product -> {
        final ProductEntity entity = new ProductEntity();
        BeanUtils.copyProperties(product, entity);
        return entity;
    };
}
