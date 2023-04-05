package com.productManagement.service;

import java.util.List;
import com.productManagement.entities.Product;

public interface ProductBaseService {
	

	public Product saveProduct(Product product);
	
	public List<Product> getAllProducts();
	
	public void deleteProduct(Integer id);
	
	public Product getProductById(Integer id);

}
