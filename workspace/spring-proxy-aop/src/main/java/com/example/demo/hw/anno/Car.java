package com.example.demo.hw.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	@Autowired
	private Engine engine;
	
	public void start() {
		engine.run();
	}
	public void stop() {
		engine.stop();
	}
}
