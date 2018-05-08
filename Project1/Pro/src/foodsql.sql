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
 insert into restaurant(name,type,price,phonenum,dtime)values('��ũ���','�ѽ�',4500,'02-4847-1335','650m');
 insert into restaurant(name,type,price,phonenum,dtime)values('����(����)','�ѽ�',6000,'02-7596-2545','500m');
 insert into restaurant(name,type,price,phonenum,dtime)values('�ʰ豹��','�ѽ�',9000,'02-6576-3259','600m');
 insert into restaurant(name,type,price,phonenum,dtime)values('������','�߽�',6500,'02-4823-6859','40��');
 insert into restaurant(name,type,price,phonenum,dtime)values('���ʷ�����','�߽�',7000,'02-5966-4335','450m');
 insert into restaurant(name,type,price,phonenum,dtime)values('pfchang','�߽�',13000,'02-3585-2658','700m');
 insert into restaurant(name,type,price,phonenum,dtime)values('ȫ�뵷�θ�','�Ͻ�',8000,'02-5123-6845','700m');
 insert into restaurant(name,type,price,phonenum,dtime)values('�纸��','�Ͻ�',12000,'02-5416-2487','600m');
 insert into restaurant(name,type,price,phonenum,dtime)values('������','�Ͻ�',10000,'02-7813-9765','720m');
 insert into restaurant(name,type,price,phonenum,dtime)values('���̹ٳ�','���',12000,'02-6852-1465','620m');
 insert into restaurant(name,type,price,phonenum,dtime)values('kfc','���',7000,'02-4569-7895','450m');
 insert into restaurant(name,type,price,phonenum,dtime)values('����ŷ','���',6500,'02-9376-3845','800m');
 insert into restaurant(name,type,price,phonenum,dtime)values('�ϻͳ���','��Ÿ',9000,'02-8696-4862','620m');
 insert into restaurant(name,type,price,phonenum,dtime)values('������','��Ÿ',9000,'02-3869-7245','500m');
 insert into restaurant(name,type,price,phonenum,dtime)values('�ɹ�','��Ÿ',13000,'02-8416-6575','500m');
 commit; 