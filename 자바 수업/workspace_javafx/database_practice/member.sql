CREATE TABLE tbl_member(
	mNum INT PRIMARY KEY auto_increment,
	mName VARCHAR(50),
	mId VARCHAR(20) NOT NULL UNIQUE,
	mPw VARCHAR(30) NOT NULL,
	reg BIGINT DEFAULT 0
);

INSERT INTO tbl_member(mName,mId,mPw)
VALUES('관리자','root','root');

SELECT * FROM tbl_member;

commit;







