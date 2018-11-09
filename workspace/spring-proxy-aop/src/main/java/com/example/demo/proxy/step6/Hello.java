package com.example.demo.proxy.step6;

// 인터페이스를 구현하고 있지 않는 Target 클래스
public class Hello {
	public void say() {
		// 항상 처리해야하는 로직만 배치한다. : Primary Concern
		System.out.println("Hello!");
	}
}
