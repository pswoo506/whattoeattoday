create table restaurant(
name varchar(20) constraint restaurant_name_pk primary key
, type varchar2(15) not null
, price number(15) not null
, rate number(38,2) default 0
, rperson number(5) default 0
, hits number(5) default 0
, phonenum varchar2(20) not null
, dtime varchar2(10) not null 
);
create table member(
id varchar2(20) constraint member_id_pk primary key
, pw varchar2(20) not null 
, mileage number(15) default 0
);
------------------------------------------------------------------------------
create table record(
id varchar2(20) constraint record_id_fk references member on delete cascade
, game1 number default 0 
, game2 number default 0
, game3 number default 0
);

create table commentary(
id varchar2(20) constraint comment_id_fk references member on delete cascade
, name varchar2(20) constraint comment_name_fk references restaurant  on delete cascade
, content varchar2(1000) not null
);

 insert into member(id,pw)values('master','kita');
 insert into member(id,pw)values('ss123','12');
 insert into member(id,pw)values('ss12','12');
 commit;
 insert into restaurant(name,type,price,phonenum,dtime)values('오크우드','한식',4500,'02-4847-1335','650m');
 insert into restaurant(name,type,price,phonenum,dtime)values('술랑(뷔페)','한식',6000,'02-7596-2545','500m');
 insert into restaurant(name,type,price,phonenum,dtime)values('초계국수','한식',9000,'02-6576-3259','600m');
 insert into restaurant(name,type,price,phonenum,dtime)values('감래등','중식',6500,'02-4823-6859','40분');
 insert into restaurant(name,type,price,phonenum,dtime)values('제너럴반점','중식',7000,'02-5966-4335','450m');
 insert into restaurant(name,type,price,phonenum,dtime)values('pfchang','중식',13000,'02-3585-2658','700m');
 insert into restaurant(name,type,price,phonenum,dtime)values('홍대돈부리','일식',8000,'02-5123-6845','700m');
 insert into restaurant(name,type,price,phonenum,dtime)values('사보텐','일식',12000,'02-5416-2487','600m');
 insert into restaurant(name,type,price,phonenum,dtime)values('토모다찌','일식',10000,'02-7813-9765','720m');
 insert into restaurant(name,type,price,phonenum,dtime)values('샤이바나','양식',12000,'02-6852-1465','620m');
 insert into restaurant(name,type,price,phonenum,dtime)values('kfc','양식',7000,'02-4569-7895','450m');
 insert into restaurant(name,type,price,phonenum,dtime)values('버거킹','양식',6500,'02-9376-3845','800m');
 insert into restaurant(name,type,price,phonenum,dtime)values('니뽕내뽕','기타',9000,'02-8696-4862','620m');
 insert into restaurant(name,type,price,phonenum,dtime)values('포메인','기타',9000,'02-3869-7245','500m');
 insert into restaurant(name,type,price,phonenum,dtime)values('케밥','기타',13000,'02-8416-6575','500m');
 commit; 