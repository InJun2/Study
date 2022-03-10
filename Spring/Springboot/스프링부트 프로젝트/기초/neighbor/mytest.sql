exec dbms_xdb.sethttpport(9090);

create table myuser(
name varchar2(10) primary key,
age number null,
home varchar2(50) null
);

insert into myuser values ( 'injun', 26, 'anyang');
insert into myuser values ( 'injun2', 26, 'anyang');

delete from myuser;

commit;