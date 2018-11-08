package com.example.demo.review.anno;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class Programmer implements Employee {

	@Override
	public void work() {
		System.out.println("프로그램 코드를 작성한다.");
	}

}
