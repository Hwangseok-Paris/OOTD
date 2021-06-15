package com.ootd.ootdApp.product.model.vo;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attachment implements Serializable {

	private int att_no;
	private String att_name;
	private Date att_date;
	private char att_level;
	private char att_status;
	private int product_no;
	
	
}
