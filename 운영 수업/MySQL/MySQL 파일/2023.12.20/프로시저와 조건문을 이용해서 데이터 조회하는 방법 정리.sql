-- SQL 프로그래밍

-- 스토어드 프로시저 : 저장된 절차, 여러 개의 쿼리문, 동작을 절차(프로시저오 묶어서 저장)
-- CALL을 통하여 호출

-- 프로시저 생성 방법
-- DELIMITER // ~ END // 부분까지는 저장 프로시저 코딩 부분을 묶어줌
-- 실행할 쿼리문 안에 등장하는 세미콜론(;)이 전체 구문의 종료로 인식되지 않게 변경
-- 마지막에 종료문자를 원상복귀
DELIMITER //
	CREATE PROCEDURE 프로시저이름()
		BEGIN
			-- 실행할 쿼리문들
		END //
DELIMITER ;

-- 실행
CALL 프로시저이름();

-- IF ~ ELSE 문
DELIMITER //
	CREATE PROCEDURE ifProc()
		BEGIN
			-- 실행할 쿼리문들
            DECLARE var1 INT;	-- var1 변수를 선언
            SET var1 = 100;		-- 변수에 값을 대입
            
            IF var1 = 100 THEN
				SELECT '100입니다.';
			ELSE
				SELECT '100이 아닙니다';
			END IF;
		END //
DELIMITER ;
CALL ifProc();	-- 호출

DROP PROCEDURE IF EXISTS ifProc2;	-- 기존에 프로시저가 존재하면 삭제
USE employees -- 데이터베이스 사용

DELIMITER //
	CREATE PROCEDURE ifProc2()
		BEGIN
			DECLARE hireDate DATE;	-- 입사일
            DECLARE curDate DATE;	-- 현재일
            DECLARE days INT;		-- 근무일수
            
            -- 직원의 입사일을 조회하여 hireDate 변수에 대입
			SELECT hire_date  INTO hireDate
            FROM employees.employees 
            WHERE emp_no = 10001;
            
            SET curDate = current_date();	-- 현재 날짜 대입
            SET days = datediff(curDate, hireDate);	-- 날짜 차이 구하기
            
            IF (days/365) >= 5 THEN -- 5년이 지났으면
				SELECT CONCAT('입사일로부터 ',days, '일이 지났습니다, 축하합니다');
			ELSE
				SELECT CONCAT('입사일로부터 ',days, '일이 지났어요 화이팅');
            END IF;
		END //
DELIMITER ;
-- 직원의 입사일을 호출
SELECT hire_date FROM employees.employees WHERE emp_no = 10001;

-- 호출하기
CALL ifProc2();
	
-- 매개변수를 전달하는 프로시저
-- 매개변수 선언 형식 : 'IN 매개변수명 데이터타입'

-- 사원번호를 매개변수로 받는 저장 프로시저
DELIMITER $$
	CREATE PROCEDURE info_employees(IN _empno INT)
    BEGIN
		SELECT * FROM employees.employees
        WHERE emp_no = _empno;
    END $$
DELIMITER ;

CALL info_employees(10003);

desc sqldb.usertbl;
-- usertbl 테이블 회원 이름을 전달받아서 연령대를 출력하는 프로시저
DROP PROCEDURE IF EXISTS checkAge;
DELIMITER /
	CREATE PROCEDURE checkAge(IN uname VARCHAR(10))
		BEGIN
			DECLARE yearBirth INT;  -- 연도
            DECLARE age INT; 		-- 나이
            DECLARE result TEXT;	-- 출력 연령대
            
            -- 테이블에서 조회한 출생연도를 변수에 대입
            SELECT birthYear INTO yearBirth
            FROM sqldb.usertbl WHERE name = uname;
            
            -- 현재년도에서 출생년도를 빼서 나이 변수에 대입
            SET age = year(curdate()) - yearBirth;
            
            -- if - elseif 문으로 연령대 구하여 대입
			IF age >= 60 THEN
				SET result = "60대 이상입니다.";
			ELSEIF age BETWEEN 50 AND 59 THEN
				SET result = "50대입니다.";
			ELSEIF age BETWEEN 40 AND 49 THEN
				SET result = "40대입니다.";
			ELSEIF age BETWEEN 30 AND 39 THEN
				SET result = "30대입니다.";
			ELSE
				SET result = "20대 이하입니다.";
			END IF;
            SELECT result;
		END /
DELIMITER ;
-- 호출하기
CALL checkAge('이승기');
CALL checkAge('조용필');

-- 반복문 : while을 이용하여 구구단 만들기
DELIMITER $$
	CREATE PROCEDURE whileTest(IN num INT)
		BEGIN
			DECLARE str TEXT; 	-- 구구단 문자열
            DECLARE i INT;		-- 구구단 곱할 수
            SET str = '';
            SET i = 1;
            WHILE(i < 10) Do
				SET str = CONCAT(str,' ',num,'*','=',num*i);
                SET i = i + 1;		-- 반복자 증가
			END WHILE;		-- 반복문 종료;	
            SELECT str;
        END $$
DELIMITER ;
-- 구구단 호출
CALL whileTest(6);

-- 오류처리
-- DECLARE 액션 HANDLER FOR 오류조건 처리할문장;
DROP PROCEDURE IF EXISTS errorProc;
DELIMITER $$
CREATE PROCEDURE errorProc()
	BEGIN
		-- 오류 처리
		DECLARE CONTINUE 		-- 액션 : CONTINUE, EXIT
        HANDLER FOR 1146		-- 오류코드
        SELECT '테이블이 없네요' as msg;
        
        -- 오류 발생문
        SELECT * FROM notable; -- 존재하지 않는 테이블 조회(Error code 1146)
    END $$
DELIMITER ;

CALL errorProc();

SELECT * FROM notable;		-- ERROR code 1146 문장

-- 동적 SQL문
-- PREPARE STATEMENT 문과 EXECUTE 문

USE sqldb;
-- 테이블 생성
CREATE TABLE myTable
( id	INT AUTO_INCREMENT PRIMARY KEY,
  mDate DATETIME );
  
  -- 현재 날짜와 시간
  SET @curDate = CURRENT_TIMESTAMP();
  
  -- 준비된 SQL문 : 향후에 입력될 값을 ?로 비워놓는다
  PREPARE myQuery FROM 'INSTERT INTO myTable VALUES(NULL, ?)';
  
  -- 실행 : USING 을 이용하여 ? 에 대응하는 값을 전달한다
  EXECUTE myQuery USING @curDate;
  
  SELECT * FROM myTable;	-- 확인
  
  -- 준비된 커리문 제거
  DEALLOCATE PREPARE myQuery;