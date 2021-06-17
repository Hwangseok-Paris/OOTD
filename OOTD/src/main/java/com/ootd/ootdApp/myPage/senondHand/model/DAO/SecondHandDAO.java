package com.ootd.ootdApp.myPage.senondHand.model.DAO;

import com.ootd.ootdApp.member.model.vo.Member;

public interface SecondHandDAO {
	
	int updatePassword(Member member);

	int updateEmail(Member member);

	int updatePhone(Member member);

}
