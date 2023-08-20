package com.company.coffeeshop.productservice.dto;

import com.company.coffeeshop.productservice.enums.ProductType;
import com.company.coffeeshop.productservice.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private UUID id;
    private String name;
    private Integer calories;
    private String description;
    private Double price;
    private ProductType type;
    private Boolean isVegan;
    private Boolean isGlutenFree;
    private String imageUrl;

    public static ProductDTO fromEntity(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .calories(product.getCalories())
                .description(product.getDescription())
                .price(product.getPrice())
                .type(product.getType())
                .isVegan(product.getIsVegan())
                .isGlutenFree(product.getIsGlutenFree())
                .imageUrl(product.getImageUrl())
                .build();
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

