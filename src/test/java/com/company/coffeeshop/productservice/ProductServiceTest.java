package com.company.coffeeshop.productservice;

import com.company.coffeeshop.productservice.dao.interfaces.IProductDao;
import com.company.coffeeshop.productservice.dto.ProductDTO;
import com.company.coffeeshop.productservice.enums.ProductType;
import com.company.coffeeshop.productservice.model.Product;
import com.company.coffeeshop.productservice.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private IProductDao productDao;

    private ProductDTO productDTOMock;

    @BeforeEach
    void setup(){
        productDTOMock = ProductDTO.builder()
                .id(UUID.randomUUID())
                .name("nameTest")
                .price(1.0)
                .type(ProductType.BEVERAGE)
                .isVegan(Boolean.FALSE)
                .isGlutenFree(Boolean.FALSE)
                .calories(10)
                .description("testDescription")
                .imageUrl("fakeUrl")
                .build();
    }

    @Test
    void whenCreateProductExpectProductCreated() {
        //When
        productDTOMock.setId(null);

        // Then
        productService.createProduct(productDTOMock);

        // Assert
        verify(productDao, times(1)).create(any(Product.class));
    }

    @Test
    void whenGetProductByIdExpectCorrectProductReturned() {
        var productId = productDTOMock.getId();

        // When
        when(productDao.getById(productId)).thenReturn(productDTOMock.toEntity());

        // Then
        ProductDTO result = productService.getProductById(productId);

        // Assert
        verify(productDao, times(1)).getById(productId);
    }

    @Test
    void whenGetAllProductsExpectAllProductsReturned() {
        // When
        List<Product> products = new ArrayList<>();
        products.add(new Product());
        when(productDao.getAll()).thenReturn(products);

        // Then
        List<ProductDTO> result = productService.getAllProducts();

        // Assert
        verify(productDao, times(1)).getAll();
    }

    @Test
    void whenUpdateProductExpectProductUpdated() {

        // Then
        productService.updateProduct(productDTOMock);

        // Assert
        verify(productDao, times(1)).update(any(Product.class));
    }

    @Test
    void whenDeleteProductExpectProductDeleted() {
        // When
        UUID productId = UUID.randomUUID();

        // Then
        productService.deleteProduct(productId);

        // Assert
        verify(productDao, times(1)).delete(productId);
    }

}
