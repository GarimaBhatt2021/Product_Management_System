package com.productManagement.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.productManagement.entities.Cart;
import com.productManagement.request.OrderRequest;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer>{

	List<Cart> findAllById(Integer userId);

	List<Cart> save(OrderRequest request);
	
	Integer deleteByOrderId(Integer orderId);

//	@Query(value = "select c from Cart c where c.orderId in ?1", nativeQuery = true)
//	List<Cart> findAllByOrderId(List<ProductOrder> orderIds);

	List<Cart> findAllByOrderIdIn(List<Integer> orderIds);

}
