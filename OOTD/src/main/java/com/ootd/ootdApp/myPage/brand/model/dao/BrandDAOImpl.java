package com.ootd.ootdApp.myPage.brand.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ootd.ootdApp.myPage.brand.model.vo.OrderList;

@Repository
public class BrandDAOImpl implements BrandDAO {

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<OrderList> slectBoardOrderList() {
		
		return sqlSession.selectList("orderList-mapper.selectBrandOrderList");
	}
	


}