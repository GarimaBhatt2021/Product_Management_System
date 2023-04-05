package com.productManagement.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.productManagement.dao.CartDao;
import com.productManagement.dao.OrderDao;
import com.productManagement.dao.Productdao;
import com.productManagement.dao.UserDao;
import com.productManagement.entities.Cart;
import com.productManagement.entities.ProductOrder;
import com.productManagement.entities.User;
import com.productManagement.request.OrderRequest;
import com.productManagement.entities.Product;
import com.productManagement.service.OrderService;
import com.productManagement.service.UserService;

@Service
public class OrderServiceImpl implements OrderService {

	private final Productdao productdao;
	private final OrderDao orderDao;
	private final CartDao cartDao;
	@Autowired
	public UserService userService;
	@Autowired
	public UserDao userDao;

	public OrderServiceImpl(Productdao productdao, OrderDao orderDao, CartDao cartDao) {
		super();
		this.productdao = productdao;
		this.orderDao = orderDao;
		this.cartDao = cartDao;
	}

	@Override
	public List<ProductOrder> getAllOrders() {
		return orderDao.findAll();
	}

	@Override
	public ProductOrder getOrderDetail(Integer orderId) {
		Optional<ProductOrder> productOrder = this.orderDao.findById(orderId);
		return productOrder.isPresent() ? productOrder.get() : null;
	}

	public Double getCartAmount(List<Cart> cartList, OrderRequest request) {

		Double totalCartAmount = 0d;
		Double singleCartAmount = 0d;
		Integer AvailableQuantity = 0;

		for (Cart cart : cartList) {

			Integer productId = cart.getProductId();
			Optional<Product> product = productdao.findById(productId);
			if (product.isPresent()) {
				Product product1 = product.get();
				if (product1.getAvailableQuantity() < cart.getQuantity()) {
					singleCartAmount = product1.getSalePrice() * product1.getAvailableQuantity();
					cart.setQuantity(product1.getAvailableQuantity());
				} else {
					singleCartAmount = cart.getQuantity() * product1.getSalePrice();
					AvailableQuantity = product1.getAvailableQuantity() - cart.getQuantity();
				}
				totalCartAmount = totalCartAmount + singleCartAmount;
				product1.setAvailableQuantity(AvailableQuantity);
				cart.setProductName(product1.getProductName());
				System.out.println("productname" + product1.getProductName());
				cart.setSalePrice(singleCartAmount);

				User user = new User();
				user.setName(request.getUserName());
				Integer userIdFromDb = userService.isUserPresent(user);
				if (userIdFromDb != null) {
					user.setId(userIdFromDb);
				} else {
					user = userService.saveUser(user);
				}
				ProductOrder productOrder = new ProductOrder();
				productOrder.setUserId(user.getId());
				productOrder = orderDao.save(productOrder);

				cart.setOrderId(productOrder.getId());
				productdao.save(product1);
			}
			cartDao.save(cart);
		}
		return totalCartAmount;
	}

	public ProductOrder saveOrder(ProductOrder productOrder) {
		return orderDao.save(productOrder);
	}

	@Override
	public OrderRequest getCartDetails(Integer userId) {
		Optional<User> user = userDao.findById(userId);
//		Optional<Product> product = productdao.findById(userId);
//		if(!userId.contains(productId)
//		{
//			userId.add(product.quantity+noOfIdRepeatation)
//		}
		List<ProductOrder> orderIds = orderDao.findAllByUserId(userId);
		OrderRequest response = new OrderRequest();
		response.setUserName(user.get().getName());
		List<Integer> orderIdInts = new ArrayList<>();
		for(ProductOrder p : orderIds) {
			orderIdInts.add(p.getId());
		}
		response.setCartItems(cartDao.findAllByOrderIdIn(orderIdInts));
		return response;
	}

	@Override
	public ProductOrder getCartById(Integer orderId) {
		Optional<Cart> list = cartDao.findById(orderId);
		return orderDao.findById(orderId).get();
	}

	@Override
	@Transactional
	public String deleteCartItem(Integer cartId) {
		if(cartId != null) {
			cartDao.deleteById(cartId);
			return "deleted";
		}else
		return "doesn't exists";
	}

	@Override
	public void deleteOrderItem(Integer orderId) {
		orderDao.deleteById(orderId);

	}
}
