SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS Album;
DROP TABLE IF EXISTS board;
DROP TABLE IF EXISTS calendar;
DROP TABLE IF EXISTS family;
DROP TABLE IF EXISTS private;
DROP TABLE IF EXISTS member;
DROP TABLE IF EXISTS msg;
DROP TABLE IF EXISTS reply;
DROP TABLE IF EXISTS TABLE_type;
DROP TABLE IF EXISTS text;




/* Create Tables */

CREATE TABLE Album
(
	num int NOT NULL AUTO_INCREMENT,
	name varchar(5) NOT NULL,
	folder varchar(20),
	file varchar(200),
	content varchar(1000),
	date datetime,
	PRIMARY KEY (num)
);


CREATE TABLE board
(
	num int NOT NULL AUTO_INCREMENT,
	pass varchar(20),
	subject varchar(100) NOT NULL,
	content varchar(4000),
	start_regdate datetime,
	readcnt int(10),
	ref int(11),
	reflevel int(3),
	refstep int(5),
	name varchar(5) NOT NULL,
	PRIMARY KEY (num)
);


CREATE TABLE calendar
(
	num int NOT NULL,
	start_regdate datetime,
	content varchar(1000),
	date datetime,
	end_regdate datetime,
	PRIMARY KEY (num)
);


CREATE TABLE family
(
	familynum  NOT NULL,
	familyname ,
	picture ,
	PRIMARY KEY (familynum)
);


CREATE TABLE member
(
	name varchar(5) NOT NULL,
	family_num int,
	pass varchar(20) NOT NULL,
	relation varchar(10),
	Tel int(11),
	address varchar(50),
	file varchar(200),
	birth datetime NOT NULL,
	PRIMARY KEY (name)
);


CREATE TABLE msg
(
	num int NOT NULL AUTO_INCREMENT,
	sender varchar(10),
	taker varchar(10),
	sendtime datetime,
	taketime datetime,
	content varchar(300),
	PRIMARY KEY (num)
);


CREATE TABLE private
(
	num int NOT NULL AUTO_INCREMENT,
	pass varchar(20),
	subject varchar(100) NOT NULL,
	content varchar(4000),
	start_regdate datetime,
	readcnt int(10),
	ref int(11),
	reflevel int(3),
	refstep int(5),
	name varchar(5) NOT NULL,
	PRIMARY KEY (num)
);


CREATE TABLE reply
(
	num int NOT NULL AUTO_INCREMENT,
	recnt int NOT NULL,
	content varchar(1000),
	start_regdate datetime,
	PRIMARY KEY (num, recnt)
);


CREATE TABLE TABLE_type
(
	table_num int NOT NULL AUTO_INCREMENT,
	table_name varchar(20) NOT NULL,
	PRIMARY KEY (table_num)
);


CREATE TABLE text
(
	num int NOT NULL AUTO_INCREMENT,
	text1 varchar(30),
	text1_1 varchar(30),
	text2 varchar(30),
	text2_1 varchar(30),
	text3 varchar(30),
	text3_1 varchar(30),
	text4 varchar(30),
	text4_1 varchar(30),
	PRIMARY KEY (num)
);



