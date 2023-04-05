package com.productManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.productManagement.constants.Constants;
import com.productManagement.dao.Productdao;
import com.productManagement.entities.Product;
import com.productManagement.request.AddProductRequest;
import com.productManagement.service.MessageService;
import com.productManagement.service.ProductService;

@RestController
@RequestMapping(Constants.BASE_URL)
@CrossOrigin("*")
public class ProductController {
	@Autowired
	public Productdao productdao;

	private final ProductService productService;
	private final MessageService messageService;

	public ProductController(ProductService productService, MessageService messageService) {
		super();
		this.productService = productService;
		this.messageService = messageService;
	}

	@GetMapping(value = Constants.LIST_PRODUCTS)
	public ResponseEntity<?> getAllProduct() {
		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
	}

	@GetMapping(value = Constants.SEARCH_PRODUCT)
	public ResponseEntity<?> searchList(@PathVariable("keyword") String keyword) {
		return new ResponseEntity<>(productService.getSearchProducts(keyword), HttpStatus.OK);
	}

	@GetMapping(value = Constants.SEARCH_CATEGORY)
	public ResponseEntity<?> searchCat(@PathVariable("catName") String catName) {
		return new ResponseEntity<>(productService.getSearchCat(catName), HttpStatus.OK);
	}

	@GetMapping(value = Constants.SHOW_PRODUCT)
	public ResponseEntity<?> getProductById(@PathVariable Integer id) {
		return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
	}

	@DeleteMapping(value = Constants.DELETE_PRODUCT)
	public ResponseEntity<?> deleteProduct(@PathVariable final Integer id) {
		return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
	}

	@PutMapping(value = Constants.UPDATE_PRODUCT, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> updateProduct(@RequestBody AddProductRequest addProductRequest, Product product,
			@PathVariable Integer id) {
		return new ResponseEntity<>(productService.updateProduct(addProductRequest, product, id), HttpStatus.ACCEPTED);
	}

	@PostMapping(value = Constants.UPLOAD_PRODUCT, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> uploadProduct(@RequestParam("productName") String productName,
			@RequestParam("desc") String desc, @RequestParam("actualPrice") Double actualPrice,
			@RequestParam("salePrice") Double salePrice, @RequestParam("categoryId") Integer categoryId,
			@RequestParam("files") List<MultipartFile> files) throws Exception {
		try {
			productService.uploadProduct(productName, desc, actualPrice, salePrice, categoryId, files);

			return ResponseEntity.ok().body("Successfully Uploaded");
		} catch (Exception e) {
			return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
		}
	}

//	@GetMapping(value = Constants.ASC_SORTING)
//	public ResponseEntity<?> sortAsc(@PathVariable("field") String field) {
//		return new ResponseEntity<>(productService.getSortAsc(field), HttpStatus.OK);
//
//	}
//
//	@GetMapping(value = Constants.DESC_LATEST)
//	public ResponseEntity<?> sortLatest(@PathVariable("field") String field) {
//		return new ResponseEntity<>(productService.getLatest(field), HttpStatus.OK);
//
//	}

	@GetMapping(value = Constants.SORT_BY)
	public ResponseEntity<?> sorted(@RequestParam(defaultValue = "ASC") String orderBy,
			@PathVariable("field") String field) {
		return new ResponseEntity<>(productService.getOrder(orderBy, field), HttpStatus.OK);
	}

}
