package com.ootd.ootdApp.myPage.senondHand.model.service;

import com.ootd.ootdApp.member.model.vo.Member;

public interface SecondHandService {
	
	int updatePassword(Member member); //회원 비밀번호 변경

	int updateEamil(Member member); // 회원 이메일 변경

	int updatePhone(Member member); // 회원 전화번호 변경

}
