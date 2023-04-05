package com.productManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.productManagement.entities.ProductImage;

@Repository
public interface ProductImageDao extends JpaRepository<ProductImage, Integer>{
	
	Boolean existsByIdAndIsFeatured(Integer imageId,Boolean isFeatured);

	Integer getProductById(Integer id);

	Integer deleteByProductId(Integer productId);


}
