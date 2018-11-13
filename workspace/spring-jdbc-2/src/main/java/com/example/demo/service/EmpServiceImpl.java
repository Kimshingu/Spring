package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmpDao;
import com.example.demo.domain.Emp;


/*
 * Controller ~~ Service ~~ Repository
 * 브라우저와 대화 ~~다수의 테이블과 대화  ~~ 디비와 대화, 일반적으로 테이블과 1:1 관계를 맺고 사용 
 * 
 * Single Responsibility Principle에 따라서
 * Controller, Repository의 역할이 아닌 로직을
 * Service에 배치된다.
*/
@Service
public class EmpServiceImpl implements EmpService{
	// 필요 시 다수의 DAO 객체와 대화합니다.
	
	@Autowired
	private EmpDao empDao;

	   @Override
	   public int insert(Emp emp) {
	      
	      // EmpDao에 한 개의 로우를 insert
	      
	      // XDao에 한 개의 로우를 insert
	      
	      // 재고관리DAO에 변화를 요청하는 update
	      return empDao.insert(emp);
	   }

	   @Override
	   public int update(Emp emp) {
	      // TODO Auto-generated method stub
	      return empDao.update(emp);
	   }

	   @Override
	   public int delete(int empno) {
	      // TODO Auto-generated method stub
	      return empDao.delete(empno);
	   }

	   @Override
	   public List<Emp> findAll() {
	      // TODO Auto-generated method stub
	      return empDao.findAll();
	   }

	   @Override
	   public int count() {
	      // TODO Auto-generated method stub
	      return empDao.count();
	   }

	   @Override
	   public Emp findOne(int empno) {
	      // TODO Auto-generated method stub
	      return empDao.findOne(empno);
	   }

	
}
