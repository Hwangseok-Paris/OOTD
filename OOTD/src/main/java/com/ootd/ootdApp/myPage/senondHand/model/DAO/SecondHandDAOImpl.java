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
	public Member selectOneMember(String memberName) {
		return sqlSession.selectOne("member-mapper.selectOne", memberName);
	}

}
