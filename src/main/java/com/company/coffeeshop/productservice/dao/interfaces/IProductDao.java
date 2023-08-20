package com.company.coffeeshop.productservice.dao.interfaces;

import com.company.coffeeshop.productservice.model.Product;

import java.util.List;
import java.util.UUID;

public interface IProductDao {
    void create(Product product);

    Product getById(UUID id);

    List<Product> getAll();

    void update(Product product);

    void delete(UUID id);
}
