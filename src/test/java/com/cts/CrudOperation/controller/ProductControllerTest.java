package com.cts.CrudOperation.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cts.CrudOperation.model.Product;
import com.cts.CrudOperation.repository.ProductRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductControllerTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllProducts() {
        // Mocking the behavior of the productRepository
        when(productRepository.findAll()).thenReturn(Arrays.asList(
                new Product(1L, "Product 1", 10.0),
                new Product(2L, "Product 2", 20.0)
        ));

        // Calling the method under test
        List<Product> result = productController.getAllProducts();

        // Verifying the result
        assertEquals(2, result.size());
        assertEquals("Product 1", result.get(0).getName());
        assertEquals("Product 2", result.get(1).getName());

        // Verifying that the productRepository.findAll() method was called once
        verify(productRepository, times(1)).findAll();
    }

    @Test
    public void testGetProductById() {
        Long productId = 1L;
        Product mockProduct = new Product(productId, "Product 1", 10.0);

        // Mocking the behavior of the productRepository
        when(productRepository.findById(productId)).thenReturn(Optional.of(mockProduct));

        // Calling the method under test
        Product result = productController.getProductById(productId);

        // Verifying the result
        assertEquals(productId, result.getId());
        assertEquals("Product 1", result.getName());

        // Verifying that the productRepository.findById() method was called once with the specified productId
        verify(productRepository, times(1)).findById(productId);
    }

    @Test
    public void testCreateProduct() {
        Product newProduct = new Product(null, "New Product", 15.0);
        Product savedProduct = new Product(1L, "New Product", 15.0);

        // Mocking the behavior of the productRepository
        when(productRepository.save(newProduct)).thenReturn(savedProduct);

        // Calling the method under test
        Product result = productController.createProduct(newProduct);

        // Verifying the result
        assertEquals(1L, result.getId());
        assertEquals("New Product", result.getName());

        // Verifying that the productRepository.save() method was called once with the specified newProduct
        verify(productRepository, times(1)).save(newProduct);
    }
}
