package com.company.coffeeshop.productservice.dao.rowmapper;

import com.company.coffeeshop.productservice.enums.ProductType;
import com.company.coffeeshop.productservice.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Product.builder()
                .id((UUID) rs.getObject("id"))
                .name(rs.getString("name"))
                .calories(rs.getInt("calories"))
                .description(rs.getString("description"))
                .price(rs.getDouble("price"))
                .type(ProductType.valueOf(rs.getString("type")))
                .isVegan(rs.getBoolean("is_vegan"))
                .isGlutenFree(rs.getBoolean("is_gluten_free"))
                .imageUrl(rs.getString("image_url"))
                .build();
    }
}
