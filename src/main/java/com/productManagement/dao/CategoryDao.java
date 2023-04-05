package com.productManagement.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.productManagement.entities.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer>{

	@Query("SELECT c FROM Category c WHERE c.name LIKE %?1%")
	List<Category> findCategoryBySearch(String catName);
	
//	@Query("SELECT p.productName , c.name FROM Product p WHERE"
//			+ "CONCAT(p.name , c.name )"
//			+ "LIKE %?1% %?2%")
//	List<Category> findAll(String a,String b);

}
