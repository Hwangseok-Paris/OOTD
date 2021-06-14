package com.ootd.ootdApp.myPage.brand.model.dao;

import java.util.List;

import com.ootd.ootdApp.myPage.brand.model.vo.MypageOrderList;


public interface BrandDAO {

	List<MypageOrderList> selectBrandOrderList();

}
