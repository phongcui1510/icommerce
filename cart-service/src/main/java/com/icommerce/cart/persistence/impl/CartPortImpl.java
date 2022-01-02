package com.icommerce.cart.persistence.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import com.icommerce.cart.core.ShopCart;
import com.icommerce.cart.core.port.CartPort;
import com.icommerce.cart.core.shared.ResourceNotFoundException;
import com.icommerce.cart.persistence.converter.CartPersistenceConverter;
import com.icommerce.cart.persistence.entity.CartEntity;
import com.icommerce.cart.persistence.repository.CartRepository;

public class CartPortImpl implements CartPort {

    @Autowired
    private CartRepository repository;

    @Override
    public List<ShopCart> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(CartPersistenceConverter.fromEntityToModel)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public ShopCart findByCustomer(String customer) {
        final CartEntity entity =
                repository.findById(customer).orElseThrow(ResourceNotFoundException::new);
        return CartPersistenceConverter.fromEntityToModel.apply(entity);
    }

    @Override
    public void delete(String customer) {
        repository.deleteById(customer);
    }

    @Override
    public ShopCart update(String customer, ShopCart shopCart) {
        final CartEntity existed = repository.findById(customer)
                .orElseThrow(ResourceNotFoundException::new);
        final CartEntity newEntity = CartPersistenceConverter.fromModelToEntity.apply(shopCart);
        newEntity.setCustomer(existed.getCustomer());
        return CartPersistenceConverter.fromEntityToModel.apply(repository.save(newEntity));
    }

    @Override
    public ShopCart create(ShopCart shopCart) {
        final CartEntity entity = CartPersistenceConverter.fromModelToEntity.apply(shopCart);
        return CartPersistenceConverter.fromEntityToModel.apply(repository.save(entity));
    }
}
