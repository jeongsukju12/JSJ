package com.mycompany.mysite.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	

}
