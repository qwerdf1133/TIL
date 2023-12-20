-- 수학 내장함수

-- ABS(숫자) : 절대값
SELECT ABS(-30);

-- CEILING(숫자) : 올림
SELECT CEILING(4.3);
-- FLOOR(숫자) : 내림
SELECT FLOOR(4.3);
-- ROUND(숫자) : 반올림
SELECT ROUND(4.3); SELECT round(4.7);

-- CONV(숫자, 원래진수, 변환진수) : 진수변환
SELECT CONV('FE', 16, 10); -- 16진수를 10진수로
SELECT CONV('FE', 16, 2); -- 16진수를 2진수로
SELECT CONV('11111110', 2, 8); -- 2진수를 8진수로

-- PI() : 원주율
SELECT PI();

-- MOD(숫자, 나눌 수) : 나머지 구하기
SELECT MOD(157, 10), 157 % 10, 15 MOD 10;

-- POW(숫자, 제곱) : 제곱수 곱하기
SELECT POW(2,8);	-- 2의 8승
-- SQRT(숫자) : 제곱근 구하기
SELECT SQRT(16);	-- 16의 루트

-- RAND() : 랜덤한 숫자 구하기 0~1 미만의 실수
SELECT RAND(), RAND() * 6, FLOOR(RAND()*6)+1;

-- 날짜 및 시간 함수 -- 

-- ADDDATE(날짜, 차이) : 더한 날짜 구하기
SELECT ADDDATE('2023-12-20',INTERVAL 31 DAY);
SELECT ADDDATE('2023-12-20',INTERVAL 2 MONTH);
-- SUBDATE(날짜, 차이) : 뺀 날짜 구하기
SELECT SUBDATE('2023-12-20',INTERVAL 31 DAY);
SELECT SUBDATE('2023-12-20',INTERVAL 2 MONTH);

-- ADDTIME(날짜/시간, 시간) : 더한 시간 구하기
SELECT ADDTIME('2023-12-20 23:59:59', '1:1:1');
SELECT ADDTIME('16:00:00', '5:15:30');
-- SUBTIME(날짜/시간, 시간) : 뺀 시간 구하기
SELECT SUBTIME('2023-12-20 23:59:59', '1:1:1');
SELECT SUBTIME('16:00:00', '5:15:30');

-- 현재 시각 구하기
SELECT NOW(), LOCALTIME(), LOCALTIMESTAMP();		   -- 동일한 현재 날짜/시각 구하기
SELECT CURDATE(), CURRENT_DATE(), CURRENT_DATE;	  	   -- 동일한 현재 날짜 구하기
SELECT CURTIME(), CURRENT_TIME(), CURRENT_TIMESTAMP(); -- 동일한 현재 시각 구하기

-- 날짜에서 연, 월, 일, 시 구하기
SELECT YEAR(NOW()), MONTH(NOW()), DAY(NOW()), HOUR(NOW());
-- 분, 초, 마이크로초
SELECT MINUTE(NOW()), SECOND(NOW()), MICROSECOND(CURRENT_TIMESTAMP());

-- 날짜, 시간 추출하기
SELECT DATE(NOW()), TIME(NOW());

-- DATEDIFF(날짜1, 날짜2) : 날짜 차이 구하기
SELECT DATEDIFF('2024-03-18',NOW());
-- DATEDIFF(시간1, 시간2) : 시간 차이 구하기
SELECT TIMEDIFF('16:30:00', CURTIME());

-- DAYOFWEEK(날짜) : 요일 구하기( 1: 일요일 ~ 7: 토요일) 반환
SELECT DAYOFWEEK(NOW());

-- LAST_DAY(날짜) : 마지막 날 구하기
SELECT LAST_DAY('2024-02-01');

-- MAKETIME(시, 분, 초) : 시간형식 만들기
SELECT MAKETIME(16,30,30);

-- QUARTER(날짜) : 분기 구하기
SELECT QUARTER(NOW());





