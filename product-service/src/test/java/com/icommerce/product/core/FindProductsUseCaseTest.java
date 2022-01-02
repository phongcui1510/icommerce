package com.icommerce.product.core;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.icommerce.product.service.product.dto.ProductDTO;
import com.icommerce.product.service.product.port.ProductPersistencePort;
import com.icommerce.product.service.product.usecase.impl.FindProductsUseCaseImpl;

@ExtendWith(MockitoExtension.class)
public class FindProductsUseCaseTest {

    @Mock
    private ProductPersistencePort port;
    @InjectMocks
    private FindProductsUseCaseImpl findProductsUseCase;

    @Test
    public void testNoResultCase() {
        Mockito.when(port.find(Mockito.anyString(), Mockito.anyString(),
                Mockito.anyInt(), Mockito.anyInt())).thenReturn(Collections.emptyList());
        Assertions.assertEquals(0, findProductsUseCase.execute("colour:*", "id+", 10, 0).size());
    }

    @Test
    public void testHasResultCase() {
        final ProductDTO product = new ProductDTO();
        product.setId("product_uuid");
        product.setBrand("nike");
        product.setPrice(BigDecimal.TEN);
        product.setColour("red");
        product.setTitle("shoes");
        product.setDescription("nike shoes");
        Mockito.when(port.find(Mockito.anyString(), Mockito.anyString(),
                Mockito.anyInt(), Mockito.anyInt())).thenReturn(Collections.singletonList(product));
        final List<ProductDTO> products = findProductsUseCase.execute("colour:*", "id+", 10, 0);
        Assertions.assertEquals(1, products.size());
        Assertions.assertEquals("product_uuid", products.get(0).getId());
    }
}
