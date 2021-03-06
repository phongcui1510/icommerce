package com.icommerce.cart.persistence.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import com.icommerce.cart.core.ShopCart;
import com.icommerce.cart.core.port.ShopCardPort;
import com.icommerce.cart.core.shared.ResourceNotFoundException;
import com.icommerce.cart.persistence.converter.ShopCardPersistenceConverter;
import com.icommerce.cart.persistence.entity.ShopCartEntity;
import com.icommerce.cart.persistence.repository.ShopCartRepository;

public class ShopCardPortImpl implements ShopCardPort {

    @Autowired
    private ShopCartRepository repository;

    @Override
    public List<ShopCart> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(ShopCardPersistenceConverter.fromEntityToModel)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public ShopCart findByCustomer(String customer) {
        final ShopCartEntity entity =
                repository.findById(customer).orElseThrow(ResourceNotFoundException::new);
        return ShopCardPersistenceConverter.fromEntityToModel.apply(entity);
    }

    @Override
    public void delete(String customer) {
        repository.deleteById(customer);
    }

    @Override
    public ShopCart update(String customer, ShopCart shopCart) {
        final ShopCartEntity existed = repository.findById(customer)
                .orElseThrow(ResourceNotFoundException::new);
        final ShopCartEntity newEntity = ShopCardPersistenceConverter.fromModelToEntity.apply(shopCart);
        newEntity.setCustomer(existed.getCustomer());
        return ShopCardPersistenceConverter.fromEntityToModel.apply(repository.save(newEntity));
    }

    @Override
    public ShopCart create(ShopCart shopCart) {
        final ShopCartEntity entity = ShopCardPersistenceConverter.fromModelToEntity.apply(shopCart);
        return ShopCardPersistenceConverter.fromEntityToModel.apply(repository.save(entity));
    }
}
