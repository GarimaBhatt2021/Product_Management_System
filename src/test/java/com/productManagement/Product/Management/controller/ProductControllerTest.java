//package com.productManagement.Product.Management.controller;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.validation.BindingResult;
//
//import com.productManagement.entities.Product;
//import com.productManagement.service.ProductService;
//import com.productManagement.serviceImpl.ServiceImpl;
//
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class ProductControllerTest {
//	
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@Mock
//	private ProductService productService;
//	
//	@Mock
//	private ServiceImpl serviceImpl;
//	
//	BindingResult result = mock(BindingResult.class);
//	
//	@Test
//	void testAddProduct() {
//		when(productService.addProduct(Mockito.any(Product.class)));
//		
//	}
//
//}
