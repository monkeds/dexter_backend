package com.monkeds.dexter_backend.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.monkeds.dexter_backend.entity.User;
import com.monkeds.dexter_backend.mappers.UserMapper;
import com.monkeds.dexter_backend.utilities.MyBatisUtil;

public class UserDAO {
	
	public User getById(String id) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			return mapper.getById(id);
		}catch(Exception ex){
			throw new Exception(ex); //poner excepcion personalizada
		}
		finally {
			sqlSession.close();
		}
	}
	
	public User getByCredentials(String email, String password) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			Map<String, String> credentials = new HashMap<>();
			credentials.put("email", email);
			credentials.put("password",password);
			return mapper.getByCredentials(credentials);
		}catch(Exception ex){
			throw ex;
		}
		finally {
			sqlSession.close();
		}
	}
	
	public void insert(User user) throws Exception{
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			mapper.insert(user);
			sqlSession.commit();
		}catch(Exception ex){
			throw ex; //poner excepcion personalizada
		}
		finally {
			sqlSession.close();
		}
	}
	
	public void update(User user) throws Exception{
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			mapper.update(user);
		}catch(Exception ex){
			throw new Exception(ex); //poner excepcion personalizada
		}
		finally {
			sqlSession.close();
		}
	}
	
}
