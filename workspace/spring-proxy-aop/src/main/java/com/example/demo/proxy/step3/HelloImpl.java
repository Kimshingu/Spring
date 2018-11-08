package com.example.demo.proxy.step3;

//Target
public class HelloImpl implements Hello{
	
	public void say() {
		// 항상 처리해야하는 로직만 배치한다. : Primary Concern
		System.out.println("Hello!");
	}
}
