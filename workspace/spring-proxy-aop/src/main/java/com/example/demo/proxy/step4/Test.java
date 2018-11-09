package com.example.demo.proxy.step4;

import java.lang.reflect.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Test { // Client
	public static void main(String[] args) {
		
		Hello hello = new HelloImpl(); // Service
		hello.say();
		
		Hi hi = new HiImpl();
		hi.ho();
		System.out.println();
		
//		Hello proxy = new Proxy(hello);
//		proxy.say();
		
		// 클래스 설계도 없이 동적으로 프록시 객체를 만들었다.
		// JDK Dynamic Proxy라고 부른다.
		// 스프링은 타겟 객체가 인터페이스를 구현하고 있다면
		// JDK Dynamic Proxy 기술을 사용하여 프록시 객체를 만든다.
		
		Hello proxy =  (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(),
										new Class[] {Hello.class},
										new MyAdvice(hello));
		proxy.say();
		System.out.println();
		Hi proxy2 =  (Hi) Proxy.newProxyInstance(Hi.class.getClassLoader(),
				new Class[] {Hi.class},
				new MyAdvice(hi));
		proxy2.ho();
	}
}
