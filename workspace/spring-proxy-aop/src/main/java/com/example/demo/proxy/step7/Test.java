package com.example.demo.proxy.step7;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Test {  // 클라이언트
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
		
//		Hello hello = new Hello();
//		hello.say();
//		
//		System.out.println();
//		
//		Advice advice  = new MyAdvice();
//		
//		//CGLIB 가 지원하는 Dynamic Proxy
//		ProxyFactory factory = new ProxyFactory();
//		factory.setTarget(hello);
//		factory.addAdvice(advice);
//		
//		Hello proxy = (Hello) factory.getProxy();
//		proxy.say();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("proxy-factory-bean-demo.xml");
		
		Hello proxy = (Hello) context.getBean("proxy");
		proxy.say();
	}
}
