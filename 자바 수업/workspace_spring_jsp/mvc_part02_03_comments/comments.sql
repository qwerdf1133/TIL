show tables;

DESCRIBE tbl_board;

SELECT * FROM tbl_board ORDER BY bno DESC;

-- 1번 게시글이 없을 시 sample data 추가
INSERT INTO tbl_board(bno,title,content,writer)
VALUES(1,'제목-test','내용-test','원빈');

-- tbl_board 게시물에 등록된 댓글을 저장할 테이블
CREATE TABLE IF NOT EXISTS tbl_comment(
	cno INT PRIMARY KEY AUTO_INCREMENT,				-- 댓글 번호
	bno INT NOT NULL,								-- 댓글이 작성된 게시글 번호
	content TEXT NOT NULL,							-- 댓글 내용
	author VARCHAR(50) NOT NULL,					-- 작성자
	regdate TIMESTAMP NOT NULL DEFAULT now(),		-- 작성 시간
	updatedate TIMESTAMP NOT NULL DEFAULT now(),	-- 수정 시간
	CONSTRAINT fk_tbl_bno FOREIGN KEY(bno) REFERENCES tbl_board(bno),
	INDEX(bno)	
);

-- 인덱스 정보 확인
SHOW INDEXES FROM tbl_comment;

-- 1번 게시글에 등록된 댓글 목록
SELECT * FROM tbl_comment WHERE bno = 1;

-- 제약 조건 정보 확인
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS 
WHERE CONSTRAINT_SCHEMA = 'develop_spring' AND TABLE_NAME = 'tbl_comment';

-- 댓글 삽입
INSERT INTO tbl_comment(bno,content,author) 
VALUES(1,'1번 게시글의 댓글','최기근');

INSERT INTO tbl_comment(bno,content,author) 
VALUES(1,'1번 게시글의 2번째 댓글','최기근');

INSERT INTO tbl_comment(bno,content,author) 
VALUES(2,'2번 게시글의 댓글','최기근');

INSERT INTO tbl_comment(bno,content,author) 
VALUES(2,'2번 게시글의 2번째 댓글','최기근');

SELECT * FROM tbl_comment WHERE bno = 1;

-- DELETE FROM tbl_comment WHERE bno = 1;

DELETE FROM tbl_board WHERE bno = 1;

-- fk_tbl_bno 제약 조건 삭제
ALTER TABLE tbl_comment DROP CONSTRAINT fk_tbl_bno;

-- CASCADE 가 추가된 외래키 제약 조건 추가
ALTER TABLE tbl_comment ADD CONSTRAINT fk_tbl_bno FOREIGN KEY(bno) 
REFERENCES tbl_board(bno) ON DELETE CASCADE;

-- 제약 조건 정보 확인
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS 
WHERE CONSTRAINT_SCHEMA = 'develop_spring' AND TABLE_NAME = 'tbl_comment';


-- tbl_board 게시물에 등록된 댓글을 저장할 테이블
CREATE TABLE IF NOT EXISTS tbl_comment(
	cno INT PRIMARY KEY AUTO_INCREMENT,				-- 댓글 번호
	bno INT NOT NULL,								-- 댓글이 작성된 게시글 번호
	content TEXT NOT NULL,							-- 댓글 내용
	author VARCHAR(50) NOT NULL,					-- 작성자
	regdate TIMESTAMP NOT NULL DEFAULT now(),		-- 작성 시간
	updatedate TIMESTAMP NOT NULL DEFAULT now(),	-- 수정 시간
	CONSTRAINT fk_tbl_bno FOREIGN KEY(bno) 
	REFERENCES tbl_board(bno) ON DELETE CASCADE,
	INDEX(bno)	
);

SELECT * FROM tbl_comment 
WHERE bno = 2 
ORDER BY cno DESC  
-- limit startRow, perPageNum;
limit 0, 10;













