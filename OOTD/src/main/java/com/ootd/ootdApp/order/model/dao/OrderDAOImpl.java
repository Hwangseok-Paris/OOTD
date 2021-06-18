package com.ootd.ootdApp.order.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ootd.ootdApp.order.model.vo.Cart;
import com.ootd.ootdApp.order.model.vo.Order;

@Repository
public class OrderDAOImpl implements OrderDAO {
	
	
	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<Cart> selectCartList(int member_no) {
		
		return sqlSession.selectList("cart-mapper.selectCartList", member_no);
	}

	@Override
	public int deleteCartProduct(int cart_no) {
		
		
		return sqlSession.delete("cart-mapper.deleteCartProduct", cart_no);
	}


	@Override
	public int deleteCartProductAll(int member_no) {
		
		return sqlSession.delete("cart-mapper.deleteCartProductAll", member_no);
	}

	@Override
	public int updateQuantity(Map<String, String> map) {
		
		return sqlSession.delete("cart-mapper.updateQuantity", map);
	}

	@Override
	public List<Cart> selectedCartList(int cart_no) {
		
		return sqlSession.selectList("cart-mapper.selectedCartList", cart_no);
	}

	@Override
	public int insertOrder(Order order) {

		return sqlSession.insert("order-mapper.insertOrder", order);
	}



}
