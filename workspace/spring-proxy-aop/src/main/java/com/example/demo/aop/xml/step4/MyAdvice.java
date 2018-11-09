package com.example.demo.aop.xml.step4;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

// 타겟 메소드의 전달되는 파라미터를 조작하거나,
// 타켓 메소드 로직 처리 후 리턴하는 리턴 값을 조작하고 싶을 때 주로 어라운드 어드바이스를 사용한다.
@Component
public class MyAdvice implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("-----Around Before Advice-----");
		Object ret = invocation.proceed();
		System.out.println("=====Around After Advice======");
		return ret;
	}
}