package com.sdt.oneword.aop;

import org.aspectj.lang.annotation.Pointcut;

public class LogPointcut {

	@Pointcut("execution(* com.sdt.oneword.controller.*.lo*(..))" )
    public void inServiceLayer() {
		
		System.out.println("切点执行~~~");
	}
}
