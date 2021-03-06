package com.icommerce.product.service.product.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.icommerce.product.service.shared.CreationValidationGroup;
import com.icommerce.product.service.shared.AbstractCustomValidator;
import com.icommerce.product.service.shared.UpdatingValidationGroup;

public class ProductDTO extends AbstractCustomValidator<ProductDTO> {

    @NotEmpty(groups = {UpdatingValidationGroup.class})
    private String id;
    @NotEmpty(groups = {CreationValidationGroup.class, UpdatingValidationGroup.class})
    private String title;
    private String description;
    private String brand;
    @NotNull(groups = {CreationValidationGroup.class, UpdatingValidationGroup.class})
    private BigDecimal price;
    @NotEmpty(groups = {CreationValidationGroup.class, UpdatingValidationGroup.class})
    private String colour;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return new StringBuilder(id)
                .append(title).append(description)
                .append(brand).append(price).append(colour)
                .toString();
    }
}
