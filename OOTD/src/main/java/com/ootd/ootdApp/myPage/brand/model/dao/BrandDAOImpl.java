package com.ootd.ootdApp.myPage.brand.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ootd.ootdApp.member.model.vo.Member;
import com.ootd.ootdApp.myPage.brand.model.vo.MypageOrderList;
import com.ootd.ootdApp.product.model.vo.Attachment;
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
		
		int resultP = 0;	// 상품 삭제 결과
		int resultA = 0;	// 첨부파일 삭제 결과
		
		resultP = sqlSession.delete("productList-mapper.deleteBrandProductList", productNo);
		
		if( resultP > 0) { 
			resultA = sqlSession.delete("productList-mapper.deleteBrandProductAttachment", productNo);
		}
		
		return resultA;
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
		System.out.println("rank :: DAO 왔나요");
		return sqlSession.selectList("productList-mapper.selectBrandProductRankList", member_no);
	}

	@Override
	public int updateBrandStatus(int orderNo) {
		System.out.println("send :: DAO 왔나요");
		int result1 = sqlSession.update("orderList-mapper.updateBrandStatus", orderNo);
		int result2 = sqlSession.update("orderList-mapper.updateNoBrandStatus", orderNo);
		System.out.println("result1" + result1);
		System.out.println("result2" + result2);

		int result = 0;
		if(result1*result2==1) {
			result = 1;
		}else {
			result = 0;
		}
		return result;
	}

	@Override
	public List<Attachment> selectAttachmentList(int productNo) {

		return sqlSession.selectList("productList-mapper.selectAttachList", productNo);
	}
	


}