package com.sapient.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.sapient.spring.model.Cart;

public interface ICartRepository extends CrudRepository<Cart, Long>{

}
