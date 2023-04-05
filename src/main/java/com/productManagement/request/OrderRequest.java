package com.productManagement.request;

import java.io.Serializable;
import java.util.List;
import com.productManagement.entities.Cart;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderRequest implements Serializable {
	private static final long serialVersionUID = -8863949609629434892L;

	private List<Cart> cartItems;
	
	private String userName;
	
}
