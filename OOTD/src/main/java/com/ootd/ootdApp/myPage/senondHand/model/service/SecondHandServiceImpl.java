package com.ootd.ootdApp.myPage.senondHand.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ootd.ootdApp.member.model.vo.Member;
import com.ootd.ootdApp.myPage.senondHand.model.DAO.SecondHandDAO;

@Service
public class SecondHandServiceImpl implements SecondHandService {
	
	@Autowired
	SecondHandDAO secondHandDAO;

	@Override
	public Member selectOneMember(String memberName) {
		return secondHandDAO.selectOneMember(memberName);
	}
	
	

}
