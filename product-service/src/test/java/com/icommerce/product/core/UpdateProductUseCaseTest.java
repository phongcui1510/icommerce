package com.icommerce.product.core;

import java.math.BigDecimal;

import javax.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.icommerce.product.service.product.dto.ProductDTO;
import com.icommerce.product.service.product.port.ProductPersistencePort;
import com.icommerce.product.service.product.usecase.impl.UpdateProductUseCaseImpl;

@ExtendWith(MockitoExtension.class)
public class UpdateProductUseCaseTest {

    @Mock
    private ProductPersistencePort port;
    @InjectMocks
    private UpdateProductUseCaseImpl updateProductUseCase;

    @Test
    public void testConstrainExceptionCase() {
        final ProductDTO product = new ProductDTO();
        product.setBrand("");
        product.setPrice(null);
        product.setColour("");
        product.setTitle("");
        product.setId("");
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            updateProductUseCase.execute("product_uuid", product);
        });
    }

    @Test
    public void testSuccessCase() {
        final String id = "product_uuid";
        final ProductDTO product = new ProductDTO();
        product.setBrand("nike");
        product.setPrice(BigDecimal.TEN);
        product.setColour("red");
        product.setTitle("shoes");
        product.setDescription("nike shoes");
        product.setId(id);
        Mockito.when(port.update(Mockito.anyString(), Mockito.any(ProductDTO.class))).thenReturn(product);
        Assertions.assertEquals(id, updateProductUseCase.execute("product_uuid", product).getId());
    }
}
