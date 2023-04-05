package com.productManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.productManagement.constants.Constants;
import com.productManagement.dao.CartDao;
import com.productManagement.dao.OrderDao;
import com.productManagement.entities.ProductOrder;
import com.productManagement.request.OrderRequest;
import com.productManagement.request.ResponseRequest;
import com.productManagement.service.OrderService;
import com.productManagement.service.ProductService;
import com.productManagement.service.UserService;
import com.productManagement.util.DateUtil;

@RestController
@RequestMapping(Constants.BASE_URL)
@CrossOrigin("*")
public class CartController{
	
	private final OrderService orderService;
	private final ProductService productService;
	private final UserService userService;

	@Autowired
	public CartDao cartDao;
	@Autowired
	public OrderDao orderDao;
	
	public CartController(OrderService orderService,ProductService productService,UserService userService) {
		super();
		this.orderService = orderService;
		this.productService = productService;
		this.userService = userService;
	}
		
	@PostMapping(value = Constants.ADD_TO_CART)
	public ResponseEntity<ResponseRequest> addToCart(@RequestBody OrderRequest request){
        ResponseRequest responseRequest = new ResponseRequest();
        Double amount = orderService.getCartAmount(request.getCartItems(),request);

        responseRequest.setAmount(amount);
        responseRequest.setDate(DateUtil.getCurrentDateTime());
        
        return ResponseEntity.ok(responseRequest);
    }
	
	
	@GetMapping(value = Constants.SHOW_ORDER)//no
    public ResponseEntity<ProductOrder> getOrderDetails(@PathVariable Integer orderId) {
		ProductOrder productOrder = orderService.getOrderDetail(orderId);
        return ResponseEntity.ok(productOrder);
    }
	
	@GetMapping(value = Constants.LIST_ORDERS)
	public ResponseEntity<?> getAllOrders(){
		return ResponseEntity.ok(orderService.getAllOrders());
	}
	
	//yes
	@GetMapping(value = Constants.SHOW_CART)
	public ResponseEntity<?> getCartDetails(@PathVariable Integer userId){
		return ResponseEntity.ok(orderService.getCartDetails(userId));
	}	
	
	@DeleteMapping(value = Constants.DELETE_CART_ITEM)
	public ResponseEntity<?> deleteCartItem(@PathVariable final Integer cartId) {
		return new ResponseEntity<>(orderService.deleteCartItem(cartId), HttpStatus.OK);
	}
	
	@DeleteMapping(value = Constants.DELETE_ORDER_ITEM)
	public void deleteOrderItem(@PathVariable Integer orderId){
		orderDao.deleteById(orderId);
	}
	
}
