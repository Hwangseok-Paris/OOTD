package com.ootd.ootdApp.myPage.brand.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ootd.ootdApp.myPage.brand.model.vo.MypageOrderList;
import com.ootd.ootdApp.product.model.vo.Product;

@Repository
public class BrandDAOImpl implements BrandDAO {

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<MypageOrderList> selectBrandOrderList() {
		System.out.println("order :: DAO 왔나요");
		List<MypageOrderList> mypage = sqlSession.selectList("orderList-mapper.selectBrandOrderList");
		System.out.println("test" + mypage);
		return mypage;

	}

	@Override
	public List<Product> selectBrandProductList() {
		System.out.println("product :: DAO 왔나요");
		return sqlSession.selectList("productList-mapper.selectBrandProductList");
	}

	@Override
	public int deleteBrandProductList(int productNo) {
		System.out.println("product_delete :: DAO 왔나요");
		return sqlSession.delete("productList-mapper.deleteBrandProductList", productNo);
	}
	


}