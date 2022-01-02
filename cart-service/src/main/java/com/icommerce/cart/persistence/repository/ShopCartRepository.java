package com.icommerce.cart.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import com.icommerce.cart.persistence.entity.ShopCartEntity;

public interface ShopCartRepository extends CrudRepository<ShopCartEntity, String> {
}
