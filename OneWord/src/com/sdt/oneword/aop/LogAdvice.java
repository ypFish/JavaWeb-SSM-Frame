package com.sdt.oneword.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//切面增强处理
@Aspect
public class LogAdvice {

	 @Before("com.sdt.oneword.aop.LogPointcut.inServiceLayer()" )
     public void logInfo(JoinPoint jp) {
          String className = jp.getThis().toString();
          String methodName = jp.getSignature().getName();   //获得方法名
          System.out.println("LogAdvice类截取："+className+"类的"+methodName+"方法");
    }
    
     /**
     * 在方法结束后纪录
     * @param jp
     */
     @After("com.sdt.oneword.aop.LogPointcut.inServiceLayer()" )
     public void logInfoAfter(JoinPoint jp) {
          System. out.println("=====================================" );
          System. out.println("====" +jp.getSignature().getName()+"方法-结束！");
          System. out.println("=====================================" );
    }
}
