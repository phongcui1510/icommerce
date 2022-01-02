package com.icommerce.product.restapi.impl;

import com.icommerce.product.service.product.dto.ProductDTO;
import com.icommerce.product.service.product.usecase.CreateProductUseCase;
import com.icommerce.product.service.product.usecase.FindProductsUseCase;
import com.icommerce.product.service.product.usecase.UpdateProductUseCase;
import com.icommerce.product.service.shared.Constants;
import com.icommerce.product.restapi.ProductController;
import com.icommerce.product.restapi.dto.CustomResponseBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.API_VERSION + Constants.PRODUCT_RESOURCE)
public class ProductRest implements ProductController {

    @Autowired
    private CreateProductUseCase createProductUseCase;
    @Autowired
    private FindProductsUseCase findProductsUseCase;
    @Autowired
    private UpdateProductUseCase updateProductUseCase;

    /**
     *
     */
    @GetMapping
    @Override
    public CustomResponseBody<List<ProductDTO>> find(@RequestParam(value = "search", required = false) String search,
                                            @RequestParam(value = "sort", required = false) String sort,
                                            @RequestParam(value = "size", required = false, defaultValue = "" + Integer.MAX_VALUE) Integer size,
                                            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page) {
        final List<ProductDTO> response = findProductsUseCase.execute(search, sort, size, page);
        return new CustomResponseBody<>(String.valueOf(HttpStatus.OK), Constants.SUCCESS_STATUS, "Search result", response);
    }

    /**
     *
     */
    @PostMapping
    @Override
    public CustomResponseBody<String> create(@RequestBody ProductDTO product) {
        final String id = createProductUseCase.execute(product);
        return new CustomResponseBody<>(String.valueOf(HttpStatus.OK), Constants.SUCCESS_STATUS, id);
    }

    /**
     * findById
     * @param id
     */
    @GetMapping("/{id}")
    @Override
    public CustomResponseBody<ProductDTO> findById(@PathVariable String id) {
        return new CustomResponseBody<>(String.valueOf(HttpStatus.OK),
                Constants.SUCCESS_STATUS, findProductsUseCase.execute(id));
    }

    /**
     *
     */
    @PutMapping("/{id}")
    @Override
    public CustomResponseBody<ProductDTO> update(@PathVariable String id,
                                        @RequestBody ProductDTO dto) {
        return new CustomResponseBody<>(String.valueOf(HttpStatus.OK),
                Constants.SUCCESS_STATUS, updateProductUseCase.execute(id, dto));
    }
}
