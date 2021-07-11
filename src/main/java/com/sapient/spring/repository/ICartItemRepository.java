package com.sapient.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sapient.spring.model.CartItem;
@Repository
public interface ICartItemRepository extends CrudRepository<CartItem, Long>{

}
