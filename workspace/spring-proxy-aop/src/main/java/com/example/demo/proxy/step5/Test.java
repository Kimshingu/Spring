package com.example.demo.proxy.step5;


import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.proxy.step6.Car;

@Component
public  class Test {  // 클라이언트
	@Autowired
	private Hello h;
	
	public void order() {
		// 스프링이
		// 1. Hello 객체를 DI하면 클라이언트는 직접 타겟 메소드를 사용한다.
		// 2. Prox  객체를 DI하면 클라이언트는 프록시 메소드를 사용한다.
		// 프록시 메소드 내에서 대신 타겟 메소드를 호출한다.
		h.say();
	}
	
	public static void main(String[] args) {
		
		Hello hello = new Hello();
		hello.say();
		hello.bye();
		
		System.out.println();
		
		Advice advice  = new MyAdvice();
		
		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(hello);
		factory.addAdvice(advice);
		
		Hello proxy = (Hello) factory.getProxy();
		proxy.say();
		proxy.bye();
		
		System.out.println();
		
		ProxyFactory factory2 = new ProxyFactory();
		factory2.setTarget(new Car());
		// 어드바이스 클래스는 개발자가 작성한 프록시 클래스와 달리
		// 특정 클래스 특정 메소드에 종속되어 있지 않으므로
		// 어드바이스 객체를 재 사용 할 수 있다.
		factory2.addAdvice(advice);
		
		Car proxyCar = (Car) factory2.getProxy();
		proxyCar.start();
		
	}
}
