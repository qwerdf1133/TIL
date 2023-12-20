-- 문자열 함수

-- ASCII : 아스키 코드 리턴
SELECT ASCII('A');
-- CHAR : 아스키 코드를 문자열로 리턴
SELECT CHAR(65);

-- LENGTH : 문자열의 길이
SELECT LENGTH('ABC');
SELECT LENGTH('가나다'); -- 9 : UTF-8 인코딩 한글은 3BYTE로 인식
SELECT CHAR_LENGTH('가나다'); -- 3 : 문자열 글자 길이 갯수만큼 인식
SELECT BIT_LENGTH('가나다'); -- 9 BYTE * 8 BIT : 72 비트 수 만큼

-- CONCAT(문자열1, 문자열2) : 문자열 이어주기
SELECT CONCAT('가나다', '라마바');
-- CONCAT_WS(구분자, 문자열1, 문자열2 ... ) : 구분자로 문자열 이어주기
SELECT CONCAT_WS('+','가나다', '라마바','사아자');

-- 문자열 찾기
-- ELT(위치, 문자열1, 문자열2 ... ) : 해당 위치의 문자열 반환
SELECT ELT(2, '하나','둘','셋');
-- FIELD (찾을 문자열, 문자열1, 문자열2 ... ) : 문자열의 위치를 반환
SELECT FIELD('하나','하나','둘','셋');
-- FIND_IN_SET(찾을 문자열, 문자열목록) : 문자열 목록에서 위치를 반환
SELECT FIND_IN_SET('둘', '하나,둘,셋');
-- INSTR(기준 문자열, 부분 문자열) : 기준 문자열에서 부분 문자열의 위치를 반환
SELECT INSTR('하나둘셋', '하');
-- LOCATE(부분 문자열, 기준 문자열) : 기준 문자열에서 부분 문자열의 위치를 반환
SELECT LOCATE('나둘', '하나둘셋');

-- FORMAT(숫자, 소수점 자리수) : 천단위로 끊어주기 + 소수점 자리수
SELECT FORMAT(1234567.1234567, 2); 

-- LEFT(문자열, 길이) : 왼쪽에서부터 문자열 길이만큼 반환
-- RIGHT(문자열, 길이) : 오른쪽에서부터 문자열 길이만큼 반환
SELECT LEFT('가나다라마바사', 3);
SELECT RIGHT('가나다라마바사', 3);

-- UPPER(문자열) : 대문자로 변경
-- LOWER(문자열) : 소문자로 변경
SELECT UPPER('Hello, World');
SELECT LOWER('Hello, World');

-- 문자열 채우기
-- LPAD(문자열, 길이, 채울문자열)
SELECT LPAD("12월", 3, "0");
SELECT RPAD("홍길동", 7, "*");

-- 공백 제거하기
-- LTRIM(문자열)
SELECT LTRIM("	뱅탄	bts	");
SELECT RTRIM("	뱅탄	bts	");

-- REPEAT(문자열, 반복횟수) : 문자열 반복하기
SELECT REPEAT("가자", 10);

-- REPLACE(문자열, 변경할 문자열, 바꿀 문자열) : 문자열 변경하기
SELECT REPLACE("이것이 MySQL", "이것이", "This is");

-- REVERSE(문자열) : 문자열 뒤집기
SELECT REVERSE("BANANA");

-- SPACE(공백길이) : 공백길이 리턴
SELECT CONCAT("방탄소년단",SPACE(14),"BTS");

-- ** SUBSTRING(문자열, 시작위치, 길이) : 시작위치부터 길이만큼 문자 반환 **
SELECT SUBSTR("Hello World", 7, 5);
SELECT SUBSTR("Hello World", -2, 2);	-- 음수 시작위치는 뒤에서부터 검색












