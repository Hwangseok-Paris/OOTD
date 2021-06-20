package com.ootd.ootdApp.myPage.senondHand.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ootd.ootdApp.member.model.vo.Member;
import com.ootd.ootdApp.myPage.senondHand.model.DAO.SecondHandDAO;
import com.ootd.ootdApp.myPage.senondHand.model.vo.Product;
import com.ootd.ootdApp.myPage.senondHand.model.vo.Review_ProductInfo;
import com.ootd.ootdApp.myPage.senondHand.model.vo.myPageOrderList;
import com.ootd.ootdApp.product.model.vo.Review;

@Service
public class SecondHandServiceImpl implements SecondHandService {
	
	@Autowired
	SecondHandDAO secondHandDAO;

	@Override
	public int updatePassword(Member member) {
		return secondHandDAO.updatePassword(member);
	}

	@Override
	public int updateEamil(Member member) {
		return secondHandDAO.updateEmail(member);
	}

	@Override
	public int updatePhone(Member member) {
		return secondHandDAO.updatePhone(member);
	}

	@Override
	public int updateBank(Member member) {
		return secondHandDAO.updateBank(member);
	}

	@Override
	public int updateAddress(Member member) {
		return secondHandDAO.updateAddress(member);
	}

	@Override
	public List<myPageOrderList> selectOrderList(String member_name) {
		return secondHandDAO.selectOrderList(member_name);
	}

	@Override
	public List<Product> selectProductList(int member_no) {
		return secondHandDAO.selectProductList(member_no);
	}

	@Override
	public int deleteProduct(int productNo) {
		return secondHandDAO.deleteProduct(productNo);
	}

	@Override
	public List<myPageOrderList> selectSaleProductList(String member_name) {
		return secondHandDAO.selectSaleProductList(member_name);
	}

	@Override
	public int updateOrderSaleStatus(int orderNo) {
		System.out.println("Service SaleStatus orderNo -> " + orderNo);
		return secondHandDAO.updateOrderSaleStatus(orderNo);
	}

	@Override
	public int updatePurchaseStatus(int orderNo) {
		return secondHandDAO.updatePurchaseStatus(orderNo);
	}

	@Override
	public Review_ProductInfo selectReviewInfo(HashMap<String, Object> map) {
		
		return secondHandDAO.selectReviewInfo(map);
	}

	@Override
	public int insertReview(Review review) {
		
		return secondHandDAO.insertReview(review);
	}
	

}
