package com.example.demo.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.mapper.RegisterMapper;
import com.example.demo.dto.UploadDTO;

@Repository
public class UploadDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	public void uploadGame(UploadDTO UploadDTO) {
		sqlSession.insert("upload.enroll", UploadDTO);
	}
}