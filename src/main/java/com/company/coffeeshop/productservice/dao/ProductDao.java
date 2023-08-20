package com.company.coffeeshop.productservice.dao;

import com.company.coffeeshop.productservice.dao.interfaces.IProductDao;
import com.company.coffeeshop.productservice.dao.rowmapper.ProductRowMapper;
import com.company.coffeeshop.productservice.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ProductDao implements IProductDao {

    private final JdbcTemplate jdbcTemplate;

    public ProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Product product) {
        String sql = """
                    INSERT INTO products (name, calories, description, price, type, is_vegan, is_gluten_free, image_url)
                    VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;

        update(sql,
                product.getName(),
                product.getCalories(),
                product.getDescription(),
                product.getPrice(),
                product.getType().toString(),
                product.getIsVegan(),
                product.getIsGlutenFree(),
                product.getImageUrl());
    }

    @Override
    public Product getById(UUID id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        List<Product> products = jdbcTemplate.query(sql, new Object[]{id}, new ProductRowMapper());
        return products.isEmpty() ? null : products.get(0);
    }

    @Override
    public List<Product> getAll() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, new ProductRowMapper());
    }

    @Override
    public void update(Product product) {
        String sql = """
                    UPDATE products SET name = ?, calories = ?, description = ?, price = ?, type = ?,
                    is_vegan = ?, is_gluten_free = ?, image_url = ? WHERE id = ?
                """;

        update(sql,
                product.getName(),
                product.getCalories(),
                product.getDescription(),
                product.getPrice(),
                product.getType().toString(),
                product.getIsVegan(),
                product.getIsGlutenFree(),
                product.getImageUrl(),
                product.getId());
    }

    @Override
    public void delete(UUID id) {
        String sql = "DELETE FROM products WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private void update(String sql, Object... params) {
        jdbcTemplate.update(sql, params);
    }

}

