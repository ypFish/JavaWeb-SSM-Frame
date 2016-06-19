package com.sdt.oneword.thread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener{

	MyThread myThread = null;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
		
		System.out.println("监听线程结束！");
		if(myThread!=null){
			myThread.setRunningFlag(false);
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		
		if(myThread == null){
			myThread = new MyThread();
			myThread.setRunningFlag(true);
		}
		(new Thread(myThread)).start();
	}

}
