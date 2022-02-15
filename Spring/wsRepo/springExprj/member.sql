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
    user_gender char(1),
    user_profile varchar2(500)
);

create table member_profile(
    file_no number primary key,
    user_no number,
    change_name varchar2(512),
    constraint member_profile_seq foreign key(user_no) references member (user_no) on delete cascade
);

drop sequence member_seq;
drop sequence member_profile_seq;

create sequence member_seq nocache nocycle;
create sequence member_profile_seq nocache nocycle;