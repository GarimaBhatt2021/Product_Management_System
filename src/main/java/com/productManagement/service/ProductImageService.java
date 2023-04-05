package com.productManagement.service;

import com.productManagement.entities.ProductImage;

public interface ProductImageService {

	ProductImage getFeaturedImageById(Long productId);

	ProductImage setFeaturedImage(Long productId, Long imageId);

	

}
