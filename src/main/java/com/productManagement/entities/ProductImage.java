package com.productManagement.entities;

import java.time.OffsetDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Entity
@Table(name = "product_image")
@Data
public class ProductImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "url")
	private String imageUrl;
	
	@Column(name = "is_featured")
	private Boolean isFeatured;
	
	@Column(name = "added_on")
	@CreatedDate
	private OffsetDateTime addedOn;
	
	@Column(name = "updated_on")
	@LastModifiedDate
	private OffsetDateTime updatedOn;
	
	@Column(name = "product_id")
	private Integer productId;
	
	@ManyToOne
	@JoinColumn(name = "product_id", insertable = false, updatable = false)
	private Product product;
	
}
