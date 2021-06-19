package com.ootd.ootdApp.myPage.senondHand.model.service;

import java.util.List;

import com.ootd.ootdApp.member.model.vo.Member;
import com.ootd.ootdApp.myPage.senondHand.model.vo.Product;
import com.ootd.ootdApp.myPage.senondHand.model.vo.myPageOrderList;

public interface SecondHandService {
	
	int updatePassword(Member member); //회원 비밀번호 변경

	int updateEamil(Member member); // 회원 이메일 변경

	int updatePhone(Member member); // 회원 전화번호 변경

	int updateBank(Member member); // 회원 계좌번호 변경

	int updateAddress(Member member);

	List<myPageOrderList> selectOrderList(String member_name);

	List<Product> selectProductList(int member_no);

	int deleteProduct(int productNo);

	List<myPageOrderList> selectSaleProductList(String member_name);

	int updateOrderSaleStatus(int orderNo);

	String selectOrderStatus(int orderNo);

}
