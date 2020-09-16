package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.mapper.RegisterMapper;
import com.example.demo.dto.RegisterDTO;

@Repository
public class RegisterDAO implements RegisterMapper{
	
	@Autowired
	private SqlSession sqlSession;
	
	public void joinUser(RegisterDTO resDTO) {
		sqlSession.insert("register.joinUser", resDTO);
	}
	
	public int checkID(String id) {			
		int result = sqlSession.selectOne("register.checkID", id);
		return result;
	}
	
	public RegisterDTO findByID(String id) {
		return sqlSession.selectOne("register.findByID", id);
	}
	
	@Override
	public RegisterDTO validateMember(HashMap<String, String> map) {
		return sqlSession.selectOne("register.validateMember", map);
	}
	
	public List<RegisterDTO> memberList(){
		return sqlSession.selectList("register.memberList");
	}
	
	public void myPage(RegisterDTO resDTO){
		sqlSession.update("register.myPage", resDTO);
	}
}