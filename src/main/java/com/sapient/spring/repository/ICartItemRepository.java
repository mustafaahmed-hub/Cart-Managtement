package com.sapient.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.sapient.spring.model.CartItem;

public interface ICartItemRepository extends CrudRepository<CartItem, Long>{

}
