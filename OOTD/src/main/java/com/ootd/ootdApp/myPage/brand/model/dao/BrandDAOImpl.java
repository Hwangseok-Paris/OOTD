package com.ootd.ootdApp.myPage.brand.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ootd.ootdApp.member.model.vo.Member;
import com.ootd.ootdApp.myPage.brand.model.vo.MypageOrderList;
import com.ootd.ootdApp.product.model.vo.Product;

@Repository
public class BrandDAOImpl implements BrandDAO {

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<MypageOrderList> selectBrandOrderList(String brand_name) {
		System.out.println("order :: DAO 왔나요");
		List<MypageOrderList> mypage = sqlSession.selectList("orderList-mapper.selectBrandOrderList", brand_name);
		System.out.println("test" + mypage);
		return mypage;

	}

	@Override
	public List<Product> selectBrandProductList(int member_no) {
		System.out.println("product :: DAO 왔나요");
		return sqlSession.selectList("productList-mapper.selectBrandProductList", member_no);
	}

	@Override
	public int deleteBrandProductList(int productNo) {
		System.out.println("product_delete :: DAO 왔나요");
		return sqlSession.delete("productList-mapper.deleteBrandProductList", productNo);
	}

	@Override
	public List<MypageOrderList> selectBrandOrderDetail(int orderNo) {
		System.out.println("order_detail :: DAO 왔나요");
		return sqlSession.selectList("orderList-mapper.selectBrandOrderDetail", orderNo);
	}

	@Override
	public int updateBrandInfo(Member tempMember) {
		System.out.println("brandMypage_UpdatePw :: DAO 왔나요");
		return sqlSession.update("member-mapper.updateBrandPwd", tempMember);
	}
	
	@Override
	public int emUpdateBrandInfo(Member tempMember) {
		System.out.println("brandMypage_UpdateEmail :: DAO 왔나요");
		return sqlSession.update("member-mapper.updateBrandEmail", tempMember);
	}

	@Override
	public int phUpdateBrandInfo(Member tempMember) {
		System.out.println("brandMypage_UpdatePhone :: DAO 왔나요");
		return sqlSession.update("member-mapper.updateBrandPhone", tempMember);
	}

	@Override
	public int acUpdateBrandInfo(Member tempMember) {
		System.out.println("brandMypage_UpdateAccount :: DAO 왔나요");
		return sqlSession.update("member-mapper.updateBrandAccount", tempMember);
	}

	@Override
	public List<Product> selectBrandProductRankList(int member_no) {
		System.out.println("product :: DAO 왔나요");
		return sqlSession.selectList("productList-mapper.selectBrandProductRankList", member_no);
	}

	@Override
	public int updateBrandStatus(int orderNo) {
		System.out.println("send :: DAO 왔나요");
		return sqlSession.update("orderList-mapper.updateBrandStatus", orderNo);
	}
	


}