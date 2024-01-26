-- num(int) / id / pass / name / addr / phone / gender / age(int)
CREATE TABLE test_member(
	num INT PRIMARY KEY auto_increment,
	id VARCHAR(30) UNIQUE NOT NULL,
	pass VARCHAR(30) NOT NULL,
	name VARCHAR(50),
	addr TEXT,
	phone VARCHAR(20),
	gender VARCHAR(10),
	age int(3)
);

-- 관리자 계정 추가 - id : admin , pass - admin , name - MASTER
INSERT INTO test_member 
VALUES(null,'admin','admin','MASTER',
	   '부산광역시','01011111111','남성',30);
	   
SELECT * FROM test_member ORDER BY num DESC;

SELECT * FROM test_member WHERE id = 'userid';

SELECT * FROM test_member WHERE id = 'userid' AND pass = 'userpass';

commit;

INSERT INTO test_member 
VALUES
(null,'id043','pw043','이기근','부산광역시','01011111111','남성',30),
(null,'id044','pw044','공기근','부산광역시','01011111111','남성',30),
(null,'id045','pw045','박기근','부산광역시','01011111111','남성',30),
(null,'id046','pw046','조기근','부산광역시','01011111111','남성',30),
(null,'id047','pw047','엄기근','부산광역시','01011111111','남성',30),
(null,'id048','pw048','조기근','부산광역시','01011111111','남성',30),
(null,'id049','pw049','최기근','부산광역시','01011111111','남성',30),
(null,'id040','pw040','김기근','부산광역시','01011111111','남성',30),
(null,'id041','pw041','송기근','부산광역시','01011111111','남성',30),
(null,'id042','pw042','엄기근','부산광역시','01011111111','남성',30);

commit;

SELECT count(*) FROM test_member;

SELECT * FROM test_member WHERE name LIKE CONCAT('%','','%');

-- 공지형 게시판 
CREATE TABLE IF NOT EXISTS notice_board(
	notice_num INT PRIMARY KEY AUTO_INCREMENT,		-- 공지 글 번호
	notice_category VARCHAR(20) NOT NULL,			-- 공지 분류
	notice_author VARCHAR(50) NOT NULL,				-- 작성자
	notice_title VARCHAR(200) NOT NULL,				-- 제목
	notice_content TEXT NOT NULL,					-- 내용
	notice_date TIMESTAMP NOT NULL DEFAULT now()	-- 작성 시간
);









