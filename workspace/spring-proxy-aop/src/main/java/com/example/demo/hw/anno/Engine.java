package com.example.demo.hw.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Engine {
	
	public void run() {
		System.out.println("Engine is running...");
	}
	public void stop() {
		System.out.println("Engine is stopping...");
	}
}
