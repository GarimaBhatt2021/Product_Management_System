package com.productManagement.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.productManagement.entities.Product;
import com.productManagement.request.AddProductRequest;

@Repository
public interface Productdao extends JpaRepository<Product , Integer> {

	Product save(AddProductRequest addProductRequest);

	Optional<Product> findById(Integer id);
	
	@Query("SELECT p FROM Product p WHERE p.productName LIKE %?1%")
//			+ "OR p.category.name LIKE %?1%")
//	@Query("SELECT p FROM Product p , Category c"
//			+ "WHERE p.productName OR c.name "
//			+ "LIKE %?1%")
//	@Query("select * from products , categories where products.name or categories.name like %?1%" )
	List<Product> findBySearch(String keyword);

//	@Query("SELECT p FROM Product p ORDER BY p.salePrice ASC")
//	List<Product> findAll(String field);
//	@Query()
//	List<Product> findAllBySalePrice(String field);
//
//	List<Product> findAllBySalePrice(Sort by,String field);
//	@Query("SELECT p FROM Product p ORDER BY p.salePrice ASC")
////			+ "OR p.updatedOn ASC")
//	List<Product> findByField(String field);

}
