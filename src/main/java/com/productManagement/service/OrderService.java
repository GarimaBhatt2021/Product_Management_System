package com.productManagement.service;

import java.util.List;
import com.productManagement.entities.Cart;
import com.productManagement.entities.ProductOrder;
import com.productManagement.request.OrderRequest;

public interface OrderService {

	public ProductOrder getOrderDetail(Integer orderId);

	public Double getCartAmount(List<Cart> cartItems,OrderRequest request);

	public ProductOrder saveOrder(ProductOrder productOrder);
	
	public List<ProductOrder> getAllOrders();
	
	public OrderRequest getCartDetails(Integer userId);

	public ProductOrder getCartById(Integer orderId);
	
	public String deleteCartItem(Integer cartId);
	
	public void deleteOrderItem(Integer orderId);

}
