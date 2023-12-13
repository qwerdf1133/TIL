use develop_sql;

-- 사원 테이블 확인
select * from emp;
-- 부서 테이블을 확인
select * from dept;
-- 급여 등급 테이블을 확인
select * from salgrade;


-- 1. 실습에 사용될 EMP 테이블의 구조를 검색하라
desc dept;

-- 2. 부서의 부서코드와 부서명을 검색하라
select deptno,dname from dept;

-- 3. 부서의 부서명과 지역을 검색하라
select dname, loc from dept;

-- 4. 사원들의 급여와 커미션을 검색하라
select sal, comm from emp;

-- 5. 사원들의 입사일자를 중복을 제거하고 검색하라
SELECT DISTINCT hiredate from emp;

-- 6. 사원들의 매니저를 중복을 제거하고 검색하라
select distinct mgr from emp;

-- 7. 사원들의 입사일자를 중복을 제거하고 검색하라
select hiredate from emp group by hiredate; -- group by도 중복 제거 가능

-- 8. 사원들의 부서번호를 중복을 제거하고 검색하라
select distinct deptno from emp;

-- 9. 사원들의 6개월 급여의 합을 구하라 - 전체 사원의 6개월치 급여의 총합
select sum(sal * 6)  from emp;

-- 10. 사원의 이름을 'Name'으로, 사원의 급여를 'Salary'로 열의 이름을 부여하여 검색하라
select ename as Name, sal as Salary from emp;

-- 11. 사원의 사원번호, 이름, 부서번호, 입사일자를 제목을 한글로 변경하여 검색하라
select empno as 사원번호, ename as 이름, deptno as 부서번호, hiredate as 입사일자 from emp;

-- 12. 부서테이블에서 부서번호, 부서명, 지역을 한글 제목으로 검색하라
select deptno as 부서번호, dname as 부서명, loc as 지역 from dept;

-- 13. 10번 부서에 근무하는 사원들의 이름을 검색하라
select ename from emp where deptno = 10;

-- 14. 급여가 2000이상인 사원들의 사원번호, 이름을 검색하라
select ename, empno from emp where sal >= 2000;

-- 15. 직무가 'CLERK'인 사원들의 사원번호, 이름을 검색하라
select ename, empno from emp where job = 'CLERK';

-- 16. 1980년 12월 17일에 입사한 사원들의 이름을 검색하라
select ename from emp where hiredate = 19801217;

-- 17. 부서번호 30이외의 부서명과 지역을 검색하라
select dname, loc from dept where deptno != 30;

-- 18. 급여등급 테이블에서 급여등급이 3인 급여의 최대급여와 최소급여를 검색하라
select hisal, losal from salgrade where grade = 3;

-- 19. 'WARD' 사원의 모든 정보를 검색하라
select * from emp where ename = 'WARD';

-- 20. 10번 부서에 근무하는 MANAGER의 이름을 검색하라
select ename from emp where job = 'MANAGER' and deptno = 10;

-- 21. 급여가 2000이상이며, 30번 부서에 근무하는 사원들의 사원번호, 이름을 검색하라
select ename, empno from emp where sal >= 2000 and deptno = 30;

-- 22. 직무가 'CLERK'이며, 81년 이후에 입사한 사원들의 사원번호, 이름을 검색하라
select empno, ename from emp where job = 'CLERK' and hiredate >= 19820101;

-- 23. 20부서 외에 근무하는 MANAGER의 이름을 검색하라
select ename from emp where deptno != 20 and job = 'MANAGER';

-- 24. BOSTON이외 지역에 있는 부서의 부서명을 검색하라
select dname from dept where loc != 'BOSTON';

-- 25. job이 'ANALYST'이며 급여가 2000 이하인 사원의 이름을 검색하라
select ename from emp where job = 'ANALYST' and sal <= 2000;

-- 26. 급여가 1000 이상이며, 2500 이하인 사원의 사원번호와 이름을 검색하라
select empno,ename from emp where sal >= 1000 and sal <= 2500;
--          							between 1000 and 2500;

-- 27. 사원번호 75XX인 사원의 사원번호와 이름, 부서번호를 검색하라
select empno,ename,deptno from emp where empno like '75%';

-- 28. 부서번호 10 또는 30에 근무하는 사원들의 이름과 급여를 검색하라
select ename,sal from emp where deptno = 10 or deptno = 30;
--											IN(10, 30);

-- 29. 매니저가 번호가 76xx으로 시작하는 사원들의 이름을 검색하라
select ename from emp where mgr like '76%';

-- 30. 이름 중간에 'A'가 들어있는 사원의 사원번호, 이름을 검색하라
select empno,ename from emp where ename like '%A%'; 

-- 31. 매니저가 NULL이 아닌 사원의 사원번호, 이름, 매니저를 검색하라
select empno,ename,mgr from emp where mgr IS NOT NULL;

-- 32. 매니저 번호가 7698 또는 7839인 사원의 사원번호, 이름을 검색하라
select empno,ename from emp where mgr = 7698 or mgr = 7839;
-- 									  IN (7698,7839);

-- 33. 직무가 'MANAGER' 또는 'SALESMAN'인 사원의 사원번호, 이름, 부서번호를 검색하라
select ename,empno,deptno from emp where job = 'MANAGER' or job = 'SALESMAN';
--											IN ('MANAGER', 'SALESMAN');

-- 34. 사원들의 사원번호, 이름을 사원번호순으로 검색하라
select empno,ename from emp order by empno;

-- 35. 사원들의 사원번호, 이름을 부서번호, 이름순으로 검색하라
select empno,ename from emp order by ename , deptno;

-- 36. 사원들의 정보를 부서별 급여가 많은 순으로 검색하라
select * from emp order by deptno, sal DESC;

-- 37. 사원들의 정보를 부서별, 직무별, 급여 순으로 검색하라
select * from emp order by deptno, job, sal;

-- 38. 사원테이블의 전체 행 수를 검색하라
select count(*) from emp;

-- 39. 사원테이블의 급여 평균을 구하라.
select avg(sal) from emp;

-- 40. 전체 사원들 중 최고 커미션을 받는 사원의 사원번호, 이름, 커미션을 구하라
select empno, ename, comm from emp 
where comm = (select max(comm) from emp);

-- 41. 전체 사원들 중 최저 커미션을 받는 사원의 사원번호, 이름, 커미션을 구하라
select empno, ename, comm from emp 
where comm = (select min(comm) from emp);

-- 42. 부서별 사원들의 평균 급여를 검색하라
select deptno, avg(sal) from emp group by deptno;

-- 43. 부서별 사원의 급여 합을 검색하라
select deptno, sum(sal) from emp group by deptno;

-- 44. 부서별 사원들의 평균 급여를 검색하라
select deptno, avg(sal) from emp group by deptno order by deptno;

-- 45. 부서별 사원들의 입사일자의 최고값과 최저값을 검색하라
select deptno, min(hiredate), max(hiredate) from emp group by deptno;

-- 46. 부서별 사원들의 인원수를 인원수가 많은 순으로 검색하라
select deptno, count(empno) as 인원수 from emp group by deptno order by 인원수 desc;

-- 47. 부서별 사원들의 평균 급여를 평균 급여 순으로 검색하라
select deptno, avg(sal) from emp group by deptno order by avg(sal) desc;

-- 48. 부서별 사원의 급여 합을 많은 순으로 검색하라
select deptno, sum(sal) from emp group by deptno order by sum(sal) desc;

-- 49. 부서지역이 NEW YORK인 사원의 이름을 검색하라
select ename from emp where deptno = (select deptno from dept where loc = 'NEW YORK');

-- 50. ADAMS 사원이 근무 중인 부서명과 지역을 검색하라
select deptno, dname, loc from dept where deptno = (select deptno from emp where ename = 'ADAMS');
