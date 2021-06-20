package com.ootd.ootdApp.myPage.senondHand.model.DAO;

import java.util.List;

import com.ootd.ootdApp.member.model.vo.Member;
import com.ootd.ootdApp.myPage.senondHand.model.vo.Product;
import com.ootd.ootdApp.myPage.senondHand.model.vo.myPageOrderList;

public interface SecondHandDAO {
	
	int updatePassword(Member member);

	int updateEmail(Member member);

	int updatePhone(Member member);

	int updateBank(Member member);

	int updateAddress(Member member);

	List<myPageOrderList> selectOrderList(String member_name);

	List<Product> selectProductList(int member_no);

	int deleteProduct(int productNo);

	List<myPageOrderList> selectSaleProductList(String member_name);

	int updateOrderSaleStatus(int orderNo);


	int updatePurchaseStatus(int orderNo);


}
