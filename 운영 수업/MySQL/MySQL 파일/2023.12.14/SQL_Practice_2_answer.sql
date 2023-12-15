USE cloud_digital;

-- 51. 사원들의 이름, 직무를 첫 자만 대문자로 검색하라
select upper(substr(ename,1,1)), upper(substr(job,1,1)) from emp;
-- 전체 문자 표시는 50번 참고
-- 52. 사원들의 이름, 직무를 연결하여 검색하라
select concat(ename, job) from emp;
-- 53. 사원들의 이름과 이름의 첫 2자를 검색하라
select ename, substr(ename,1,2) from emp;
-- 54. 사원들의 이름, 직무 그리고 직무의 2번째부터 3자리를 검색하라
select ename, job, substr(job,2,3) from emp;
-- 55. 사원들의 이름과 이름의 길이를 검색하라
select ename, length(ename) from emp;
-- 56. 사원들의 직무와 직무의 자리수를 검색하라
select job, length(job) from emp;
-- 57. 사원들의 이름에 'A'가 몇 번째 있는지 검색하라
select instr(ename, 'A') from emp;
-- 58. 사원들의 직무에 'A'가 몇 번째 있는지 검색하라
select instr(job, 'A') from emp;
-- 59. 사원의 이름을 15자리로 하고, 뒤에 '&'를 채워 검색하라
select rpad(ename, 15, '&') from emp;
-- 60. 사원의 직무를 20자리로 하고, 앞에 '%'를 채워 검색하라
select lpad(ename, 20, '%') from emp;
-- 61. 사원의 사원번호, 이름, 급여를 검색하라(급여는 두번째 자리에서 반올림함)
select empno, ename, round(sal, -2) from emp;
-- 62. 사원의 사원번호, 이름, 급여를 검색하라(급여는 두번째 자리까지만 표시함)
select empno, ename, truncate(sal, -2) from emp;
-- 63. 사원번호와 급여를 100으로 나눈 나머지를 검색하라
select empno, mod(sal, 100) from emp;
-- 64. 사원번호, 이름과 입사일자, 입사일자 100일 후의 일자를 구하라
select empno, ename, hiredate, date_add(hiredate, interval 100 day) from emp;
-- 65. 사원번호, 이름, 입사일자 그리고 근무 일자를 계산하여 구하라
select empno, ename, hiredate, timestampdiff(day, hiredate, now()) from emp;
-- 66. 사원들의 입사일자에 3달째 되는 일자를 구하라
select date_add(hiredate, interval 3 month) from emp;
-- 67. 사원들의 입사일자 다음 토요일의 일자를 구하라
select hiredate,dayname(hiredate), dayofweek(hiredate), weekday(hiredate), date_format(hiredate,"%w"),
	hiredate+ interval (8-dayofweek(date_add(hiredate, interval 1 day))) day as 다음토요일,
    hiredate+ interval (7-weekday(date_add(hiredate, interval 2 day))) day as 다음토요일2,
	hiredate+ interval (7-date_format(date_add(hiredate, interval 1 day),"%w")) day as 다음토요일3,
    (date_add(hiredate, interval (15-dayofweek(date_add(hiredate, interval 1 day))) day)) as 다다음토요일
    from emp;
    -- 구하고 싶은 요일에 따라서 interval x day 부분을 고치면 됨
-- 68. 사원들의 입사월의 마지막 날짜를 구하라
select date_sub(date_add(hiredate, interval 1 month), interval day(hiredate) day) from emp;
select last_day(hiredate) from emp;
-- 69. 사원들의 입사일자를 년을 기준으로 반올림하여 구하라
select round(year(hiredate), -1) from emp;
-- 70. 사원들의 입사일자를 년을 기준으로 절사하여 구하라
select truncate(year(hiredate), -1) from emp;
-- 71. 매니저 없는 사원의 경우 '상급자 없음'을 나타내도록 하는 질의문을 작성하시오
select ifnull(mgr, '상급자없음') from emp;
-- 72. 커미션이 포함한 급여를 사원번호, 이름과 함께 구하라
select empno, ename, sal+ifnull(comm, 0) from emp;
-- 73. 커미션을 포함한 연봉(급여x12)을 사원번호, 이름과 함께 구하라
select empno, ename, sal+(ifnull(comm,0)*12) from emp;
-- 커미션은 12를 곱하지 않은 경우. 곱하고 싶다면 전체를 묶어서 *12
select empno, ename, ((sal+ifnull(comm,0))*12) from emp;
-- 74. 매니저가 NULL인 경우 'CEO'로 바꾸어 사원번호, 이름, 매니저를 구하라
select empno, ename, ifnull(mgr, 'CEO') from emp;
-- 75. 10, 20번 부서 사원들 중 최고 급여를 받는 사원의 사원번호, 이름, 급여를 구하라
select empno, ename, sal from emp where (deptno, sal) 
in(
	(select deptno, max(sal) from emp where deptno in (10, 20) group by deptno)
);
-- 부서번호가 10,20인 부서의 부서번호와 최고급여 
select deptno, max(sal) from emp where deptno in (10, 20) group by deptno;

-- 76. 30번 부서의 사원 중 최저 급여를 받는 사원의 사원번호, 이름, 급여를 구하라
select empno, ename, sal from emp where (deptno, sal) 
in (select deptno, min(sal) from emp where deptno=30 group by deptno);

-- 77. 전체 사원들 중 최고 커미션을 받는 사원의 사원번호, 이름, 커미션을 구하라
select empno, ename, comm from emp where comm=(select max(comm) from emp);
-- 78. 전체 사원들 중 최저 커미션을 받는 사원의 사원번호, 이름, 커미션을 구하라
select empno, ename, comm from emp where comm=(select min(comm) from emp);
-- 79. 전체 사원의 이름 중 최고값과 최저값을 검색하라
select max(ename), min(ename) from emp;
-- 80. 전체 사원의 입사일자 중 최고값과 최저값을 검색하라
select max(hiredate), min(hiredate) from emp;
-- 81. 사원번호의 최고값과 최소값을 검색하라
select max(empno), min(empno) from emp;
-- 82. 매니저 컬럼의 데이터 개수를 검색하라
select count(mgr) from emp;
-- 83. 이름의 개수를 검색하라
select count(distinct ename) from emp;
-- 84. 사원테이블의 튜플 수를 검색하라
select count(*) from emp;
-- 85. 부서 테이블의 튜플 수를 검색하라
select count(*) from dept;
-- 86. 커미션의 개수를 검색하라
select count(comm) from emp;
-- 87. 부서별 사원들의 인원수를 검색하라
select count(empno) from emp group by deptno;
-- 88. 매니저별 사원들의 인원수를 검색하라
select count(empno) from emp group by mgr;
-- 89. 부서별 사원들의 평균 급여를 검색하라
select avg(sal) from emp group by deptno;
-- 90. 부서별 사원들의 급여의 표준편차를 검색하라
select stddev(sal) from emp group by deptno;
-- 91. 부서별 직무별 사원의 급여 합을 검색하라
select deptno, job, sum(sal) from emp group by deptno, job order by deptno;
-- 92. 부서별 직무별 사원들의 평균 급여를 검색하라
select deptno, job, avg(sal) from emp group by deptno, job order by deptno;
-- 93. 부서별 직무별 사원들의 입사일자의 최고값과 최저값을 검색하라
select max(hiredate), min(hiredate) from emp group by deptno, job;
-- 94. 부서별 사원들의 인원수를 인원수가 많은 순으로 검색하라
select count(empno) from emp group by deptno order by count(empno) desc;
-- 95. 부서별 사원들의 평균 급여를 평균 급여 순으로 검색하라
select avg(sal) from emp group by deptno order by avg(sal);
-- 96. 부서별 직무별 사원의 급여 합을 많은 순으로 검색하라
select sum(sal) from emp group by deptno, job order by sum(sal) desc;
-- 97. 부서별 직무별 사원들의 평균 급여를 평균 급여가 많은 순으로 검색하라
select avg(sal) from emp group by deptno, job order by avg(sal) desc;
-- 98. 사원번호, 이름, 부서명을 검색하라
select empno, ename, dname from emp, dept where emp.deptno=dept.deptno;
-- 99. 부서지역이 NEW YORK인 사원의 이름을 검색하라
select ename from emp where deptno=(select deptno from dept where loc='NEW YORK');
-- 100. ADAMS 사원이 근무 중인 부서명과 지역을 검색하라
select dname, loc from dept where deptno=(select deptno from emp where ename='ADAMS');
-- 101. 급여가 2000 이상인 사원들의 사원명과 지역을 검색하라
select ename, loc from emp, dept where emp.deptno=dept.deptno and sal >= 2000;
-- 102. 직무가 SALESMAN이면서 CHICAGO에 근무 중인 사원명을 검색하라
select ename from emp, dept where emp.deptno=dept.deptno and job='SALESMAN' and loc='CHICAGO';

-- 103. NEW YORK과 DALLAS에 근무하는 사원들의 사번과 이름을 사원번호순으로 검색하라
select empno, ename from emp 
where deptno in (select deptno from dept where loc in ('NEW YORK', 'DALLAS'));

-- 104. 부서명이 ACCOUNTING 이거나, 지역이 CHICAGO인 사원의 사원번호와 이름을 검색하라
select empno, ename from emp 
where deptno in (select distinct deptno from dept where dname='ACCOUNTING' or loc='CHICAGO');
-- 105. 사원번호, 이름, 급여, 급여등급을 검색하라
select empno, ename, sal, grade from emp, dept, salgrade 
where emp.deptno=dept.deptno and sal between losal and hisal;

-- 106. 각 사원의 사원번호와 이름, 매니저 사원번호와 이름을 검색하라
select a.empno, a.ename, b.empno, b.ename from emp a, emp b where a.mgr = b.empno;
select a.empno `사원번호`, a.ename `사원이름`, b.empno `매니저 사원번호`, b.ename ` 매니저 이름` from emp a LEFT JOIN emp b 
ON a.mgr = b.empno;

-- 107. BLAKE 사원보다 많은 급여를 받는 사원의 이름을 검색하라
select ename from emp where sal > (select sal from emp where ename='BLAKE');
-- 108. FORD 사원과 같은 부서에 근무하는 사원의 이름을 검색하라
select ename from emp where deptno=(select deptno from emp where ename='FORD') and ename != 'FORD';
-- 109. FORD 사원과 같은 급여를 받는 사원의 사원번호를 검색하라
select empno from emp where sal = (select sal from emp where ename='FORD') and ename != 'FORD';
-- 110. 부서별 인원수를 부서명과 함께 검색하라
select dname, count(empno) from emp, dept where emp.deptno=dept.deptno group by emp.deptno;
-- 111. 부서명이 'SALES'이면서 직무가 'MANAGER'인 사원의 사원번호, 이름을 이름순으로 검색하라
select empno, ename from emp, dept where emp.deptno=dept.deptno and dname='SALES' and job='MANAGER' order by ename;
-- 112. SCOTT 사원보다 많은 급여를 받는 사원 정보를 검색하라
select * from emp where sal > (select sal from emp where ename = 'SCOTT');
-- 113. ALLEN 사원보다 적은 급여를 받는 사원 정보를 검색하라
select * from emp where sal < (select sal from emp where ename = 'ALLEN');
-- 114. 20번 부서 사원의 직무와 같은 직무를 하고 있는 다른 부서의 사원 정보를 검색하라
select * from emp where deptno != 20 and job in (select job from emp where deptno = 20);
-- 115. 전체 사원의 평균 급여보다 급여가 많은 사원 정보를 검색하라
select * from emp where sal > (select avg(sal) from emp);
-- 116. 급여가 모든 부서들의 평균 급여보다 많은 사원 정보를 검색하라
select * from emp where sal > all(select avg(sal) AS average from emp group by deptno) ;

select avg(sal) from emp; -- 평균급여
select (select avg(sal) from emp) AS total, avg(sal) from emp group by deptno; -- 전체급여 평균, 부서별 평균
select avg(sal) from emp group by deptno with rollup;  -- 부서별 평균과 전체 평균


-- 117. 20번 부서의 최대 급여보다 최대 급여가 큰 부서의 번호와, 최대 급여를 검색하라
select deptno, max(sal) from emp where sal > (select max(sal) from emp where deptno=20) group by deptno;
-- 118. CHICAGO에 위치하는 부서에 근무하는 사원 정보를 검색하라(서브쿼리 이용)
select * from emp where deptno = (select deptno from dept where loc='CHICAGO');

-- 119 emp 테이블의 사원 들중 이름을 알파벳 순으로 정렬하여 검색된 첫번째 행부터 5개 만큼 행정보를 읽으시오.
SELECT * FROM emp ORDER BY ename; 
SELECT emp.* FROM emp ORDER BY ename limit 0, 5;

-- 행번호 추가
(SELECT @ROWNUM := @ROWNUM + 1 AS ROWNUM, emp.* FROM emp, (SELECT @ROWNUM := 0) R) ORDER BY ROWNUM DESC limit 0 , 5;

