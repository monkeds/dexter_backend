package com.monkeds.dexter_backend.dao;

import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.monkeds.dexter_backend.entity.Room;
import com.monkeds.dexter_backend.mappers.RoomMapper;
import com.monkeds.dexter_backend.utilities.MyBatisUtil;

public class RoomDAO {
	
	UserDAO userDAO = new UserDAO();
	
	public List<Room> getByUserId(String userid) throws Exception{
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Room> result = Collections.emptyList();
		try {
			RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
			result = mapper.getByUserId(userid);
			if( result == null ){
				result = Collections.emptyList();
			}else{
				for(int i=0;i<result.size();i++){
					result.get(i).setUser_display(userid);
				}
			}
		}catch(Exception ex){
			throw new Exception(ex); //quitar
		}
		finally {
			sqlSession.close();
		}
		return result;
	}
	
	
	public List<Room> getByUserIdWithFriendDetail(String userid) throws Exception{
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Room> result = Collections.emptyList();
		try {
			RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
			result = mapper.getByUserId(userid);
			if( result == null ){
				result = Collections.emptyList();
			}else{
				for(int i=0;i<result.size();i++){
					result.get(i).setUser_display(userid);
					result.get(i).setUserDisplay( userDAO.getById(result.get(i).getUser_display()));
				}
			}
		}catch(Exception ex){
			throw new Exception(ex); //quitar
		}
		finally {
			sqlSession.close();
		}
		return result;
	}
}
