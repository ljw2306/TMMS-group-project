create table member(
id varchar2(50) primary key not null,
name varchar2(50) not null,
age number(3) default 0 check(age<200),
did number(3) references depart (did)
)

insert into member values ('m001','kim',10,0);
insert into member values ('m002','lee',20,1);
insert into member values ('m003','choi',30,2);
insert into member values('m004','yun',40,0);

select * from member

select * from DEPART
delete from member where id='m004';
