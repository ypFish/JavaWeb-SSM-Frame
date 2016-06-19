package com.sdt.oneword.service;

import com.sdt.oneword.domain.User;

public interface IUserService {

	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public int insertUser(User user);
	
	/**
	 * 查询用户信息
	 * @param userId
	 * @return
	 */
	public User selectUserById(int userId);
}
