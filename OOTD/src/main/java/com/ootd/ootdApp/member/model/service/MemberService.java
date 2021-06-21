package com.ootd.ootdApp.member.model.service;

import com.ootd.ootdApp.member.model.vo.Member;

public interface MemberService {
	
	Member selectOneMember(String memberId);
	
	int insertMember(Member member);
	
	int insertBrandMember(Member member);
	
	int updateMember(Member member);

	Member selectMemberID(Member member);

	int updateNewPass(Member member);

	int selectKakaoCount(String id);
	
	
}
