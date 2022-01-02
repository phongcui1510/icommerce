package com.icommerce.product.persistence;

import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.icommerce.product.repository.ProductRepository;
import com.icommerce.product.repository.entity.ProductEntity;
import com.icommerce.product.service.product.dto.ProductDTO;
import com.icommerce.product.service.product.port.impl.ProductPersistencePortImpl;
import com.icommerce.product.service.shared.ResourceNotFoundException;

@ExtendWith(MockitoExtension.class)
public class ProductPersistencePortTest {

    @Mock
    private ProductRepository repository;
    @InjectMocks
    private ProductPersistencePortImpl port;

    @Test
    public void testFindByIdNotFound() {
        Mockito.when(repository.findById(Mockito.anyString())).thenReturn(Optional.empty());
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            port.find("product_uuid");
        });
    }

    @Test
    public void testFindById() {
        final ProductEntity entity = new ProductEntity();
        entity.setId("product_uuid");
        entity.setPrice(BigDecimal.TEN);
        entity.setTitle("shoes");
        entity.setBrand("nike");
        entity.setDescription("description");
        Mockito.when(repository.findById(Mockito.anyString())).thenReturn(Optional.of(entity));
        final ProductDTO product = port.find("product_uuid");
        Assertions.assertEquals("product_uuid", product.getId());
        Assertions.assertEquals("shoes", product.getTitle());
        Assertions.assertEquals("nike", product.getBrand());
    }
}
