package com.productManagement.entities;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name", length = 50)
	private String productName;

	@Column(name = "description", length = 100)
	private String desc;

	@Column(name = "actual_price", nullable = false)
	private Double actualPrice;

	@Column(name = "sale_price", nullable = false)
	private Double salePrice;

	@Column(name = "created_on", nullable = false)
	@CreatedDate
	private OffsetDateTime createdOn;

	@Column(name = "updated_on", nullable = false)
	@LastModifiedDate
	private OffsetDateTime updatedOn;

	@Column(name = "category_id")
	private Integer categoryId;
	
	@Column(name = "available_quantity")
	private Integer availableQuantity = 10;

}
