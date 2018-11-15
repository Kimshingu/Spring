package com.example.demo.dao;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Emp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpDaoTest {
	@Autowired
	private EmpDao dao;
	
	@Test
	public void testInsert() {
		Emp emp = new Emp();
		emp.setEname("송이요수진입니다");
		emp.setJob("마법사");
		emp.setSal(1234);
		
		System.out.println("전 : " + emp);
		
		int affected = dao.insert(emp);
		System.out.println("affected :" + affected);
		
		System.out.println("후 : " + emp);
		/*
		 * 새 로우를 입력한다.
		 * 디비가 생성한 키 값을 알고 싶다.
		 * 어떻게 해야할 것인가?
		 * 
		 * dao.insert(emp);
		 * 1. 메소드 호출 시 파라미터로 객체를 전달한다.
		 * 2. 마이바티스가 이 객체에 setEmpno(디비가 생성한 키 값) 
		 * 코드를 호출하여 저장한다. <== 명시적인 설정이 필요!
		 * 3. 해당 객체는 이 위치에서 접근 가능한 변수이므로
		 * 직접 객체에서 꺼내어 사용할 수 있다.
		*/
		
		testFindAll();
	}

	@Test
	public void testUpdate() {
		
	}

	@Test
	public void testDelete() {
		
	}

	@Test
	public void testFindAll() {
		dao.findAll().forEach(System.out::println);
	}

	@Test
	public void testCount() {
		System.out.println(dao.count()); 
	}

	@Test
	public void testFindOne() {
		try {
			Emp emp = dao.findOne(1);
			System.out.println(emp);
		} catch (Exception e) {
			throw e;
		}
	}

}
