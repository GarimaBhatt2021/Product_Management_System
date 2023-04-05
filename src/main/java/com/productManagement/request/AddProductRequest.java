package com.productManagement.request;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductRequest implements Serializable {
	
	private static final long serialVersionUID = -2921623708450521799L;

	@NotBlank(message = "product.name.notnull")
	private String productName;

	private String desc;
	
	@NotBlank(message = "price.notnull")
	private Double actualPrice;
	
	@NotBlank(message = "price.notnull")
	private Double salePrice;
	
	private String image;
	
	private Integer categoryId;

	private List<MultipartFile> files;
	
	

}
