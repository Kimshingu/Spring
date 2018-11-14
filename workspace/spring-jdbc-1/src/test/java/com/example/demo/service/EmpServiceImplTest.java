package com.example.demo.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Emp;
//개발자테스트 클래스 ~~ SpringJUnit[JUnit]
@RunWith(SpringJUnit4ClassRunner.class)
//테스트를 위한 빈 컨테이너 설정파일을 통보한다.
//file: 파일의 기준 위치는 자바 측이 아니라 웹 루트 밑이다라고 구분해 준다.
@ContextConfiguration(locations = { "file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml" })
public class EmpServiceImplTest {

	@Autowired
	private EmpService empService;
	
	@Test
	public void testInsert() {
		int oldCount = 0;
		try {
			oldCount = empService.count();
		} catch (Exception ignore) {}
		System.out.println("oldCount = " + oldCount);
		
		Emp emp = new Emp();
		emp.setEmpno(3201);
		emp.setEname("홍길동");
		emp.setJob("도둑");
		emp.setSal(999);

		try {
			int affected = empService.insert(emp);
			System.out.println("affected = " + affected);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		int nowCount = 0;
		try {
			nowCount = empService.count();
		} catch (Exception ignore) {}
		System.out.println("nowCount = " + nowCount);
		assertEquals("insert 메소드에서 예외발생, 트랜잭션 어드바이스 적용, " + 
		"롤백이 되어야 하기 때문에 oldCount 값과 nowCount 값은 같아야 한다.", oldCount, nowCount);
	}
	
	@Test
	public void testDelete() {
		try {
			int oldCount = empService.count();
			System.out.println("oldCount = " + oldCount);
		} catch (Exception ignore) {}
		
		Emp emp = new Emp();
		emp.setEmpno(4815);
		emp.setEname("홍길동");
		emp.setJob("도둑");
		emp.setSal(999);

		try {
			int affected = empService.insert(emp);
			System.out.println("insert affected = " + affected);
		} catch (Exception ignore) {}

		try {
			int insertAfterCount = empService.count();
			System.out.println("nowCount = " + insertAfterCount);
		} catch (Exception ignore) {}
		
		try {
			int affected =empService.delete(4815);
			System.out.println("delete affected = " + affected);
		} catch (Exception ignore) {}
		
		try {
			int nowCount = empService.count();
			System.out.println("nowCount = " + nowCount);
		} catch (Exception ignore) {}
		
	}

	@Transactional
	@Test
	public void testUadate() {
		
		Emp emp = new Emp();
		emp.setEmpno(4815);
		emp.setEname("홍길동");
		emp.setJob("도둑");
		emp.setSal(999);

		try {
			int affected = empService.insert(emp);
			System.out.println("insert affected = " + affected);
		} catch (Exception ignore) {}
		
		System.out.println("수정 전:"+emp);
		
		try {
			emp.setEname("송술");
			int affected =empService.update(emp);
			System.out.println("update affected = " + affected);
		} catch (Exception ignore) {}
		
		System.out.println("수정 후:"+emp);
		
		try {
			int affected =empService.delete(4815);
			System.out.println("delete affected = " + affected);
		} catch (Exception ignore) {}
		
	}
}
