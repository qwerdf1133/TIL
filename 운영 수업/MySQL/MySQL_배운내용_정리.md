show databases;
create database shop_db;
-- 스키마 새로 만들기
CREATE SCHEMA `shopdb`;

-- 데이터 조회
select * from shopdb.producttbl;

-- 데이터베이스 선택
use shopdb;
select * from producttbl;

-- 특정 컬럼만 선택
select memberName from membertbl;

-- 특정 행(로우)만 선택
select * from membertbl where memberName='당탕이';

-- 중간에 공백이 있을 때는 백틱으로 감싸줘야 하나의 이름으로 인식
create table `my testtbl` (id int);

-- 테이블 삭제
drop table `my testtbl`;

create table indextbl (
	first_name varchar(14),
    last_name varchar(16),
    hire_date date
	);
desc indextbl;

-- 샘플 데이터에서 500건을 가져와 테이블에 삽입하기
insert into indextbl
	SELECT first_name, last_name, hire_date 
    FROM employees.employees
    limit 500;
select * from indextbl;
select * from mindextbl where first_name = 'Mary';

-- 인덱스 생성하기 (first_name 기준)
create index idx_indextbl_firstname on indextbl(first_name);

-- 뷰 생성하기
CREATE VIEW uv_memberTBL
AS SELECT memberName, memberAddress FROM memberTBL;

-- 뷰 조회하기
select * from uv_memberTBL;

-- 스토어드 프로시저
DELIMITER // 
create procedure myProc()

BEGIN
select * from memberTbl where memberName = '지운이';
select * from productTbl where procutName = '냉장고';
END// 
DELIMITER ; -- 구분 문자 원상복귀
-- 프로시저 호출
CALL myProc();

-- 트리거

-- 탈퇴 회원 테이블 만들기
CREATE TABLE `deletemembertbl`(
	`memberId` char(8) ,
    `memberName` char(5) ,
    `memberAddress` char(20) ,
    `deleteDate` date
);
select * from deletemembertbl;
DELIMITER //
CREATE TRIGGER trg_deleteMemberTbl
	AFTER DELETE	-- 삭제 후에 작동
    ON memberTbl	-- 멤버 테이블에서 삭제가 될 때 작동
	For EACH ROW 	-- 모든 행에 대하여 적용

BEGIN

-- 이전 테이블 내용을 탈퇴 회원 테이블(백업테이블)에 삽입
	INSERT INTO deletemembertbl
	VALUES (memberId, memberName, memberAddress, CURDATE() );
END //
DELIMITER ;

-- 회원 데이터 삭제
use shopdb;
SELECT * FROM memberTbl;
DELETE FROM membertbl where memberName = '상달이';
select * from deletedmembertbl;

SELECT * from productTbl;
delete from producttbl;