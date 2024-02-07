-- https://download.eclipse.org/releases

show tables;

CREATE DATABASE deveop_spring;

CREATE TABLE IF NOT EXISTS tbl_member(
	uno INT PRIMARY KEY AUTO_INCREMENT,		-- 회원번호
	userid VARCHAR(50) NOT NULL, UNIQUE,	-- 아이디
	userpw VARCHAR(50) NOT NULL,			-- 비밀번호
	username VARCHAR(45) NOT NULL,			-- 이름 or 닉네임
	regdate TIMESTAMP DEFAULT now(),		-- 회원등록 시간
	updatedate TIMESTAMP DEFAULT now		-- 회원 정보 수정 시간
);

SEELCT * FROM tbl_member;