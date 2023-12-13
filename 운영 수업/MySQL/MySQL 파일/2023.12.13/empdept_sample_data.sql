CREATE DATABASE IF NOT EXISTS develop_sql;

USE develop_sql;

DROP TABLE IF EXISTS dept;

CREATE TABLE IF NOT EXISTS dept(
	deptno int(2) primary key,		-- 부서 코드
	dname varchar(20) not null,		-- 부서 이름
	loc varchar(20)					-- 부서 지역
);				

DROP TABLE IF EXISTS emp;

CREATE TABLE IF NOT EXISTS emp(
	empno int(4) primary key,		-- 사원번호
	ename varchar(10) not null,		-- 사원명
	job varchar(20) not null,		-- 직무
	mgr int(4),						-- 자신의 매니저
	hiredate date,					-- 입사일
	sal int(8),						-- 급여
	comm int(8),					-- 커미션(추가수당)
	deptno int(2),					-- 근무 부서번호
FOREIGN KEY fk_dept(deptno) REFERENCES dept(deptno));

DROP TABLE IF EXISTS salgrade;

-- 최소 급여와 최대 급여 사이에 존재하는 급여를 받고 있으면 해당 등급
CREATE TABLE IF NOT EXISTS salgrade (
	grade INT(1), 	-- 등급
	losal INT(7),	-- 최소급여 
	hisal INT(7) 	-- 최대급여
); 

insert into dept values(10, 'ACCOUNTING', 'NEW YORK');
insert into dept values(20, 'RESEARCH', 'DALLAS');
insert into dept values(30, 'SALES', 'CHICAGO');
insert into dept values(40, 'OPERATING', 'BOSTON');

insert into emp values(7369, 'SMITH', 'CLERK', 7902, '1980/12/17', 800, null, 20);
insert into emp values(7499, 'ALLEN', 'SALESMAN', 7698, '1981/02/20', 1600, 300, 30);
insert into emp values(7521, 'WARD', 'SALESMAN', 7698, '1981/02/22', 1250, 500, 30);
insert into emp values(7566, 'JONES', 'MANAGER', 7839, '1981/04/02', 2975, null, 20);
insert into emp values(7654, 'MARTIN', 'SALESMAN', 7698, '1981/09/28', 1250, 1400, 30);
insert into emp values(7698, 'BLAKE', 'MANAGER', 7839, '1981/05/01', 2850, null, 30);
insert into emp values(7788, 'SCOTT', 'ANALYST', 7566, '1987/04/19', 3000, null, 20);
insert into emp values(7839, 'KING', 'PRESIDENT', null, '1981/11/17', 5000, null, 10);
insert into emp values(7844, 'TURNER', 'SALESMAN', 7698, '1981/09/08', 1500, 0, 30);
insert into emp values(7876, 'ADAMS', 'CLERK', 7788, '1987/05/23', 1100, null, 20);
insert into emp values(7900, 'JAMES', 'CLERK', 7698, '1981/12/03', 950, null, 30);
insert into emp values(7902, 'FORD', 'ANALYST', 7566, '1981/12/03', 3000, null, 20);
insert into emp values(7934, 'MILLER', 'CLERK', 7782, '1982/01/23', 1300, null, 10);
insert into emp values(7782, 'CLARK', 'MANAGER', 7839, '1981/06/09', 2450, null, 10);

INSERT INTO salgrade VALUES(1,1201,1400),(2,1401,2000),(3,2001,3000),(4,3001,9999);

commit;
