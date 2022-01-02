package com.icommerce.cart.core;

import com.icommerce.cart.core.shared.CreationValidationGroup;
import com.icommerce.cart.core.shared.SelfValidating;
import com.icommerce.cart.core.shared.UpdatingValidationGroup;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class ShopCart extends SelfValidating<ShopCart> {

    @NotEmpty(groups = {CreationValidationGroup.class, UpdatingValidationGroup.class})
    private String customer;
    @Valid
    @NotEmpty(groups = {CreationValidationGroup.class, UpdatingValidationGroup.class})
    private List<CardItem> items;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<CardItem> getItems() {
        return items;
    }

    public void setItems(List<CardItem> items) {
        this.items = items;
    }
}
