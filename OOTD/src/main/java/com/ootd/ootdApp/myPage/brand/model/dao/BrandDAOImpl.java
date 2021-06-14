package com.ootd.ootdApp.myPage.brand.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ootd.ootdApp.myPage.brand.model.vo.MypageOrderList;

@Repository
public class BrandDAOImpl implements BrandDAO {

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<MypageOrderList> selectBrandOrderList() {
		System.out.println("DAO 왔나요");
		return sqlSession.selectList("orderList-mapper.selectBrandOrderList");

	}
	


}