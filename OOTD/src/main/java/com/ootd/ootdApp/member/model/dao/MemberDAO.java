package com.ootd.ootdApp.member.model.dao;

import com.ootd.ootdApp.member.model.vo.Member;

public interface MemberDAO {

	Member selectOneMember(String memberId);
	
	int insertMember(Member member);
	
	int insertBrandMember(Member member);
	
	int updateMember(Member member);

	Member selectMemberID(Member member);
}
