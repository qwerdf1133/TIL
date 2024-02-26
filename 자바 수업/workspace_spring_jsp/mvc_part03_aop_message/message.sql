-- message.sql
CREATE TABLE tbl_user(
	uno INT PRIMARY KEY auto_increment,
	uid VARCHAR(50) NOT NULL UNIQUE,
	upw VARCHAR(50) NOT NULL,
	uname VARCHAR(50) NOT NULL,
	upoint INT NOT NULL DEFAULT 0
);

DROP TABLE tbl_message;

-- message
CREATE TABLE tbl_message(
	mno INT PRIMARY KEY auto_increment,			-- 메세지 번호
	targetid VARCHAR(50) NOT NULL,				-- 수신자 아이디
	sender VARCHAR(50) NOT NULL,				-- 발신자 아이디
	message TEXT NOT NULL,						-- 발신 메세지
	opendate TIMESTAMP NULL,					-- 수신 확인 시간
	senddate TIMESTAMP NOT NULL DEFAULT now(),	-- 발신 시간
	FOREIGN KEY(targetid) REFERENCES tbl_user(uid),
	FOREIGN KEY(sender) REFERENCES tbl_user(uid)
);

INSERT INTO tbl_user(uid, upw, uname) 
VALUES
('id001','pw001', 'IRON MAN'),
('id002','pw002', 'THOR'),
('id003','pw003', 'DR.strange');

SELECT * FROM tbl_user;

SELECT * FROM tbl_message;

/*
 
   1 id001 pw001 IRON MAN        0
   2 id002 pw002 THOR            0
   3 id003 pw003 DR.strange      0
   --------------------------------------------------------
   1 id001 pw001 IRON MAN       10
   2 id002 pw002 THOR            0
   3 id003 pw003 DR.strange      0
   ---------------------------------------------------------
   1 id001 pw001 IRON MAN       30
   2 id002 pw002 THOR            0
   3 id003 pw003 DR.strange      0
   ----------------------------------------------------------
   ROLLBACK
   1 id001 pw001 IRON MAN       30
   2 id002 pw002 THOR            0
   3 id003 pw003 DR.strange      0
   --------------------------------------------
   COMMIT
   1 id001 pw001 IRON MAN       40
   2 id002 pw002 THOR            0
   3 id003 pw003 DR.strange      0




   
 */














