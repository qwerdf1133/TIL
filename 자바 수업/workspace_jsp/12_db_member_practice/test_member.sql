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

-- 질문과 답변 - 자유게시판 table
CREATE TABLE IF NOT EXISTS qna_board(
	qna_num INT PRIMARY KEY AUTO_INCREMENT, -- 글번호
	qna_name VARCHAR(20) NOT NULL,			-- 작성자
	qna_title VARCHAR(200) NOT NULL,		-- 글 제목
	qna_content TEXT NOT NULL,				-- 글 내용
	qna_write_num INT NOT NULL,				-- 글 작성자 회원 번호
	qna_readcount INT DEFAULT 0,			-- 조회수
	qna_date TIMESTAMP DEFAULT now()		-- 글 작성 시간
);

-- qna_wirte_num column -> qna_writer_num 으로 수정
ALTER TABLE qna_board change qna_write_num qna_writer_num INT NOT NULL;

DESC qna_board;

-- 조회수 증가
UPDATE qna_board SET qna_readcount = qna_readcount + 1 WHERE qna_num = 1;

commit;

INSERT INTO qna_board (qna_name, qna_title, qna_content, qna_writer_num) 
SELECT qna_name, qna_title, qna_content, qna_writer_num FROM qna_board; 
-- WHERE qna_num NOT IN (1,2);

SELECT * FROM qna_board ORDER BY qna_num DESC; 

-- 원본글(질문글)일 경우 자신의 게시글 번호를 저장
-- 답변글일 경우 자신이 답변하는 원본글의 번호를 저장
-- 동일한 그룹 번호일 경우 묶어서 출력
ALTER TABLE qna_board ADD COLUMN
qna_re_ref INT NOT NULL DEFAULT 0 AFTER qna_content;

-- 기존에 등록된 행정보에 자기 글 번호로 qna_re_ref 컬럼 수정
UPDATE qna_board SET qna_re_ref = qna_num;

SELECT * FROM qna_board ORDER BY qna_re_ref DESC;

INSERT INTO qna_board VALUES(null,'최기근','44번의 답변글','없음',44,6,0,now());

-- view 화면에서 출력될 답변 글의 깊이
ALTER TABLE qna_board ADD COLUMN
qna_re_lev INT NOT NULL DEFAULT 0 AFTER qna_re_ref;

-- 원본글과 답변글 끼리의 정렬 순서 기준
ALTER TABLE qna_board ADD COLUMN
qna_re_seq INT NOT NULL DEFAULT 0 AFTER qna_re_lev;

UPDATE qna_board SET
qna_re_lev = qna_re_lev + 1,
qna_re_seq = qna_re_seq + 1
WHERE qna_num = 61;

SELECT * FROM qna_board ORDER BY qna_re_ref DESC, qna_re_seq ASC;

INSERT INTO qna_board(qna_name, qna_title, qna_content, qna_writer_num)
VALUES('최기근','안녕하세요','mysql이 뭔가',6);

SELECT max(qna_num) FROM qna_board;

SELECT LAST_INSERT_ID();

rollback;




