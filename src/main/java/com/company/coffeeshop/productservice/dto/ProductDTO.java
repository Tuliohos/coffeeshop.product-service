package com.company.coffeeshop.productservice.dto;

import com.company.coffeeshop.productservice.enums.ProductType;
import com.company.coffeeshop.productservice.model.Product;

import java.util.UUID;

public record ProductDTO (
        UUID id,
        String name,
        Integer calories,
        String description,
        Double price,
        ProductType type,
        Boolean isVegan,
        Boolean isGlutenFree,
        String imageUrl
){
    public static ProductDTO fromEntity(Product product) {
        return new ProductDTO(product.getId(),
                product.getName(),
                product.getCalories(),
                product.getDescription(),
                product.getPrice(),
                product.getType(),
                product.getIsVegan(),
                product.getIsGlutenFree(),
                product.getImageUrl());
    }

    public Product toEntity() {
        return Product.builder()
                .id(this.id)
                .name(this.name)
                .calories(this.calories)
                .description(this.description)
                .price(this.price)
                .type(this.type)
                .isVegan(this.isVegan)
                .isGlutenFree(this.isGlutenFree)
                .imageUrl(this.imageUrl)
                .build();
    }
}

