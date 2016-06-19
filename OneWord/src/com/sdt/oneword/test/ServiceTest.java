package com.sdt.oneword.test;

import org.apache.commons.logging.impl.Log4JLogger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdt.oneword.domain.User;
import com.sdt.oneword.service.impl.UserService;

public class ServiceTest {
	
	private UserService userService;

	@Before
	public void before(){                                                                   
	        @SuppressWarnings("resource")  		
	        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:com/sdt/oneword/test/conf/spring.xml"
                ,"classpath:com/sdt/oneword/test/conf/spring-mybatis.xml"});
	        userService = (UserService)context.getBean("userService");
	}
	     
	@Test
	public void addUser(){
	        User user = new User();
	        
	        user.setUsername("王永涛");
	        user.setPassword("aaaaaa");
	        System.out.println("插入数据："+userService.insertUser(user));
	}
}
