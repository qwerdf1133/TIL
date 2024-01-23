use develop_jsp;
-- 실행할 쿼리 문 블럭 지정 후 alt + x or alt + c
-- 또는 우클릭 
show tables;

-- member_test.sql
CREATE TABLE IF NOT EXISTS member(
		num INT PRIMARY KEY auto_increment,
        name VARCHAR(50),
        addr VARCHAR(300)
);
/*
	INSERT   SELECT   UPDATE    DELETE
	Create    Read    Update    Delete
    CRUD 처리
*/
-- table에 값 삽입 - INSERT 
-- num, name, addr
INSERT INTO member VALUES(null,'홍길동','한양');
INSERT INTO member(name,addr) VALUES('최기근','제주');

SELECT * FROM member;

SELECT num, name, addr FROM member ORDER BY num DESC;

commit;







