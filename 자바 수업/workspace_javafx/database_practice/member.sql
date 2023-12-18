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

-- 탈퇴한 회원의 정보를 임시 저장할 back_up_table 생성
CREATE TABLE back_up_member LIKE tbl_member;

DESCRIBE back_up_member;

-- 회원 탈퇴 시간에 대한 정보 추가
ALTER TABLE back_up_member
ADD COLUMN deleteDate TIMESTAMP DEFAULT now();

DESC back_up_member;

SELECT * FROM back_up_member;

SELECT * FROM tbl_member WHERE mId = '55555';

/* 
 	======================================
 	SQL Injection
 	사용자가 입력할 수 있는 영역을
 	개발자가 의도하지 않은 SQL문을 삽입하여 공격하는 방법
 */
-- PREPARE EXECUTE
PREPARE
mQuerry
FROM 'SELECT * FROM tbl_member WHERE mId = ? AND mPw = ?';

SET @mId = 'root';
SET 2password = 'root';

EXECUTE mQuery USING @mId, @password;





