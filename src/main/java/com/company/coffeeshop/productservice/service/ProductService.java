package com.company.coffeeshop.productservice.service;

import com.company.coffeeshop.productservice.dao.interfaces.IProductDao;
import com.company.coffeeshop.productservice.dto.ProductDTO;
import com.company.coffeeshop.productservice.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService implements IProductService {

    private final IProductDao productDao;

    @Autowired
    public ProductService(IProductDao productDao) {
        this.productDao = productDao;
    }

    public void createProduct(ProductDTO productDTO) {
        var product = productDTO.toEntity();
        productDao.create(product);
    }

    public ProductDTO getProductById(UUID id) {
        var product = productDao.getById(id);
        return ProductDTO.fromEntity(product);
    }

    public List<ProductDTO> getAllProducts() {
        var products = productDao.getAll();
        return products.stream()
                .map(ProductDTO::fromEntity)
                .toList();
    }

    public void updateProduct(ProductDTO productDTO) {
        var product = productDTO.toEntity();
        productDao.update(product);
    }

    public void deleteProduct(UUID id) {
        productDao.delete(id);
    }
}