package com.ootd.ootdApp.myPage.brand.model.vo;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Order implements Serializable {
	
	private static final long serialVersionUID = 222L;
	
	private int order_no;
	private String receiver_name;
	private String order_address;
	private Date order_date;
	private String order_memo;
	private int total_price;
	private int member_no;

}
