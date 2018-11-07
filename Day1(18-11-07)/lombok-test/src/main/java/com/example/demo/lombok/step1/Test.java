package com.example.demo.lombok.step1;

public class Test {
	public static void main(String[] args) {
		User user = new User(1,"Tom","kim@sdf.com"); 
		// 객체를 생성할 때 멤버변수의 초기값을 할당한다.
		
		// 객체 생성 후에- 멤버변수 값을 할당한다.
		System.out.println(user.id);
		System.out.println(user.name);
		System.out.println(user.email);
		
		User user2 = new User(2,"2om"); 
		
		System.out.println(user2.id);
		System.out.println(user2.name);
		System.out.println(user2.email);
	}
}
