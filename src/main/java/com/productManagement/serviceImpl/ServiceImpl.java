package com.productManagement.serviceImpl;

import java.time.OffsetDateTime;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.productManagement.dao.CategoryDao;
import com.productManagement.dao.ProductImageDao;
import com.productManagement.dao.Productdao;
import com.productManagement.entities.Category;
import com.productManagement.entities.Product;
import com.productManagement.entities.ProductImage;
import com.productManagement.request.AddProductRequest;
import com.productManagement.service.MessageService;
import com.productManagement.service.ProductService;

@Service
@Transactional
public class ServiceImpl implements ProductService {

	private static final String ASC = null;
	private final MessageService messageService;
	private final Productdao productdao;
	private final ProductImageDao productImageDao;
	private final CategoryDao categoryDao;

	@Autowired
	public ServiceImpl(MessageService messageService, Productdao productdao, ProductImageDao productImageDao,CategoryDao categoryDao) {
		this.messageService = messageService;
		this.productdao = productdao;
		this.productImageDao = productImageDao;
		this.categoryDao = categoryDao;
	}

	@Override
	public List<Product> getAllProducts() {
		return productdao.findAll();
	}
	
	
	@Override
	public List<Product> getSearchProducts(String keyword) {
		if(keyword != null) {
			return productdao.findBySearch(keyword);
		}
		return productdao.findAll();
	}
	
	@Override
	public List<Category> getSearchCat(String catName) {
		if(catName != null) {
			return categoryDao.findCategoryBySearch(catName);
		}
		return categoryDao.findAll();
	}

	

	@Override
	public String deleteProduct(Integer productId) {
		Product product = productdao.findById(productId).get();
		if (product != null) {
			productImageDao.deleteByProductId(productId);
				productdao.delete(product);
					return "deleted";
			}
		return (messageService.getMessage("not.exist"));
	}

	@Override
	public Product getProductById(Integer id) {
		return productdao.findById(id).get();
	}

	@Override
	public Product updateProduct(AddProductRequest addProductRequest, Product product, Integer id) {
		product.setProductName(addProductRequest.getProductName());
		product.setDesc(addProductRequest.getDesc());
		product.setActualPrice(addProductRequest.getActualPrice());
		product.setSalePrice(addProductRequest.getSalePrice());
		product.setCreatedOn(OffsetDateTime.now());
		product.setUpdatedOn(OffsetDateTime.now());
		product.setCategoryId(addProductRequest.getCategoryId());

		productdao.save(product);
		return product;
	}


	@Override
	public Product addProduct(Product product) {
		return productdao.save(product);
	}


	public Product uploadProduct(String productName, String desc, Double actualPrice, Double salePrice,Integer categoryId,
			List<MultipartFile> files) {
		Product product = new Product();
		product.setProductName(productName);
		product.setDesc(desc);
		product.setActualPrice(actualPrice);
		product.setSalePrice(salePrice);
		product.setCategoryId(categoryId);
		product.setCreatedOn(OffsetDateTime.now());
		product.setUpdatedOn(OffsetDateTime.now());
		product = productdao.saveAndFlush(product);

		for (int i = 0; i < files.size(); i++) {
			MultipartFile multipartFile = files.get(i);
			ProductImage image = new ProductImage();
			image.setImageUrl(multipartFile.getName());
			image.setProductId(product.getId());
			image.setIsFeatured(i==0);
			image.setAddedOn(OffsetDateTime.now());
			image.setUpdatedOn(OffsetDateTime.now());
			productImageDao.saveAndFlush(image);
		}
		return product;
	}

//	@Override
//	public List<Product> getSortAsc(String field) {
//		return productdao.findAll(Sort.by(Sort.Direction.ASC,field));
//	}
//	
//	
//	public List<Product> getLatest(String field){
//		return productdao.findAll(Sort.by(Sort.Direction.DESC,field));
//	}

	@Override
	public List<Product> getOrder(String orderBy, String field) {
		if(orderBy.equals("ASC")) {
			return productdao.findAll(Sort.by(Sort.Direction.ASC,field));
		}else {
			return productdao.findAll(Sort.by(Sort.Direction.DESC,field));
		}
	}
	

}
