package com.ootd.ootdApp.myPage.senondHand.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseProduct {
	
	int product_no;
	String product_name;
	String product_detail;
	String product_sizeinfo;
	String product_size;
	int product_price;
	int product_stock;
	int product_type;
	int memeber_no;
	
}
