package com.icommerce.product.service.product.port.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import com.icommerce.product.repository.ProductRepository;
import com.icommerce.product.repository.entity.ProductEntity;
import com.icommerce.product.repository.shared.GenericSpecificationsBuilder;
import com.icommerce.product.repository.shared.PageableBuilder;
import com.icommerce.product.repository.utils.ProductConverter;
import com.icommerce.product.service.product.dto.ProductDTO;
import com.icommerce.product.service.product.port.ProductPersistencePort;
import com.icommerce.product.service.shared.ResourceNotFoundException;

public class ProductPersistencePortImpl implements ProductPersistencePort {

    @Autowired
    private ProductRepository repository;

    /**
     *
     */
    @Override
    public List<ProductDTO> find(String search, String sort, Integer size, Integer page) {
        final Specification<ProductEntity> specs = GenericSpecificationsBuilder.build(search);
        final Pageable pageable = PageableBuilder.build(sort, size, page);
        final Page<ProductEntity> resp = repository.findAll(specs, pageable);
        final Set<ProductEntity> filters = new HashSet<>(resp.getContent());
        return filters.stream().map(ProductConverter.toModel)
                .collect(Collectors.toUnmodifiableList());
    }

    /**
     *
     */
    @Override
    public String create(ProductDTO product) {
        final ProductEntity entity = ProductConverter.toEntity.apply(product);
        return repository.save(entity).getId();
    }

    /**
     *
     */
    @Override
    public ProductDTO find(String id) {
        final ProductEntity entity = repository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return ProductConverter.toModel.apply(entity);
    }

    /**
     *
     */
    @Override
    public ProductDTO update(String id, ProductDTO product) {
        final ProductEntity entity = repository.findById(id).orElseThrow(ResourceNotFoundException::new);
        entity.setBrand(product.getBrand());
        entity.setPrice(product.getPrice());
        entity.setDescription(product.getDescription());
        entity.setColour(product.getColour());
        return ProductConverter.toModel.apply(repository.save(entity));
    }
}
