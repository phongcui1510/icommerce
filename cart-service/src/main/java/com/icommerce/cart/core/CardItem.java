package com.icommerce.cart.core;

import com.icommerce.cart.core.shared.CreationValidationGroup;
import com.icommerce.cart.core.shared.UpdatingValidationGroup;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class CardItem {

    @Valid
    @NotNull(groups = {CreationValidationGroup.class, UpdatingValidationGroup.class})
    private Product product;
    @NotNull(groups = {CreationValidationGroup.class, UpdatingValidationGroup.class})
    private Long quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
