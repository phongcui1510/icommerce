package com.icommerce.cart.persistence.converter;

import java.util.function.Function;
import java.util.stream.Collectors;

import com.icommerce.cart.core.CardItem;
import com.icommerce.cart.core.Product;
import com.icommerce.cart.core.ShopCart;
import com.icommerce.cart.persistence.entity.CartItemEntity;
import com.icommerce.cart.persistence.entity.ProductEntity;
import com.icommerce.cart.persistence.entity.CartEntity;

public interface CartPersistenceConverter {

    Function<ShopCart, CartEntity> fromModelToEntity = model -> {
        final CartEntity entity = new CartEntity();
        entity.setCustomer(model.getCustomer());
        entity.setItems(model.getItems() == null ? null : model.getItems().stream().map(itm -> {
            final CartItemEntity cardItemEntity = new CartItemEntity();
            cardItemEntity.setQuantity(itm.getQuantity());
            final Product product = itm.getProduct();
            if (product != null) {
                final ProductEntity productEntity = new ProductEntity(
                        product.getId(), product.getName(), product.getCategory(),
                        product.getAttributes(), product.getPrice()
                );
                cardItemEntity.setProduct(productEntity);
            }
            return cardItemEntity;
        }).collect(Collectors.toUnmodifiableList()));
        return entity;
    };

    Function<CartEntity, ShopCart> fromEntityToModel = entity -> {
        final ShopCart model = new ShopCart();
        model.setCustomer(entity.getCustomer());
        model.setItems(entity.getItems() == null ? null : entity.getItems().stream().map(itm -> {
            final CardItem cardItem = new CardItem();
            cardItem.setQuantity(itm.getQuantity());
            final ProductEntity productEntity = itm.getProduct();
            if (productEntity != null) {
                final Product product = new Product(productEntity.getId(),
                        productEntity.getName(),
                        productEntity.getCategory(),
                        productEntity.getAttributes(),
                        productEntity.getPrice());
                cardItem.setProduct(product);
            }
            return cardItem;
        }).collect(Collectors.toUnmodifiableList()));
        return model;
    };
}
