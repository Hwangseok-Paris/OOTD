package com.ootd.ootdApp.myPage.senondHand.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ootd.ootdApp.member.model.vo.Member;
import com.ootd.ootdApp.myPage.senondHand.model.DAO.SecondHandDAO;
import com.ootd.ootdApp.myPage.senondHand.model.vo.Product;
import com.ootd.ootdApp.myPage.senondHand.model.vo.myPageOrderList;

@Service
public class SecondHandServiceImpl implements SecondHandService {
	
	@Autowired
	SecondHandDAO secondHandDAO;

	@Override
	public int updatePassword(Member member) {
		return secondHandDAO.updatePassword(member);
	}

	@Override
	public int updateEamil(Member member) {
		return secondHandDAO.updateEmail(member);
	}

	@Override
	public int updatePhone(Member member) {
		return secondHandDAO.updatePhone(member);
	}

	@Override
	public int updateBank(Member member) {
		return secondHandDAO.updateBank(member);
	}

	@Override
	public int updateAddress(Member member) {
		return secondHandDAO.updateAddress(member);
	}

	@Override
	public List<myPageOrderList> selectOrderList(String member_name) {
		return secondHandDAO.selectOrderList(member_name);
	}

	@Override
	public List<Product> selectProductList(int member_no) {
		return secondHandDAO.selectProductList(member_no);
	}
	

}
