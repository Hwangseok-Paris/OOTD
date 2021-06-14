package com.ootd.ootdApp.order.model.vo;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderList implements Serializable{
	
	private static final long serialVersionUID = 402L;
	
	//order 테이블 불러오기
	private int order_no;
	private String receiver_name;
	private String order_address;
	private Date order_date;
	private String order_memo;
	private int total_price;

		
	// orderList에 input 하기 위함
	private int member_no;
	private String order_size;
	private int order_quantity;
	// private int order_no;
	private int product_no;
	
}
