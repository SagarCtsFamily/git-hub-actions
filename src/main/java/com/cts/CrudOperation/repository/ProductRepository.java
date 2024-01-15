package com.cts.CrudOperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.CrudOperation.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	
}
