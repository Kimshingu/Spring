package com.example.demo.hw;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

@Component
public class BeltCheckAdvice {

//	public void myBefore(JoinPoint jointPoint) {
//		
//		if(BeltCheckSensor.check()) {
//			System.out.println("Engine is running...");
//		}
//		else System.out.println("딩동~! 딩동! 안전벨트를 착용하세요!");
//	}
	
	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
		if(BeltCheckSensor.check()) {
			joinPoint.proceed();
		} else {
			System.out.println("딩동~! 딩동! 안전벨트를 착용하세요!");
		}
		return null;
	}
//	public void myAfterThrowing(JoinPoint jointPoint, Throwable error) {
//		System.out.println( error.getMessage());
//		}
}
class BeltCheckSensor {
	static Random rnd = new Random();

	public static boolean check() {
		if (rnd.nextInt(2) == 0) {
			return true;
		}
		return false;
	}
}