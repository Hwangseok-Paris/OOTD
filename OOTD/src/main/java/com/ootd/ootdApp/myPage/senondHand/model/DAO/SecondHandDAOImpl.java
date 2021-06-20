package com.ootd.ootdApp.myPage.senondHand.model.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ootd.ootdApp.member.model.vo.Member;
import com.ootd.ootdApp.myPage.senondHand.model.vo.Product;
import com.ootd.ootdApp.myPage.senondHand.model.vo.myPageOrderList;

@Repository
public class SecondHandDAOImpl implements SecondHandDAO {

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public int updatePassword(Member member) {
		return sqlSession.update("member-mapper.updatePassword", member);
	}

	@Override
	public int updateEmail(Member member) {
		return sqlSession.update("member-mapper.updateEmail", member);
	}

	@Override
	public int updatePhone(Member member) {
		return sqlSession.update("member-mapper.updatePhone", member);
	}

	@Override
	public int updateBank(Member member) {
		return sqlSession.update("member-mapper.updateBank", member);
	}

	@Override
	public int updateAddress(Member member) {
		return sqlSession.update("member-mapper.updateAddress", member);
	}

	@Override
	public List<myPageOrderList> selectOrderList(String member_name) {
		return sqlSession.selectList("orderList-mapper.selectOrderList", member_name);
	}

	@Override
	public List<Product> selectProductList(int member_no) {
		return sqlSession.selectList("productList-mapper.selectProductList", member_no);
	}

	@Override
	public int deleteProduct(int productNo) {
		return sqlSession.delete("productList-mapper.deleteProduct", productNo);
	}

	@Override
	public List<myPageOrderList> selectSaleProductList(String member_name) {
		return sqlSession.selectList("orderList-mapper.selectSaleProductList", member_name);
	}

	@Override
	public int updateOrderSaleStatus(int orderNo) {
		System.out.println("DAO Sale Status -> " + orderNo);
		
		int resultSale = sqlSession.update("orderList-mapper.updateOrderSaleStatus", orderNo);
		int resultOrder = sqlSession.update("orderList-mapper.updateOrderStatus", orderNo);
		
		System.out.println(resultSale + "/" + resultOrder);
		
		int result = 0;
		
		if(resultSale * resultOrder == 1) {
			result = 1;
		} else result = 0;
		
		return result;
	}

	@Override
	public int updatePurchaseStatus(int orderNo) {
		
		int result1 = sqlSession.update("orderList-mapper.updatePurchaseStatus", orderNo); 
		int result2 = sqlSession.update("orderList-mapper.updatefianlstatus", orderNo);
		
		System.out.println(result1 + "/" + result2);
		
		int result = 0;
		
		if(result1 * result2 == 1) {
			result = 1;
		} else result = 0;
		
		return result;
	}




}
