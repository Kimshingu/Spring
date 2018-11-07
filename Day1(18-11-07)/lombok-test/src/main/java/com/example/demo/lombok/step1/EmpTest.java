package com.example.demo.lombok.step1;

public class EmpTest {
	public static void main(String[] args) {
		Emp emp = new Emp(10,"Sean","SpringProgrammer");
		Emp emp2 = emp;
		System.out.println(emp == emp2);

		Emp emp3 = new Emp(10,"Sean","SpringProgrammer");
		System.out.println(emp == emp3);
		
		System.out.println(emp.equals(emp3));
		
	}
}
