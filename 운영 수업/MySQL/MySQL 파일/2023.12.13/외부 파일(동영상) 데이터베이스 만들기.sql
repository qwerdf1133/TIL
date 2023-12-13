-- 영화 데이터베이스 만들기
CREATE DATABASE moviedb;

use moviedb;
create table movietbl
	(movie_id		int,
    movie_title		VARCHAR(30),
    movie_director	VARCHAR(20),
    movie_star		VARCHAR(20),
    movie_script	LONGTEXT,
    movie_film		LONGBLOB
    ) DEFAULT CHARSET=utf8mb4;
    
-- 영화 데이터 삽입 : longtext, longblob이 삽입되지 않음
INSERT INTO movietbl values
(1, '쉰들러리스트','스필버그','리암 니슨', 
load_file('C:/ProgramData/MySQL/MySQL Server 8.2/Uploads/Schindler.txt'),
load_file('C:/ProgramData/MySQL/MySQL Server 8.2/Uploads/Schindler.mp4')
);
INSERT INTO movietbl values
(2, '쇼생크탈출','프랭크 다라본트','팀 로빈스', 
load_file('C:/ProgramData/MySQL/MySQL Server 8.2/Uploads/Shawshank.txt'),
load_file('C:/ProgramData/MySQL/MySQL Server 8.2/Uploads/Shawshank.mp4')
);
INSERT INTO movietbl values
(3, '라스트모히칸','마이클 만','다니엘', 
load_file('C:/ProgramData/MySQL/MySQL Server 8.2/Uploads/Mohican.txt'),
load_file('C:/ProgramData/MySQL/MySQL Server 8.2/Uploads/Mohican.mp4')
);
select * from movietbl;

-- 파일 내보내기 
SELECT movie_script from movietbl where movie_id=2
	INTO outfile 'C:/ProgramData/MySQL/MySQL Server 8.2/Uploads/out.txt'
    LINES TERMINATED BY '\\n';

SELECT movie_film from movietbl where movie_id=3
	INTO dumpfile 'C:/ProgramData/MySQL/MySQL Server 8.2/Uploads/out.mp4';
    
-- 시스템 변수 확인하기
show variables;
select @@max_allowed_packet; -- 최대 허용 패킷 크기
select @@secure_file_priv; -- 허용된 경로 위치