package com.sdt.oneword.dao;

import com.sdt.oneword.domain.User;

public interface IUserDao {

    /**
     * 添加新用户
     * @param user
     * @return
     */
    public int insertUser(User user);
    
    /**
     * 通过主键userId查询user
     * @param userId
     * @return User
     */
    public User selectUserById(int userId);
}
