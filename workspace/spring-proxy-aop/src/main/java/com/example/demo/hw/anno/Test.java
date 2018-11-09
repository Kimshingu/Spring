package com.example.demo.hw.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("car-advice-anno.xml");
		
		// 노 체킹 
		Car car = context.getBean("car", Car.class);
		car.start();
		car.stop();
		
		// 체킹
		Car dreamCar = context.getBean("dreamCar", Car.class);
		dreamCar.start();
		dreamCar.start();
		dreamCar.start();
		dreamCar.stop();
	}
}
