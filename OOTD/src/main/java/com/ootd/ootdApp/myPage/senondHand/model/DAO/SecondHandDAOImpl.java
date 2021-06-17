package com.ootd.ootdApp.myPage.senondHand.model.DAO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ootd.ootdApp.member.model.vo.Member;

@Repository
public class SecondHandDAOImpl implements SecondHandDAO {

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public int updatePassword(Member member) {
		return sqlSession.update("member-mapper.updatePassword", member);
	}

	@Override
	public int updateEmail(Member member) {
		return sqlSession.update("member-mapper.updateEmail", member);
	}

	@Override
	public int updatePhone(Member member) {
		return sqlSession.update("member-mapper.updatePhone", member);
	}

}
