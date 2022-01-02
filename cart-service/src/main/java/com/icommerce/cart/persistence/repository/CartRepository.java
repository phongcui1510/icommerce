package com.icommerce.cart.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import com.icommerce.cart.persistence.entity.CartEntity;

public interface CartRepository extends CrudRepository<CartEntity, String> {
}
