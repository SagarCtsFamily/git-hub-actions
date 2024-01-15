package com.cts.CrudOperation.model;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductTest {

    @Test
    void testProductConstructorAndGetters() {
        // Arrange
        Long id = 1L;
        String name = "Test Product";
        double price = 25.0;

        // Act
        Product product = new Product(id, name, price);

        // Assert
        assertEquals(id, product.getId());
        assertEquals(name, product.getName());
        assertEquals(price, product.getPrice(), 0.01); // Specify a delta for double comparisons
    }

    @Test
    void testSetters() {
        // Arrange
        Product product = new Product(null, null, 0.0);

        // Act
        Long newId = 2L;
        String newName = "Updated Product";
        double newPrice = 30.0;

        product.setId(newId);
        product.setName(newName);
        product.setPrice(newPrice);

        // Assert
        assertEquals(newId, product.getId());
        assertEquals(newName, product.getName());
        assertEquals(newPrice, product.getPrice(), 0.01);

       
    }
    
    
}

