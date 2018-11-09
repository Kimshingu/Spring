package com.example.demo.aop.xml.step4;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

// Aspect:
// 공통적인 부가로직을 어드바이스라고 하고
// 새로운 에스펙트를 열어서 다수의 어드바이스를 갖고 있는 것을 에스팩트라고 부른다.
@Component
public class MyAspect {

//	@Override
	public void before(
//			Method method, Object[] args, Object target
			JoinPoint joinPoint
			) throws Throwable {
		System.out.println("+++++Before+++++");
	}

//	@Override
	public Object invoke(
//			MethodInvocation invocation 
			ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("-----Around Before Advice-----");
		
		// 타켓 메소드에 전달되는 파라미터를 조작할 수 있다.
		Object[] args = joinPoint.getArgs();
		if(args!= null && args.length>0) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~`");
			Arrays.asList(args).forEach(System.out::println);
			System.out.println("~~~~~~~~~~~~~~~~~~~~~`");
		}
		
//		Object ret = invocation.proceed();
		Object ret = joinPoint.proceed();
		System.out.println("=====Around After Advice======");
		// 타켓 메소드가 리턴한 결과를 조작할 수 있다.
		ret = (Integer)ret + 1000;
		return ret;
	}
	
	// 조건기동: 타겟 메소드가 정상적으로 처리된 후 수행됩니다.
	public void myAfterReturning(JoinPoint jointPoint, Object result) {
	System.out.println("=====MyAspect # myAfterReturning======");
	System.out.println(">>> " + result);
	}
	// 조건기동: 타겟 메소드 처리 시 예외가 발생한 경우 수행됩니다.
	public void myAfterThrowing(JoinPoint jointPoint, Throwable error) {
	System.out.println("=====MyAspect # myAfterThrowing======");
	System.out.println(">>> " + error.getMessage());
	}
	// 항상기동: 타겟 메소드가 수행된 다음 뒤에서 수행됩니다.
	public void myAfter(JoinPoint jointPoint) {
	System.out.println("=====MyAspect # myAfter======");
	}
}
