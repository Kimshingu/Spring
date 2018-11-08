package com.example.demo.qualifier;

import org.springframework.stereotype.Component;

@Component
public class Service3 implements TheService{
	public void Call() {
		System.out.println("Service3 called");
	}
}
