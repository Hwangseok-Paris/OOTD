package com.ootd.ootdApp.product.model.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

	private int product_no;
	private String product_name;
	private String product_detail;
	private String product_sizeinfo;
	private String product_size;
	private int product_price;
	private int product_stock_s;
	private int product_stock_m;
	private int product_stock_l;
	private int product_type;
	private int member_no;
	private char product_status;
	
	
	private int fileCount;			// 각 상품당 첨부파일 갯수
	private String brand_name;		// 상품의 브랜드 명 담을 추가변수
	private String att_name;		// 상품의 각 대표(1)번 사진 담아오는 변수
	
}
