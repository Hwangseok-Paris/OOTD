package com.ootd.ootdApp.myPage.brand.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ootd.ootdApp.myPage.brand.model.dao.BrandDAO;
import com.ootd.ootdApp.myPage.brand.model.vo.MypageOrderList;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	BrandDAO brandDAO;

	@Override
	public List<MypageOrderList> selectBrandOrderList() {
		System.out.println("서비스 왔나요");
		return brandDAO.selectBrandOrderList();
	}


}