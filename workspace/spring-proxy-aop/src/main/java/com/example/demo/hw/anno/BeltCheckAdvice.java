package com.example.demo.hw.anno;

import java.util.Random;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BeltCheckAdvice {

//	public void myBefore(JoinPoint jointPoint) {
//		
//		if(BeltCheckSensor.check()) {
//			System.out.println("Engine is running...");
//		}
//		else System.out.println("딩동~! 딩동! 안전벨트를 착용하세요!");
//	}
//	@Pointcut("execution(* two(..))")
	
	@Pointcut("execution(* start(..)) && bean(dreamCar)")
	public void pointcut() {}
	
	@Around("pointcut()")
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