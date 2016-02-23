package com.monkeds.dexter.dao;

import org.apache.ibatis.session.SqlSession;

import com.monkeds.dexter.entity.User;
import com.monkeds.dexter.mappers.UserMapper;
import com.monkeds.dexter.utilities.MyBatisUtil;

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
	
	public User getByCredentials(User user) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			return mapper.getByCredentials(user);
		}catch(Exception ex){
			throw new Exception(ex); //poner excepcion personalizada
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
//			ex.printStackTrace();
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
