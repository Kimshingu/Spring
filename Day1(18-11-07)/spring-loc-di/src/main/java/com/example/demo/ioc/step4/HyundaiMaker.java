package com.example.demo.ioc.step4;

import org.springframework.stereotype.Component;

// <bean id="HyundaiMaker" class="com.example.demo.ioc.step4.HyundaiMaker"></bean>
@Component("hyundaiMaker")
public class HyundaiMaker implements CarMaker{
	
	public Car sell(Money money) {
		
		System.out.println("HyundaiMaker # " + money.getAmount() + "원을 차 값으로 받는다.");
		Car car = new Car("Sonata");
		
		System.out.println("HyundaiMaker # " + car.getName() + "를 만들어서 판다.");
		return car;
		}
}
