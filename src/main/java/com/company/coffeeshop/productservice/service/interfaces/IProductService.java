package com.company.coffeeshop.productservice.service.interfaces;

import com.company.coffeeshop.productservice.dto.ProductDTO;

import java.util.List;
import java.util.UUID;

public interface IProductService {

    void createProduct(ProductDTO product);

    ProductDTO getProductById(UUID id);

    List<ProductDTO> getAllProducts();

    void updateProduct(ProductDTO product);

    void deleteProduct(UUID id);
}
