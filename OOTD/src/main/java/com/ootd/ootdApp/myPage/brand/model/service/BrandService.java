package com.ootd.ootdApp.myPage.brand.model.service;

import java.util.List;

import com.ootd.ootdApp.myPage.brand.model.vo.MypageOrderList;
import com.ootd.ootdApp.product.model.vo.Product;

public interface BrandService {

	List<MypageOrderList> selectBrandOrderList();

	List<Product> selectBrandProductList();

	int deleteBrandProductList(int productNo);

}