package com.sapient.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Orders {
	@Id
	private long id;
	
	private long customer_id;
	
	private Double totalValue;
	
	
	
}
