-- 변수 사용하기
-- SET @변수이름 - 변수의 값;	변수 선언
-- SELECT @변수이름;			변수 확인

SET @myVar1 = 10;
SET @myVar2 = 5;
SET @myVar3 = 3.14;
SET @myVar4 = '이름->';

SELECT @myVar1;
SELECT @myVar2 + @myVar2;

SELECT @myVar4, name from usertbl;

select concat(@myVar4, '안녕하세요');

-- 데이터 타입 변환 함수
use sqldb;

-- CAST, CONVERT
-- 평균 구매 개수
select avg(amount) as 평균구매개수 from buytbl;

-- 정수로 타입 변환
-- cast(표현식 AS 데이터타임)
-- convert(표현식, 데이터타입)
select cast(avg(amount) as SIGNED INTEGER) as 평균구매개수 from buytbl;
select convert(avg(amount), signed integer) as 평균구매개수 from buytbl;

select cast('2023-12-13' as DATE);
select cast('2023.12.13' as DATE);
select cast('2023@12@13' as DATE);
select cast('2023$12$13' as DATE);

-- 숫자 데이터를 문자 데이터로 변환하여 연결한 예시
desc buytbl;
select concat(cast(price as char(10)), "*", cast(amount as char(10) ),"=" ) as '단가수량', price * amount from buytbl;

-- 암시적인 타입 변환
select '100' + '200';		 -- 정수로 암시적 형변환되어 연산
select concat('100', '200'); -- 문자열 연결
select concat(100, '200');	 -- 정수가 문자열로 암시적 형변환되어 연결	
select 1 > '2mega';			 -- 문자열이 정수 2로 변환되어 비교
select 3 > '2mega';			 -- 
select 0 = 'mega';			 -- 문자열은 비교시 0으로 변환됨

-- 내장 함수
-- 제어 흐름 함수
-- if(수식, 참일때, 거짓일때)
select if(100 > 200, '참', '거짓');
select if(100 < 200, '참', '거짓');

-- ifnull(수식1, 수식2) : 수식1이 null이 아니면 수식1, null이면 수식2를 리턴
select ifnull(null,"널입니다");
select ifnull(100,"널입니다");

-- nullif(수식1, 수식2) : 두 수식이 같으면 null, 다르면 수식1을 리턴
select nullif(100,100);
select nullif(100,200);

-- CASE 문 ~ WHEN ~ THEN 
select case 10
	when 1 then '일'
    when 10 then '십'
    else '모르는수'
end as 'case';






