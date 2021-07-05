package com.sapient.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.sapient.spring.model.Product;

public interface IProductRepository extends CrudRepository<Product,Long>{
	
}
