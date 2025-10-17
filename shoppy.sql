/** 데이터베이스 생성 */
create database shoppy;

/** 데이터베이스 열기 */
use shoppy;
select database();

/** 테이블 목록 확인 */
show tables;

/** member 테이블 생성 */
create table member(
	id 		varchar(20) primary key,
    pwd 	varchar(12) not null,
    name 	varchar(4) not null,
    phone	char(13),
    email 	varchar(50) not null,
    mdate	date
);
desc member;
select * FROM shoppy.member;
select count(id) from member where id = 'test';