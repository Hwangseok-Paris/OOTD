package com.ootd.ootdApp.order.model.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class cart implements Serializable{
	
	private static final long serialVersionUID = 8989L;
	
	
	private int member_no;
	private int cart_quantity;
	private String cart_size;

	private int product_no;
	private String product_name;
	private String product_detail;
	
	private String product_size;
	private int product_price;
	private int product_type;
	
	

}
