package com.example.demo.proxy.step2;

public class Proxy implements Hello{
	private Hello hello;
	
	public Proxy(Hello hello) {
		this.hello = hello;
	}

	public void say() {
		System.out.println("------------------------------"); // 가끔 수행하는 부가로직
		// 로직을 중복으로 갖고 있는 것은 관리적으로 비효율적이므로 여기서 
		// 타켓 객체의 메소드를 호출하는 방식으로 대체한다.
		// System.out.println("Hello!");
		hello.say(); // 위임(Delegation)
		System.out.println("------------------------------"); // 가끔 수행하는 부가로직
	}
}
