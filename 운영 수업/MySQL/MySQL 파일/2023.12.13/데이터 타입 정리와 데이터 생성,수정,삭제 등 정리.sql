-- 데이터베이스 선택
use sqldb;

-- DOL 테이블 생성
CREATE TABLE testTbl (id int, userName char(3), age int);

-- DML - INSERT 데이터 삽입
INSERT INTO testTbl (id, userName, age) values (1, '홍길동', 30);
-- 생략한 열에는 NULL 값이 들어간다.
INSERT INTO testTbl (id, userName) values (2, '홍길순');
-- 전체 컬럼 값을 순서대로 삽입 할 경우 컬럼 생략 가능
INSERT INTO testTbl values (3, '홍길서', 32);
-- 순서를 변경할 경우, 입력한 순서에 맞게 값을 입력
INSERT INTO testTbl (age, userName, id) values (30, '홍길남', 4);

-- DQL : 데이터 조회
SELECT * FROM testTbl;

-- AUTO_INCREMENT 숫자 자동 증가
CREATE TABLE testTbl2
	(id int AUTO_INCREMENT PRIMARY KEY,
    userName char(3), age int );

-- AUTO_INCREMENT : 속성에 입력시 null 값이 자동 입력
INSERT INTO testTbl2 values (NULL, '홍길서', 31);
INSERT INTO testTbl2 values (NULL, '홍길동', 32);
INSERT INTO testTbl2 values (NULL, '홍길남', 33);
INSERT INTO testTbl2 values (NULL, '홍길북', 34);

-- DOL 테이블의 자동증가번호 변경
ALTER TABLE testTbl2 AUTO_INCREMENT = 100;

INSERT INTO testTbl2 values (NULL, '홍길순', 35);

-- 자동 증가 값을 변경하기 (서버 변수 변경)
SET @@auto_increment_increment = 3;

INSERT INTO testTbl2 values (NULL, '홍길공', 36);
INSERT INTO testTbl2 values (NULL, '홍길강', 37);
INSERT INTO testTbl2 values (NULL, '홍길균', 38);

SELECT * FROM testTbl2;

-- 증가값 복구 
SET @@auto_increment_increment = 1;

-- 샘플 데이터 생성하기
CREATE TABLE testTbl3 (id int, Fname varchar(50), Lname varchar(50));
-- INSERT INTO ~ SELECT 문
INSERT INTO testTbl3 
	SELECT emp_no, first_name, last_name FROM employees.employees;

-- UPDATE : 데이터 수정하기    
UPDATE testTbl3 
	SET Lname = '없음'
    WHERE Fname = 'Kyoichi';
    
select * FROM testTbl3 WHERE Fname = 'Kyoichi';
SELECT * FROM testTbl3;

use sqldb;
select * from buytbl;
-- WHERE 조건절을 생략하게 될 경우, 전체 행의 값이 변경된다.
UPDATE buytbl
	SET price = price * 1.5;
select * from buytbl;

-- DELETE : 삭제
select * from testTbl3;

DELETE FROM testTbl3 where Fname = 'Georgi';

-- 상위 5건만 삭제하기
SELECT * FROM testTbl3 WHERE Fname = 'Bezalel';
DELETE FROM testTbl3 WHERE Fname = 'Bezalel' LIMIT 5;

-- autocommit 설정 확인 및 변경
-- 명령문이 실행될 때  자동으로 commit 수행 여부
SELECT @@autocommit; -- 1 : TRUE : 자동 커밋 설정 상태

SET @@autocommit :=0; -- 0 : FALSE : 자동 커밋 설정 해제
SET @@autocommit := TRUE;
SET @@autocommit := FALSE;

SELECT * from testTbl3;
UPDATE testTbl3 set Fname = '없음';
SELECT * from testTbl3;

-- TCL-ROLLBACK : 현재 세선에서 실행된 작업 이전 commit 시점으로 되돌림;
ROLLBACK;		
select * from testTbl3;
UPDATE testTbl3 Set Fname = '없음';
COMMIT; -- 현재 세션에서 실행된 작업을 적용;

-- 커밋을 수행한 지점으로 롤백
ROLLBACK;

-- 테이블 삭제
CREATE TABLE testTbl4 (SELECT * FROM employees.employees);
CREATE TABLE testTbl5 (SELECT * FROM employees.employees);
CREATE TABLE testTbl6 (SELECT * FROM employees.employees);

select * from testtbl4;

-- 모든 행을 삭제 (데이터 구조는 남아있음 DML)
DELETE FROM testTbl4;
ROLLBACK;

-- 모든 데이터를 삭제 (데이터 구조는 남아있음)
truncate TABLE testTbl5;	-- DDL은 커밋을 포함, 롤백되지 않음
select * from testTbl5; 
ROLLBACK;

-- 테이블 자체를 삭제 (데이터 구조가 남아있지 않음)
select * from testTbl6;
DROP TABLE testTbl6;		-- DDL : 커밋을 포함	
ROLLBACK;

-- 오토 커밋 원상복구
SET @@autocommit = TRUE;

