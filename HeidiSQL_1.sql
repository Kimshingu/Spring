# 시카고에 근무하는 직원정보를 구한다.
select * from dept where dept.loc='CHICAGO';
select * from emp where emp.deptno = 30;

select * from emp where emp.deptno = (select deptno from dept where dept.loc='CHICAGO');

# 테이블 테이터의 상태는 시시각각 변한다.
# 데이터의 상태에 따라 쿼리의 퍼포먼스도 변한다.
# 따라서, 여러 방식의 쿼리를 수행하여 최적의 퀴리를 사용해야 한다.