package com.sdt.oneword.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdt.oneword.dao.IUserDao;
import com.sdt.oneword.domain.User;
import com.sdt.oneword.service.IUserService;

@Service
public class UserService implements IUserService{

	@Autowired
	IUserDao userDao ;
	
	@Override
	public int insertUser(User user) {
		
		int result = userDao.insertUser(user);
		return result;
	}

	@Override
	public User selectUserById(int userId){
		
		return userDao.selectUserById(userId);
		
	}
}
