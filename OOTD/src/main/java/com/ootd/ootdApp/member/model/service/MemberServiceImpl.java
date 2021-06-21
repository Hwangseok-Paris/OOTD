package com.ootd.ootdApp.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ootd.ootdApp.member.model.dao.MemberDAO;
import com.ootd.ootdApp.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberDAO;
	
	@Override
	public Member selectOneMember(String member_id) {
		
		return memberDAO.selectOneMember(member_id);
	}

	@Override
	public int insertMember(Member member) {
		
		return memberDAO.insertMember(member);
	}
	
	@Override
	public int insertBrandMember(Member member) {
		
		return memberDAO.insertBrandMember(member);
	}

	@Override
	public int updateMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Member selectMemberID(Member member) {
		
		return memberDAO.selectMemberID(member);
	}

	@Override
	public int updateNewPass(Member m) {
		
		return memberDAO.updateNewPass(m);
	}

	@Override
	public int selectKakaoCount(String member_id) {
		
		return memberDAO.selectKakaoCount(member_id);
	}

	

	

	

}
