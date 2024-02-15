drop database if exists mvc1;
create database mvc1 default character set utf8;

use mvc1;

show tables;

create table user (
	userid varchar(50) primary key,
	password varchar(50) not null,
	name varchar(50) not null,
	role varchar(50) default 'User'
) default character set utf8;

desc user;

insert into user values 
('duly', '1234', '둘리', 'Admin'),
('hani', '1234', '하니', 'User'),
('micol', '1234', '마이콜', 'Guest');

select * from user;


drop table if exists board;
create table board (
	seq	int primary key auto_increment,
	title varchar(200) not null,
	nickname varchar(50) not null,
	content text not null,
	regdate datetime default now(),
	viewcnt int default 0,
	userid varchar(50)	
) default character set utf8;

-- viewcnt 컬럼명을 cnt로 변경하시오.
alter table board rename column viewcnt to cnt;

desc board;


select * from board;

insert into board (seq, title, nickname, content, regdate, userid)
values (1, '첫번째 게시물', '둘리', '첫번째 게시물 내용', subdate(curdate(),interval 7 day), 'duly');

insert into board(seq, title, nickname, content, regdate, userid) 
values(2, '두번째 게시물', '하니', '두번째 게시물 내용.', subdate(curdate(), interval 6 day), 'hani');

insert into board(seq, title, nickname, content, regdate, userid) 
values(3, '세번째 게시물', '마이콜', '세번째 게시물 내용.', subdate(curdate(), interval 5 day), 'micol');

insert into board(seq, title, nickname, content, regdate, userid) 
values(4, '네번째 게시물', '둘리', '네번째 게시물 내용.', subdate(curdate(), interval 4 day), 'duly');

insert into board(seq, title, nickname, content, regdate, userid) 
values(5, '다섯번째 게시물', '하니', '다섯번째 게시물 내용.', subdate(curdate(), interval 3 day), 'hani');

insert into board(seq, title, nickname, content, regdate, userid) 
values(6, '여섯번째 게시물', '마이콜', '여섯번째 게시물 내용.', subdate(curdate(), interval 2 day), 'micol');

insert into board (seq, title, nickname, content, regdate, userid) 
values (7 , '일곱번째 게시물', '둘리', '일곱번째 게시물 내용.', subdate(curdate(), interval 1 day), 'duly');

	insert into board (userid, title, content, nickname) 
	values ('캔디', '들장미 소녀 캔디', '외로워도 슬퍼도 나는 안울어~!', 'candy');

select * from board;

select * from board where seq=10;

update board set cnt=cnt+1 where seq=10;

update board set title = '개구리 왕코' , content = '안녕' where seq=10;











