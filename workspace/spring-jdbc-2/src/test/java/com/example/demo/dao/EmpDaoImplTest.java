package com.example.demo.dao;

//CoreMatchers 클래스에 is 메소드는 static 메소드입니다.
//원래 사용방법은 CoreMatchers.is() 방식인데
//클래스를 명시하지 않고 is() 형태로 사용하고 싶어서
//import 구문에 static 설정을 추가합니다.
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.domain.Emp;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmpDaoImplTest {
	@Autowired
	private EmpDao dao;

	@Test
	public void testInsert() {
		int oldCount = dao.count(); // 3

		// 가짜 테스트 데이터 객체, PK인 empno 값은 설정하지 않는다.
		// empno 값은 디비가 자동으로 생성해서 넣을것이다.
		Emp emp = new Emp();
		emp.setEname("Tom");
		emp.setJob("Actor");
		emp.setSal(999);

		System.out.println("empno 0: " + emp); // empno 값은 0인 상태

		int affected = dao.insert(emp);
		System.out.println("affected = " + affected); // 1

		System.out.println("empno 4: " + emp); // empno 값은 디비가 자동으로 제너레이트 값!

		int nowCount = dao.count();

		assertThat("한 행이 추가되었으므로 nowCount는 oldCount 보다 1이 커야 합니다.", nowCount, is(oldCount + 1));

		// 읽기 좋은 코드가 최선의 코드다. == 이해가 쉽게 된다.
		// 최대한 읽기 좋게 작성하고 싶다.
		// (I) assert That nowCount is (oldCount + 1).
	}

	@Test
	public void testUpdate() {
		Emp emp = new Emp();
		emp.setEname("Tom");
		emp.setJob("Actor");
		emp.setSal(999);

		System.out.println("입력 전: " + emp);

		// 수정 대상을 하나 입력한다.
		int affected = dao.insert(emp);
		System.out.println("insert affected = " + affected);

		System.out.println("수정 전: " + emp);

		emp.setJob("None");
		emp.setSal(0);

		// 수정을 테스트한다.
		affected = dao.update(emp);
		System.out.println("update affected = " + affected);

		// 수정된 칼럼 데이터를 확인하기 위해서 조회한다.
		Emp e = dao.findOne(emp.getEmpno());

		System.out.println("수정 후: " + e);

		assertThat(e.getJob(), is(emp.getJob()));
		assertThat(e.getSal(), is(emp.getJob()));

		// 테스트 시 사용한 row를 삭제한다.
		dao.delete(emp.getEmpno());
		System.out.println("delete affected = " + affected);
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		List<Emp> emps = dao.findAll();
		int count = dao.count();
		assertEquals("리스트의 사이즈는 카운트 값과 일치해야 한다.", emps.size(), count);
		System.out.println("count = " + count);
		emps.forEach(System.out::println);
	}

	@Test
	public void testFindAll2() {
		List<Emp> emps = ((EmpDaoImpl) dao).findAll2();
		int count = dao.count();
		assertEquals("리스트의 사이즈는 카운트 값과 일치해야 한다.", emps.size(), count);
		System.out.println("count = " + count);
		emps.forEach(System.out::println);
	}

	@Test
	public void testFindAll3() {
		List<Emp> emps = ((EmpDaoImpl) dao).findAll3();
		int count = dao.count();
		assertEquals("리스트의 사이즈는 카운트 값과 일치해야 한다.", emps.size(), count);
		System.out.println("count = " + count);
		emps.forEach(System.out::println);
	}

	@Test
	public void testCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		Emp emp = new Emp();
		emp.setEname("Tom");
		emp.setJob("Actor");
		emp.setSal(999);
		System.out.println("저장 전: " + emp);
		
		// Insert
		int affected = dao.save(emp);
		System.out.println("Insert affected = " + affected);
		System.out.println("저장 후/수정 전: " + emp);
		emp.setJob("None");
		emp.setSal(0);
		
		// Update
		affected = dao.save(emp);
		System.out.println("Update affected = " + affected);
		
		// Select
		Emp e = dao.findOne(emp.getEmpno());
		System.out.println("수정 후: " + e);
		
		// Delete
		dao.delete(e.getEmpno());
		System.out.println("Delete affected = " + affected);
	}

}
