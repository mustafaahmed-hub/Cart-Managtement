package com.sapient.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sapient.spring.model.Orders;

@Repository
public interface IOrderRepository extends CrudRepository<Orders, Long>{

}
