package com.productManagement.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.productManagement.entities.ProductOrder;
import com.productManagement.request.OrderRequest;

@Repository
public interface OrderDao extends JpaRepository<ProductOrder, Integer>{

	Optional<ProductOrder> findById(Integer orderId);
	
	void save(OrderRequest request);

	List<ProductOrder> findAllByUserId(@Param("u") Integer userId);

}
