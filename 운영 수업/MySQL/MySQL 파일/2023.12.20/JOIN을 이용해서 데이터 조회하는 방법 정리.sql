-- JOIN

-- INNER JOIN
USE SQLDB;
SELECT * FROM buytbl;
SELECT * FROM usertbl;

-- 두 테이블을 내부 조인 
SELECT * FROM buytbl
	INNER JOIN usertbl 
    ON buytbl.userId = usertbl.userId;

-- 조건절을 추가할 경우
SELECT * FROM buytbl
	INNER JOIN usertbl 
    ON buytbl.userId = usertbl.userId
WHERE buytbl.userId = "JYP";

-- 필요한 컬럼만 가져오기
-- 두 테이블 모두에 공통적으로 있는 컬럼명의 경우, 
-- 어느 테이블 컬럼을 사용할지 명시해야 함.
SELECT buytbl.userId, name, prodName, addr, concat(mobile1, mobile2) as 연락처 FROM buytbl
	INNER JOIN usertbl 
	ON buytbl.userId = usertbl.userId;

-- 테이블 2개 명시하고, where 조건절을 사용할 경우 내부 조인이 가능.
-- 호환성의 문제로 표준문법인 inner join 사용을 권장
SELECT buytbl.userId, name, prodName, addr, concat(mobile1, mobile2) as 연락처 FROM buytbl, usertbl
WHERE buytbl.userId = usertbl.userId;
    
-- 각 컬럼이 어느 테이블에 속했는지 명확하게 표시   
    SELECT buytbl.userId, usertbl.name, buytbl.prodName, usertbl.addr, concat(usertbl.mobile1, usertbl.mobile2) as 연락처 FROM buytbl
INNER JOIN usertbl
ON buytbl.userId = usertbl.userId;   

-- 별칭을 사용하여 코드를 간결하게 만듦
SELECT B.userId, U.name, B.prodName, U.addr, concat(U.mobile1, U.mobile2) as 연락처 FROM buytbl B
	INNER JOIN usertbl U
	ON B.userId = U.userId; 
    
-- 테이블 순서 변경해도 동일하게 작동
SELECT B.userId, U.name, B.prodName, U.addr, concat(U.mobile1, U.mobile2) as 연락처 FROM usertbl U
	INNER JOIN buytbl B
	ON B.userId = U.userId
WHERE B.userId = 'JYP';

-- OUTER JOIN
-- 왼쪽 테이블(처음 등장하는 테이블)의 것은 모두 출력되어야 한다.
SELECT B.userId, U.name, B.prodName, U.addr, concat(U.mobile1, U.mobile2) as 연락처 FROM usertbl U
	LEFT OUTER JOIN buytbl B
	ON B.userId = U.userId;
    
-- RIGHT OUTER JOIN : 오른쪽(두번쨰 등장)에 있는 테이블 정보 모두 출력
SELECT B.userId, U.name, B.prodName, U.addr, concat(U.mobile1, U.mobile2) as 연락처 FROM usertbl U
	RIGHT OUTER JOIN buytbl B
	ON B.userId = U.userId;
    
-- 구매 이력이 없는 회원 목록만 조회하기
SELECT B.userId, U.name, B.prodName, U.addr, concat(U.mobile1, U.mobile2) as 연락처 FROM usertbl U
	LEFT OUTER JOIN buytbl B
	ON B.userId = U.userId
WHERE B.prodName IS NULL;
    
-- FULL OUTER JOIN은 MYSQL에서 기본적으로 지원하지 않지만, LEFT JOIN으로 구현할 수 있음

-- 다대다 관계
-- 학생 테이블 
CREATE TABLE stdtbl
( stdName		VARCHAR(10) NOT NULL PRIMARY KEY,
  addr			VARCHAR(10) NOT NULL);
-- 동아리 테이블 생성
CREATE TABLE clubtbl
( clubName 		VARCHAR(10) NOT NULL PRIMARY KEY,
  roomNo		VARCHAR(10) NOT NULL);
-- 학생 동아리 테이블 생성
CREATE TABLE stdclubtbl
( num			INT	AUTO_INCREMENT NOT NULL PRIMARY KEY,
  stdName		VARCHAR(10) NOT NULL,
  clubName		VARCHAR(10) NOT NULL,
  FOREIGN KEY(stdName) REFERENCES stdtbl(stdName),
  FOREIGN KEY(clubName) REFERENCES clubtbl(clubName));
-- 데이터 삽입
INSERT INTO stdtbl VALUES ('김범수','경남'), ('성시경','서울'), ('조용필','경기'), ('은지원','경북'),('바비킴','서울');
INSERT INTO clubtbl VALUES ('수영','101호'), ('바둑','102호'), ('축구','103호'), ('봉사','104호');
INSERT INTO stdclubtbl VALUES (NULL, '김범수','바둑'), (NULL,'김범수','축구'), (NULL,'조용필','축구'), (NULL,'은지원','축구'), (NULL,'은지원','봉사'), (NULL,'바비킴','봉사');

-- 학생 테이블, 동아리 테이블, 학생 동아리 테이블
-- 학생이름 / 지역 / 가입동아리 / 동아리방 조회하기
SELECT S.stdName, S.addr, C.clubName, C.roomNo FROM stdtbl S 
	INNER JOIN stdclubtbl SC
    ON S.stdName = SC.stdName
    INNER JOIN clubtbl C
    on SC.clubName = C.clubName
ORDER BY S.stdName;

-- LEFT OUTER JOIN : 동아리에 가입되지 않은 학생도 풀력하기
SELECT S.stdName, S.addr, C.clubName, C.roomNo FROM stdtbl S 
	LEFT OUTER JOIN stdclubtbl SC
    ON S.stdName = SC.stdName
    LEFT OUTER JOIN clubtbl C
    on SC.clubName = C.clubName
ORDER BY S.stdName;

-- 아무 학생도 가입되지 않은 동아리(RIGHT OUTER JOIN)를 조회하기
SELECT S.stdName, S.addr, C.clubName, C.roomNo FROM stdtbl S 
	LEFT OUTER JOIN stdclubtbl SC
    ON S.stdName = SC.stdName
    RIGHT OUTER JOIN clubtbl C
    on SC.clubName = C.clubName
ORDER BY S.stdName;

-- FULL OUTER JOIN : 동아리에 가입되지 않은 학생 + 한명도 없는 동아리도 조회
-- LEFT JOIN 과 RIGHT JOIN을 UNION으로 합집합
SELECT S.stdName, S.addr, C.clubName, C.roomNo FROM stdtbl S 
	LEFT OUTER JOIN stdclubtbl SC
    ON S.stdName = SC.stdName
    LEFT OUTER JOIN clubtbl C
    on SC.clubName = C.clubName
UNION
SELECT S.stdName, S.addr, C.clubName, C.roomNo FROM stdtbl S 
	LEFT OUTER JOIN stdclubtbl SC
    ON S.stdName = SC.stdName
    RIGHT OUTER JOIN clubtbl C
    on SC.clubName = C.clubName;

-- 크로스 조인
SELECT * FROM buytbl, usertbl;
SELECT * FROM buytbl CROSS JOIN usertbl;

-- 방대한 양의 테스트 데이터를 만들고 싶을 때
USE employees;
SELECT count(*) FROM employees;
SELECT count(*) FROM titles;
SELECT count(*) FROM employees CROSS JOIN titles;

-- SELF JOIN
USE SQLDB;
CREATE TABLE emptbl
	( emp CHAR(3), manager CHAR(3), empTel VARCHAR(8) );

INSERT INTO empTbl VALUES('나사장',NULL,'0000');
INSERT INTO empTbl VALUES('김재무','나사장','2222');
INSERT INTO empTbl VALUES('김부장','김재무','2222-1');
INSERT INTO empTbl VALUES('이부장','김재무','2222-2');
INSERT INTO empTbl VALUES('우대리','이부장','2222-2-1');
INSERT INTO empTbl VALUES('지사원','이부장','2222-2-2');
INSERT INTO empTbl VALUES('이영업','나사장','1111');
INSERT INTO empTbl VALUES('한과장','이영업','1111-1');
INSERT INTO empTbl VALUES('최정보','나사장','3333');
INSERT INTO empTbl VALUES('윤차장','최정보','3333-1');
INSERT INTO empTbl VALUES('이주임','윤차장','3333-1-1');

SELECT A.emp, B.emp, B.empTel FROM emptbl A
	INNER JOIN emptbl B
	ON A.manager = B.emp
WHERE A.emp = '우대리';

-- UNION
desc stdtbl;
desc clubtbl;
-- 열의 개수와 데이터 타입이 맞으면 병합 가능
SELECT * FROM stdtbl
	UNION
SELECT * FROM stdtbl;

-- UNION ALL을 사용하면 중복된 데이터도 조회
SELECT * FROM stdtbl
	UNION ALL
SELECT * FROM stdtbl;

-- NOT IN : 서브 쿼리의 결과 중에서 두번째 쿼리에 해당하는 것을 제외하기 위한 구문
-- 서브쿼리문 : 핸드폰을 가지고 있지 않은 사람의 이름을 조회
SELECT name FROM usertbl WHERE mobile1 is null;

-- 서브 쿼리문 결과에 해당하는 사람을 제외한 결과 조회 가능
SELECT * FROM usertbl 
WHERE name NOT IN
	( SELECT name FROM usertbl WHERE mobile1 is null);
    
-- 서브 쿼리문에 해당하는 사람만 조회
SELECT * FROM usertbl 
WHERE name IN
	( SELECT name FROM usertbl WHERE mobile1 is null);