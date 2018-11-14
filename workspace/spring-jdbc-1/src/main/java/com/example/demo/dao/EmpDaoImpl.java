package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Emp;

@Repository
public class EmpDaoImpl implements EmpDao {
	// 디비와 대화하는 객체를 구한다.
	// Template: 일부분의 처리코드가 완성되어 있어서 빠져있는 부분만 추가하면 사용할 수 있는 객체
	// 멀티스레드 환경에서 안전하다. ==> 빈 컨테이너에 등록해서 싱글톤 방식으로 써도 된다.
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
// Row(테이블 행) 정보를 <Emp> 객체에 Mapper(매핑) 하기 위한 로직
// 어느 칼럼의 데이터를 어느 멤버변수에 넣어야 하는지 알려주는 로직
// 	테이블의 로우의 칼럼들을 도메인 클래스 멤버변수들에 어떻게 옮기는가를 정의한 로직
	private RowMapper<Emp> rowMapper = new RowMapper<Emp>() {
		@Override
		public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
			Emp e = new Emp();
			e.setEmpno(rs.getInt("empno"));
			e.setEname(rs.getString("ename"));
			e.setJob(rs.getString("job"));
			e.setSal(rs.getDouble("sal"));
			return e;
		}
	};

	// 빈 컨테이너에 JdbcTemplate이 없을 때 대신 DataSource를 받아서 처리하는 방식
	// @Autowired
	// public void setDataSource(DataSource dataSource) {
	// this.jdbcTemplate = new JdbcTemplate(dataSource);
	// }
	// 메소드마다 반복적으로 사용되는 부분을 밖으로 빼내는 방법을 고려해 보자.
	@Override
	public int insert(Emp emp) {
		String sql = "insert into EMP9(empno, ename, job, sal) values(?, ?, ?, ?)";
		
		// ? : 순서 기반 위치보유자
		// ? 기호는 나중에 update 메소드 내에서 개발자가 추가로 알려준 값으로 치환된다.
		
		// 수정 메소드는 영향 받는 로우의 개수 값을 리턴한다.
		
		int affected = jdbcTemplate.update(sql, 
				emp.getEmpno(), 
				emp.getEname(), 
				emp.getJob(), 
				emp.getSal());
		/*
		* 트랜잭션 테스트
		*/
//		System.out.println("영향받은 로우의 개수 = " + affected);
//		throw new RuntimeException("트랜잭션 테스트 용 언체크드 예외");
		return affected;
	}

	@Override
	public int update(Emp emp) {
		String sql = "update EMP9 set ename=?, job=?, sal=? where empno=?";
		return jdbcTemplate.update(sql, 
				emp.getEname(), 
				emp.getJob(), 
				emp.getSal(), 
				emp.getEmpno());
	}

	@Override
	public int delete(int empno) {
		String sql = "delete EMP9 where empno=?";
		return jdbcTemplate.update(sql, empno);
	}
	
	// 메소드를 선택하는 방법
	// 1. 수정쿼리/조회쿼리 구분
	// 2. 리턴자료형에 맞는 메소드는 무엇인가?
	// 3. 파라미터를 몇 개 주어야 하는가?
	@Override
	public List<Emp> findAll() {
		String sql = "select empno, ename, job, sal from EMP9 order by empno asc";
		// 리턴 값이 여러 개인 경우 query
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public int count() { // Integer.class 자동으로 오토박싱된다. 
		String sql = "select count(*) from EMP9";
		// 리턴 값이 1개인 경우 queryForObject
		// 두번 째 파라미터는 결과의 자료형을 의미한다.
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public Emp findOne(int empno) {
		String sql = "select empno, ename, job, sal from EMP9 where empno=?";
		return jdbcTemplate.queryForObject(sql, rowMapper, empno);
	}
}
