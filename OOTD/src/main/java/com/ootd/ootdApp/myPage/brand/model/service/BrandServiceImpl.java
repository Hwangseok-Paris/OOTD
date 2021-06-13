package com.ootd.ootdApp.myPage.brand.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ootd.ootdApp.myPage.brand.model.dao.BrandDAO;
import com.ootd.ootdApp.myPage.brand.model.vo.OrderList;

public class BrandServiceImpl implements BrandService {

	@Autowired
	BrandDAO brandDAO;

	@Override
	public List<OrderList> selectBrandOrderList() {
		// TODO Auto-generated method stub
		return null;
	}


}