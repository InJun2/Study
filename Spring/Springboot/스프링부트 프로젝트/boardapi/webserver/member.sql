use exam;

create table user (
	name varchar(20),
    id varchar(20) null,
    age int null
);

create table myuser (
	name varchar(30) null,
    age int null,
    home varchar(100)
);

create table member(
	user_no int primary key,
    user_id varchar(20) unique,
    user_pwd varchar(256) not null,
    user_authority varchar(10) check ( user_authority in ('ROLE_A', 'ROLE_B', 'ROLE_ADMIN' ))
);

create table member_seq(
	member_no int default 0
);

insert into member values (1, '111', '$2a$10$Ak3zANpSNPlCkZUMB8P0tuSw6i4J3ACHp.O1rlOnaigwyO6Ar82Au','ROLE_A');
insert into member values (2, '222', '$2a$10$WJ69pK9YXHOVSQ7Tz5.UveIKXdd4dZl3.GhXh3HqQHwJ9ef2LNpWS', 'ROLE_B');
insert into member values (3, '333', '$2a$10$ICky4gl5GtMT7MfGar7sYu2YPmbTAkUjD6gtKIKs5pE.U3DSfwoMu', 'ROLE_ADMIN');

insert into member_seq values (3);

drop table member;

drop table member_seq;

select * from member;

select member_no from member_seq;

update member_seq set member_no =
	(
	select member_no +1 from 
		(
			select member_no 
            from member_seq
		)tmp
);



commit

insert into member values