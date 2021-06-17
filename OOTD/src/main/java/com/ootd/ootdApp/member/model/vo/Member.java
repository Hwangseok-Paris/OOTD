package com.ootd.ootdApp.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member implements Serializable{
	
	private int member_no;
	private String member_id;
	private String member_nickname;
	private String member_pw;
	private String member_name;
	private String email;
	private String phone;
	private String[] address;
	private Date enroll_date;
	private String brand_name;
	private String account_number;
	private int login_type;
	private String bank_code;
	private int member_no; 
}
