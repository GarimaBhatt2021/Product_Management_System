package com.productManagement.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.productManagement.entities.Category;
import com.productManagement.entities.Product;
import com.productManagement.request.AddProductRequest;

public interface ProductService {

	public Product uploadProduct(String productName, String desc, Double actualPrice, Double salePrice,Integer categoryId,
			List<MultipartFile> files);

	public List<Product> getAllProducts();

	public String deleteProduct(Integer id);

	public Product getProductById(Integer id);

	public Product updateProduct(AddProductRequest addProductRequest, Product product, Integer id);

	public Product addProduct(Product product);

	public List<Product> getSearchProducts(String keyword);

	public List<Category> getSearchCat(String catName);

//	public List<Product> getSortAsc(String field);
//
//	public List<Product> getLatest(String field);

	public List<Product> getOrder(String orderBy, String field);

}
