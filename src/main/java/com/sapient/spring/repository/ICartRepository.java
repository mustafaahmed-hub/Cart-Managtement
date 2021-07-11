package com.sapient.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sapient.spring.model.Cart;
@Repository
public interface ICartRepository extends CrudRepository<Cart, Long>{

}
