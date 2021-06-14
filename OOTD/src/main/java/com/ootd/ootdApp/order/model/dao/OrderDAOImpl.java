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


}
