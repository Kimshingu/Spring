package com.example.demo.aop.xml.step3;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

// Aspect:
// 공통적인 부가로직을 어드바이스라고 하고
// 새로운 에스펙트를 열어서 다수의 어드바이스를 갖고 있는 것을 에스팩트라고 부른다.
@Component
public class MyAspect implements MethodInterceptor, MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("+++++Before+++++");
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("-----Around Before Advice-----");
		Object ret = invocation.proceed();
		System.out.println("=====Around After Advice======");
		return null;
	}

}
