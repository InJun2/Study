drop table member;

create table member(
    user_no number,
    user_id varchar2(100),
    user_pwd varchar2(100),
    user_nick varchar2(100),
    user_age number,
    user_gender char(1),
    user_profile varchar2(500)
);

create sequence member_seq nocache nocycle;