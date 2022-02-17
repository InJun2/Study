select * from member;
select * from member_profile;

drop table member;
drop table member_profile;

create table member(
    user_no number primary key,
    user_id varchar2(100),
    user_pwd varchar2(100),
    user_nick varchar2(100),
    user_age number,
    user_gender char(1)
);

create table member_profile(
    file_no number primary key,
    user_no number,
    change_name varchar2(512),
    constraint member_profile_foreign_key foreign key(user_no) references member (user_no) on delete cascade
);

drop sequence member_seq;
drop sequence member_profile_seq;

create sequence member_seq nocache nocycle;
create sequence member_profile_seq nocache nocycle;


--notice--------------------------------------
drop table notice;
drop sequence notice_seq;

create table notice(
    no number primary key,
    title varchar2(100),
    content varchar2(4000),
    writer number,
    enroll date default sysdate,
    del char(1) default('N'),
    constraint notice_foreign_key foreign key(writer) references member (user_no) on delete cascade
);

create sequence notice_seq nocache nocycle;


-----------------------------------------------------------------------------------------------------------
--------------------------실행용----------------------------------------------------------------------------
select * from member;
select * from member_profile;
select * from notice;

drop table member cascade constraints;
drop table member_profile;
drop table notice;

drop sequence member_seq;
drop sequence member_profile_seq;
drop sequence notice_seq;


create table member(
    user_no number primary key,
    user_id varchar2(100),
    user_pwd varchar2(100),
    user_nick varchar2(100),
    user_age number,
    user_gender char(1)
);

create table member_profile(
    file_no number primary key,
    user_no number,
    change_name varchar2(512),
    constraint member_profile_foreign_key foreign key(user_no) references member (user_no) on delete cascade
);

create table notice(
    no number primary key,
    title varchar2(100),
    content varchar2(4000),
    writer number,
    enroll date default sysdate,
    del char(1) default('N'),
    constraint notice_foreign_key foreign key(writer) references member (user_no) on delete cascade
);

create sequence member_seq nocache nocycle;
create sequence member_profile_seq nocache nocycle;
create sequence notice_seq nocache nocycle;