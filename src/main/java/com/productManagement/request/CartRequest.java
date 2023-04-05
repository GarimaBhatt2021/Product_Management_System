package com.productManagement.request;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartRequest implements Serializable{

	private static final long serialVersionUID = 7130785572592341233L;
	
	public Integer productId;
	
	public Integer orderId;
	
	public Double amount;


}
