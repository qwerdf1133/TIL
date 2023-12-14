/**
	신규 계정 생성
	계정명 : cloud
    접속위치 : localhost
    비밀번호 : 12345
    
    위 에서 생성된 cloud 계정에 모든 데이터베이스와 모든 테이블을 조작 할 수 있는 권한 부여
    
    신규 database(Schema 생성)
    database 명 : cloud_digital
    
    cloud_digital 생성 후 cloud_digital database에
    emp, dept, salgrade sample data 추가
*/

USE cloud_digital;

SELECT * FROM emp;
SELECT * FROM dept;
SELECT * FROM salgrade;

-- 1. 실습에 사용될 EMP 테이블의 구조를 검색하라
desc emp;
-- 2. 부서의 부서코드와 부서명을 검색하라
select deptno, dname from dept;
-- 3. 부서의 부서명과 지역을 검색하라
select dname, loc from dept;
-- 4. 사원들의 급여와 커미션을 검색하라
select sal, comm from emp;
-- 5. 사원들의 입사일자를 중복을 제거하고 검색하라
select hiredate from emp group by hiredate;
-- 6. 사원들의 매니저를 중복을 제거하고 검색하라
select mgr from emp group by mgr;
-- 7. 사원들의 입사일자를 중복을 제거하고 검색하라
select hiredate from emp group by hiredate;
-- 8. 사원들의 부서번호를 중복을 제거하고 검색하라
select deptno from emp group by deptno;
-- 9. 사원들의 6개월 급여의 합을 구하라
select (sal * 6) from emp;
-- 10. 사원들의 6개월 커미션의 합을 구하라
select (comm * 6) from emp;
-- 11. 사원의 이름을 'Name'으로, 사원의 급여를 'Salary'로 열의 이름을 부여하여 검색하라
select ename as Name,sal as Salary from emp;
-- 12. 사원의 사원번호, 이름, 부서번호, 입사일자를 제목을 한글로 바꾸어 검색하라
select empno as 사원번호, ename as 이름, deptno as 부서번호, hiredate as 입사일자 from emp;
-- 13. 부서테이블에서 부서번호, 부서명, 지역을 한글 제목으로 검색하라
select deptno as 부서번호, dname as 부서명, loc as 지역 from dept;
-- 14. 사원의 부서번호와 이름 합쳐서 검색하라
select concat(deptno, ename) from emp;
-- 15. 사원의 이름, 입사일자를 '80/12/17에 입사한 SMITH입니다.'식으로 검색하라
select concat(hiredate,' 에 입사한 ',ename,' 입니다') from emp;
-- 16. 10번 부서에 근무하는 사원들의 이름을 검색하라
select ename from emp where deptno = 10;
-- 17. 급여가 2000이상인 사원들의 사원번호, 이름을 검색하라
select empno, ename from emp where sal >= 2000;
-- 18. 직무가 'CLERK'인 사원들의 사원번호, 이름을 검색하라
select empno, ename from emp where job = 'CLERK';
-- 19. 1980년 12월 17일에 입사한 사원들의 이름을 검색하라
select ename from emp where hiredate = 19801217;
-- 20. 부서번호 30이외의 부서명과 지역을 검색하라
select dname, loc from dept where deptno != 30;
-- 21. 급여등급이 5인 급여의 상위급여와 하위급여를 검색하라
select hisal, losal from salgrade where grade = 5;
-- 22. 'WARD' 사원의 모든 정보를 검색하라
select * from dept,emp where ename = 'WARD';
-- 23. 10번 부서에 근무하는 MANAGER의 이름을 검색하라
select ename from emp where deptno = 10 and job = 'MANAGER';
-- 24. 급여가 2000이상이며, 30번 부서에 근무하는 사원들의 사원번호, 이름을 검색하라
select empno, ename from emp where sal >= 2000 and deptno = 30;
-- 25. 직무가 'CLERK'이며, 81년 이후에 입사한 사원들의 사원번호, 이름을 검색하라
select empno, ename from emp where job = 'CLERK' and hiredate >= 19820101;
-- 26. 20부서 외에 근무하는 MANAGER의 이름을 검색하라
select ename from emp where deptno != 20 and job = 'MANAGER';
-- 27. BOSTON이외 지역에 있는 부서의 부서명을 검색하라
select dname from dept where loc != 'BOSTON';
-- 28. ANALYST이며 급여가 2000 이하인 사원의 이름을 검색하라
select ename from emp where job = 'ANALYST' and sal <= 2000;
-- 29. 급여가 1000 이상이며, 2500 이하인 사원의 사원번호와 이름을 검색하라
select empno, ename from emp where sal >= 1000 and sal <= 2500;
-- 30. 사원번호 75XX인 사원의 사원번호와 이름, 부서번호를 검색하라
select empno, ename, deptno from emp where empno like '75%';
-- 31. 부서번호 10 또는 30에 근무하는 사원들의 이름과 급여를 검색하라
select empno, sal from emp where deptno IN(10, 30);
-- 32. 매니저가 76으로  시작하는 사원들의 이름을 검색하라
select ename from emp where mgr like '76%';
-- 33. 사원번호가 79로 시작하는 사원들의 이름과 급여, 커미션을 검색하라
select ename, sal, comm from emp where empno like '79%';
-- 34. 1981년 2월에 입사한 사원의 사원번호, 이름, 부서번호를 검색하라
select empno, ename, deptno from emp where hiredate >= 19810201 and hiredate <= 19810228;
-- 35. 이름 중간에 'A'가 들어있는 사원의 사원번호, 이름을 검색하라
select empno, ename from emp where ename like '%A%';
-- 36. 매니저가 NULL인 사원의 사원번호, 이름을 검색하라
select empno, ename from emp where mgr IS NULL;
-- 37. 매니저가 NULL이 아닌 사원의 사원번호, 이름, 매니저를 검색하라
select empno, ename, mgr from emp where mgr IS NOT NULL;
-- 38. 사원번호가 7902 또는 7781인 사원의 이름을 검색하라
select ename from emp where empno IN(7902, 7781);
-- 39. 매니저 번호가 7698 또는 7839인 사원의 사원번호, 이름을 검색하라
select ename, empno from emp where mgr IN(7698,7839);
-- 40. 직무가 'MANAGER' 또는 'SALESMAN'인 사원의 사원번호, 이름, 부서번호를 검색하라
select empno, ename, deptno from emp where job = 'MANAGER' or job = 'SALESMAN';
-- 41. 사원들의 사원번호, 이름을 사원번호순으로 검색하라
select empno, ename from emp order by empno;
-- 42. 사원들의 사원번호, 이름을 부서번호별 이름순으로 검색하라
select empno, ename from emp order by deptno, ename;
-- 43. 사원들의 정보를 부서별 급여가 많은 순으로 검색하라
select * from emp order by deptno, sal desc;
-- 44. 사원들의 정보를 직무별 급여 순으로 검색하라
select * from emp order by sal desc, job desc;
-- 45. 사원들의 정보를 부서별, 직무별, 급여 순으로 검색하라
select * from emp order by deptno asc, job desc, sal desc;
-- 46. 사원들의 이름을 소문자로 검색하라
select lower(ename) from emp;
-- 47. 사원들의 이름, 직무를 소문자로 검색하라
select lower(ename),lower(job) from emp;
-- 48. 사원들의 이름을 대문자로 검색하라
select upper(ename) from emp;
-- 49. 사원들의 이름, 직무를 대문자로 검색하라
select upper(ename),upper(job) from emp;
-- 50. 사원들의 이름을 첫 자만 대문자로 검색하라
select concat(upper(left(ename,1)),lower(substring(ename,2))) from emp;