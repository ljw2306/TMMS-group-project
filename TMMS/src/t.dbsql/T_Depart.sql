create table depart(
did number(3) primary key,
dname varchar2(20) not null
)

insert into depart values(0,'없음');
insert into depart values((select nvl(max(did),0)+1 from DEPART),'비정규직');
insert into depart values((select nvl(max(did),0)+1 from DEPART),'정규직');
insert into depart values(100,'비고');
select * from DEPART
insert ino depart values(3,'백수');

drop table depart

drop table member

delete from member

delete from DEPART
