package com.ootd.ootdApp.myPage.senondHand.model.service;

import com.ootd.ootdApp.member.model.vo.Member;

public interface secondHandService {
	
	Member selectOneMember(String userId);
	
	String update_Password(String password, String new_password, String confirm_password);

}
