package com.sdt.oneword.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	 @Before(value = "execution(public * com.sdt.oneword.controller.*.*(..))" )
     public void beforeShow(JoinPoint jp) {
         String className = jp.getThis().toString();
         String methodName = jp.getSignature().getName(); 
         System.out.println("执行方法：类"+className+"，方法："+methodName);
    }
    
     @After(value = "execution(public * com.sdt.oneword.controller.*.*(..))" )
     public void afterShow() {
          System. out.println("after show." );
    }
}
