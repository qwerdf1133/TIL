
CREATE TABLE tbl_board(
	bno int PRIMARY KEY auto_increment,			-- 게시글 번호
    title VARCHAR(200) NOT NULL,				-- 제목
    content TEXT null,							-- 내용
    writer VARCHAR(20) NOT NULL,				-- 작성자 이름
    regdate TIMESTAMP NOT NULL default now(),	-- 글 등록시간
    viewcnt INT default 0						-- 조회수
);

DESC tbl_board;

commit;

SELECT * FROM tbl_board;

INSERT INTO tbl_board(title,content,writer) 
SELECT title,content,writer FROM tbl_board;

commit;

