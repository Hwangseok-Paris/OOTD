package com.ootd.ootdApp.myPage.brand.model.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter

public class SaleList implements Serializable {

	private static final long serialVersionUID = 2L;

	private int order_no;
	private int sale_status;
	private int member_no;




}