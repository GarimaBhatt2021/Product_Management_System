package com.productManagement.constants;

public class Constants {
	public static final String BASE_URL = "/api"; 
//product	
	public static final String SAVE_PRODUCT = "/product/add";
	public static final String UPLOAD_PRODUCT = "/product/upload";
	public static final String LIST_PRODUCTS = "/product/list";
	public static final String DELETE_PRODUCT = "/product/delete/{id}";
	public static final String UPDATE_PRODUCT = "/product/update/{id}";
	public static final String SHOW_PRODUCT = "/product/show/{id}";
//filter	
	public static final String SEARCH_PRODUCT = "/product/search/{keyword}";
	public static final String SEARCH_CATEGORY = "/category/search/{catName}";
	public static final String DESC_LATEST = "/product/latest/{field}";
	public static final String ASC_SORTING = "/product/oldest/{field}";
	public static final String SORT_BY = "/sortBy/{field}";

//Cart	
	public static final String ADD_TO_CART = "/cart/add";
	public static final String SHOW_CART = "/cart/show/{userId}";
	public static final String DELETE_CART_ITEM = "cart/delete/{cartId}";

	//not ncsry
	public static final String LIST_CART = "/cart/list/{orderId}";
	public static final String DELETE_ORDER_ITEM = "order/delete/{orderId}";
//Order
	public static final String SHOW_ORDER = "/order/show/{orderId}";
	public static final String LIST_ORDERS = "/order/list";
	
	public static final String DATE_TIME_FORMAT = "yyyy-dd-mm";

	public static final String GET_CART = "/cart/get/{cartId}";




}
