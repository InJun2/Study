create table gallery(
    no number primary key,
    title varchar2(100),
    content varchar2(4000),
    fname varchar2(256),
    fsize number,
    ftype varchar2(100),
    enroll_date date default sysdate
);
select gallery_seq.nextval from dual;

select * from gallery;

delete from gallery;

create sequence gallery_seq nocache nocycle;

drop sequence gallery_seq;

drop table gallery;

commit;
