package com.ootd.ootdApp.myPage.brand.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ootd.ootdApp.member.model.vo.Member;
import com.ootd.ootdApp.myPage.brand.model.dao.BrandDAO;
import com.ootd.ootdApp.myPage.brand.model.vo.MypageOrderList;
import com.ootd.ootdApp.product.model.vo.Product;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	BrandDAO brandDAO;

	@Override
	public List<MypageOrderList> selectBrandOrderList(String brand_name) {
		System.out.println("order :: 서비스 왔나요");
		return brandDAO.selectBrandOrderList(brand_name);
	}

	@Override
	public List<Product> selectBrandProductList(int member_no) {
		System.out.println("product :: 서비스 왔나요");
		return brandDAO.selectBrandProductList(member_no);
	}

	@Override
	public int deleteBrandProductList(int productNo) {
		System.out.println("product_delete :: 서비스 왔나요");
		return brandDAO.deleteBrandProductList(productNo);
	}

	@Override
	public List<MypageOrderList> selectBrandOrderDetail(int orderNo) {
		System.out.println("order_detail :: 서비스 왔나요");
		return brandDAO.selectBrandOrderDetail(orderNo);
	}

	@Override
	public int updateBrandInfo(Member tempMember) {
		System.out.println("brandMypage_UpdatePw :: 서비스 왔나요");
		return brandDAO.updateBrandInfo(tempMember);
	}

	@Override
	public int emUpdateBrandInfo(Member tempMember) {
		System.out.println("brandMypage_UpdateEmail :: 서비스 왔나요");
		return brandDAO.emUpdateBrandInfo(tempMember);
	}

	@Override
	public int phUpdateBrandInfo(Member tempMember) {
		System.out.println("brandMypage_UpdatePhone :: 서비스 왔나요");
		return brandDAO.phUpdateBrandInfo(tempMember);
	}

	@Override
	public int acUpdateBrandInfo(Member tempMember) {
		System.out.println("brandMypage_UpdateAccount :: 서비스 왔나요");
		return brandDAO.acUpdateBrandInfo(tempMember);
	}

	@Override
	public List<Product> selectBrandProductRankList(int member_no) {
		System.out.println("rank :: 서비스 왔나요");
		return brandDAO.selectBrandProductRankList(member_no);
	}

	@Override
	public int updateBrandStatus(int orderNo) {
		System.out.println("send :: 서비스 왔나요");
		return brandDAO.updateBrandStatus(orderNo);
	}
	
}


