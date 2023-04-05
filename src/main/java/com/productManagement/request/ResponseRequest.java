package com.productManagement.request;

import java.io.Serializable;
import java.util.List;

import com.productManagement.entities.Cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseRequest implements Serializable{
	
		private static final long serialVersionUID = -3557076282072040886L;

		private Double amount;

	    private String date;	    

}
