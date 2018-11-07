package com.example.demo.ioc.step4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		
//		CarMaker maker = new KiaMaker();
//		CarMaker maker = new HyundaiMaker();
		
//		OrderManager manager = new OrderManager();
//		manager.setMaker(maker);
//		manager.order();
		
		/*
		 * 1. XML
		 * 2. Annotation
		 * 3. Java Configuration Class
		 */
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"car-config-anno.xml");

		OrderManager manager = (OrderManager)context.getBean(OrderManager.class);
		System.out.println(manager);
		System.out.println(manager.getMaker());
		manager.order();

	}
}
