package com.ootd.ootdApp.order.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ootd.ootdApp.order.model.vo.Cart;

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
	public int updateQuantity(int cart_no, int cart_quantity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCartProductAll(int member_no) {
		
		return sqlSession.delete("cart-mapper.deleteCartProductAll", member_no);
	}


}
