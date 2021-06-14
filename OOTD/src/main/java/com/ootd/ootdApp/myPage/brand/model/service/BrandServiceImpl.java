package com.ootd.ootdApp.myPage.brand.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ootd.ootdApp.myPage.brand.model.dao.BrandDAO;
import com.ootd.ootdApp.myPage.brand.model.vo.MypageOrderList;
import com.ootd.ootdApp.product.model.vo.Product;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	BrandDAO brandDAO;

	@Override
	public List<MypageOrderList> selectBrandOrderList() {
		System.out.println("order :: 서비스 왔나요");
		return brandDAO.selectBrandOrderList();
	}

	@Override
	public List<Product> selectBrandProductList() {
		System.out.println("product :: 서비스 왔나요");
		return brandDAO.selectBrandProductList();
	}

	@Override
	public int deleteBrandProductList(int productNo) {
		System.out.println("product_delete :: 서비스 왔나요");
		return brandDAO.deleteBrandProductList(productNo);
	}


}