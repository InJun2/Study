/*
    <DDL(Data Definition Language)>
        데이터 정의 언어로 오라클에서 제공하는 객체를 만들고 변경하고 삭제하는 등 ( create, alter, drop )
        실제 데이터 값이 아닌 데이터의 구조 자체를 정의하는 언어로 DB관리자, 설계자가 주로 사용한다.
        
        * 오라클에서의 객체 : 테이블, 뷰, 시퀸스, 인덱스, 프로시저, 함수, 사용자 등등
        
    <create>
        데이터 베이스의 객체를 생성하는 구문
    
    <table>
        테이블은 행과 열로 구성되는 가장 기본적인 데이터베이스 객체로 데이터베이스 내에서 모든 데이터는 테이블에 저장된다
    
    <테이블 생성>
        create table 테이블명 ( 
            컬럼명 자료형(크기) [default 기본값] [제약조건] ,
            컬럼명 자료형(크기) [default 기본값] [제약조건]....
        );
*/
create table member (
    id varchar2(20),
    password varchar2(20),
    name varchar2(20),
    enroll_date date default sysdate
);

desc member;    -- 테이블 정보 조회
select * from member;

/*
    <컬럼에 주석 달기>
        comment on column 테이블명.컬럼명 is '주석내용';
*/
comment on column member.id is '회원아이디';
comment on column member.password is '회원비밀번호';
comment on column member.name is '회원이름';
comment on column member.enroll_date is '회원가입일';

/*
    데이터 딕셔너리(메타데이터)
        자원을 효율적으로 관리하기 위한 다양한 객체들의 정보를 저장하는 시스템 테이블이다.
        사용자가 객체를 생성하거나 객체를 변경하는 등의 작업을 할때 데이터베이스에 의해서 자동으로 갱신되는 테이블이다.
        데이터에 관한 데이터가 저장되어 있다고 해서 메타 데이터라고도 함.
        
    user_tables     : 사용자가 가지고 있는 테이블들의 전반적인 구조를 확인하는 뷰 테이블
    user_tab_cols   : 테이블, 뷰의 컬럼과 관련된 정보를 조회하는 뷰 테이블
*/
select * from user_tables; -- 사용자의 테이블 정보 보여줌, 메타데이터라고도 함
select * from user_tab_cols;    -- 사용자 테이블의 컬럼 정보 보여줌

-- 테이블에 샘플 데이터 추가 ( insert )
-- insert into 테이블명[(컬럼명, 컬럼명, ...)] values(값, 값,...);
insert into member values('user1','1234','홍길동','2021-10-19');   -- 테이블 모든 속성 값 삽입
insert into member values('user2','1234','김철수',sysdate);
insert into member values('user3','1234','전우치',default);
insert into member(id,password) values('user4','1234');     -- 특정 값만 삽입

select * from member;   -- 들어간 행 확인

-- 위에서 테이블에 추가한 데이터를 실제 데이터베이스에 반영한다 ( 메모리버퍼에 임시 저장된 데이터를 실제 테이블에 반영 )
commit;     

show autocommit;    --insert 하면 테이블에 바로 반영하게 해주는 autocommit 확인, 대부분 데이터베이스에서는 autocommit 사용하지 않음

/*
    <제약조건(constraint)>
        사용자가 원하는 조건의 데이터만 유지하기 위해서 테이블작성 시 각 컬럼에 대해 저장될 값에 대한 제약조건을 설정할 수 있다.
        제약 조건은 데이터 무결성 보장을 목적으로 한다 ( 데이터의 정확성과 일관성을 유지시키는 것 )
        
        *종류 : not null, unique, check, primary key, foreign key
        
        [표현법]
            1) 컬럼 레벨
                create table 테이블명 (
                    컬럼명 자료형(크기) [constraint 제약조건명] 제약조건,
                    .....
                );
            2) 테이블 레벨
                create table 테이블명 (
                    칼럼명 자료형(크기),
                    ....
                    [constraint 제약조건명] 제약조건(컬럼명)
                );
*/

select * from user_constraints;     -- 사용자가 작성한 제약조건이 걸려있는 컬럼을 확인하는 뷰
select * from user_cons_columns;    -- 사용자가 작성한 제약조건이 걸려있는 칼럼을 확인하는 뷰

/*
    <not null>
        해당 컬럼에 반드시 값이 있어야만 하는 경우 사용한다
        삽입/수정 시 null 값을 허용하지 않도록 제한한다.
*/

-- 기존 member 테이블은 값에 null이 있어도 삽입 가능하다
-- * not null 제약조건은 컬럼 레벨에서만 설정이 가능하다
drop table member;

create table member(
    id varchar2(20) not null,
    password varchar2(20) not null,
    name varchar2(20) not null,
    enroll_date date default sysdate
);
-- null 값을 넣어 삽입하면 오류발생

/*
    <unique 제약조건>
        컬럼의 입력 값에 중복 값을 제한하는 제약조건이다.
        데이터를 삽입/수정 시 기존에 있는 데이터 값 중에 중복되는 값이 있을 경우 삽입/수정되지 않는다
        제약조건 지정 방식으로 컬럼 레벨, 테이블 레벨 방식 모두 사용 가능하다.
*/
drop table member;

create table member(
    id varchar2(20) not null unique,
    password varchar2(20) not null,
    name varchar2(20) not null,
    enroll_date date default sysdate
);

create table member(
    id varchar2(20) constraint member_id_nn not null,
    password varchar2(20) constraint member_password_nn not null,
    name varchar2(20) constraint member_name_nn not null,
    enroll_date date default sysdate,
    constraint member_id_uq unique(id)
);

-- 여러개의 컬럼을 묶어서 하나의 unique 제약 조건을 설정하는 것도 가능하다. ( 단, 반드시 테이블 레벨로만 설정이 가능하다 )

create table member( 
    no number constraint member_no_nn not null,
    id varchar2(20) constraint member_id_nn not null,
    password varchar2(20) constraint member_password_nn not null,
    name varchar2(20) constraint member_name_nn not null,
    enroll_date date default sysdate,
    constraint member_no_id_uq unique(no, id)   -- no와 id 묶어서 unique 제약조건 설정
);

/*
    <check 제약조건>
        컬럼에 기록되는 값에 조건을 설정하고 조건을 만족하는 값만 기록할 수 있다
        비교 값은 리터럴만 사용 가능하다(변하는 값이나 함수 사용하지 못한다)
        
        [표현법]
            check(비교연산자)
                check(컬럼 [not] in (값, 값...))
                check(컬럼 = 값)
                check(컬럼 between 값 and 값)
                check(컬럼 like '_문자' or 컬럼 like '문자%')
                ...
*/

create table member( 
    no number constraint member_no_nn not null,
    id varchar2(20) constraint member_id_nn not null,
    password varchar2(20) constraint member_password_nn not null,
    name varchar2(20) constraint member_name_nn not null,
    gender char(3) constraint member_gender_ck check (gender in ('남','여')),
    age number constraint member_age_ck check(age>0),
    enroll_date date default sysdate,
    constraint member_no_id_uq unique(id) 
);

/* 
    <primary key(기본키) 제약조건>
        테이블에서 한 행의 정보를 식별하기 위해 사용할 컬럼에 부여하는 제약조건이다.
        각 행들을 구분할 수 있는 식별자 역할(사번, 부서코드, 직급코드, ...)
        기본 키 제약조건을 설정하게 되면 자동으로 해당 컬럼에 not null + unique 제약조건이 설정된다
        한 테이블에 한 개만 설정할 숫 있다. ( 단, 한 개 이상의 컬럼을 묶어서 primary key로 제약조건을 설정할 수 있다)
        컬럼 레벨, 테이블 레벨 방식 모두 설정 가능하다.
*/
create table member( 
    no number constraint member_no_pk primary key,
    id varchar2(20) constraint member_id_nn not null,
    password varchar2(20) constraint member_password_nn not null,
    name varchar2(20) constraint member_name_nn not null,
    gender char(3) constraint member_gender_ck check (gender in ('남','여')),
    age number constraint member_age_ck check(age>0),
    enroll_date date default sysdate,
--    constraint member_no_pk primary key(no),
    constraint member_no_id_uq unique(id) 
);

/*
    <foreign key(외래키) 제약조건>
        다른 테이블에 존재하는 값만을 가져야 하는 컬럼에 부여하는 제약조건이다 ( 단, null 값도 가질 수 있다 )
        즉, 참조된 다른 테이블이 제공하는 값만 기록할 수 있다 ( foreign key 제약조건에 의해서 테이블 간에 관계가 형성된다 )
        
        [표현법]
            1) 컬럼 레벨
                컬럼명 자료형(크기) [constraint 제약조건명]  references 참조테이블명 [(기본키) ] [삭제룰]
            
            2) 테이블 레벨
                [constraint 제약조건명] foreign key(컬럼명) references 참조테이블명 [(기본키)] [삭제룰]
                
        [삭제룰]
            부모테이블의 데이터가 삭제되었을 때 옵션을 지정해 놓을 수 있다.
            1) on delete restrict : 자식 테이블의 참조키가 부모 테이블의 키값을 참조하는 경우 부모 테이블의 행을 삭제할 수 없다 (기본으로 적용되는 옵션)
            2) on delete set null : 부모 테이블의 데이터가 삭제 시 참조하고 있는 자식 테이블의 컬럼 값이 NULL로 변경된다
            3) on delete cascade  : 부모 테이블의 데이터가 삭제 시 참조하고 있는 자식 테이블의 컬럼 값이 존재하는 행 전체가 삭제된다.
*/
-- 회원등급에 대한 데이터를 보관하는 테이블 ( 부모테이블 )
create table member_grade(
    grade_code number primary key,
    grade_name varchar2(30) not null
);

insert into member_grade values(10, '일반회원');
insert into member_grade values(20, '우수회원');
insert into member_grade values(30, '특별회원');

create table member( 
    no number constraint member_no_pk primary key,
    id varchar2(20) constraint member_id_nn not null,
    password varchar2(20) constraint member_password_nn not null,
    name varchar2(20) constraint member_name_nn not null,
    gender char(3) constraint member_gender_ck check (gender in ('남','여')),
    age number constraint member_age_ck check(age>0),
    grade_id number constraint mumber_grade_id_kf references member_grade (grade_code) on delete set null,  -- 자식행을 삭제하면 해당 행의 정보 null
    enroll_date date default sysdate,
 -- constraint mumber_grade_id_kf foreign key(grade_id) references member_grade [(grade_code), -- grade_code 생략가능
    constraint member_no_id_uq unique(id) 
);

create table member_grade(
    grade_code number primary key,
    grade_name varchar2(30) not null
);

insert into member_grade values(10, '일반회원');
insert into member_grade values(20, '우수회원');
insert into member_grade values(30, '특별회원');

drop table member;
drop table member_grade;

insert into member values(1,'user1','1234','아무개','남',25,10,default);
insert into member values(3,'user3','1234','춘향이','여',20,null,default);

delete from member_grade
where grade_code= 10;

select * from member;
select * from member_grade;

rollback;

create table member( 
    no number constraint member_no_pk primary key,
    id varchar2(20) constraint member_id_nn not null,
    password varchar2(20) constraint member_password_nn not null,
    name varchar2(20) constraint member_name_nn not null,
    gender char(3) constraint member_gender_ck check (gender in ('남','여')),
    age number constraint member_age_ck check(age>0),
    grade_id number constraint mumber_grade_id_kf references member_grade (grade_code) on delete cascade,   -- 자식 테이블을 조회해보면 삭제된 행을 조회하고 있던 자식 테이블의 행들이 모두 삭제됨
    enroll_date date default sysdate,
 -- constraint mumber_grade_id_kf foreign key(grade_id) references member_grade [(grade_code), -- grade_code 생략가능
    constraint member_no_id_uq unique(id) 
);

select  uc.constraint_name,
        uc.constraint_type,
        uc.table_name,
        ucc.column_name
from user_constraints uc
join user_cons_columns ucc on uc.constraint_name = ucc.constraint_name
where ucc.table_name = 'member';

-----------------------------------------------
/*
    <subquery를 이용한 테이블 생성>
        subquery를 사용해서 테이블을 생성한다
        컬럼명, 데이터 타입, 값이 복사되고 제약 조건은 not null 만 복사 된다.
        
        [표현법]
            create table 테이블명
            as 서브 쿼리;
*/
-- employee 테이블을 복사한 새로운 테이블 생성(컬럼, 데이터타입, 값, not null 제약조건을 복사)
create table employee_copy
as select *
    from employee;

-- employee 테이블을 복사한 새로운 테이블 생성(컬럼, 데이터타입, not null 제약 조건을 복사)
create table employee_copy2
as select *
    from employee
    where 1 = 0;    -- 결과가 fault 이므로 조회되는 데이터가 하나도 없음

-- employee 테이블의 사번, 사원명, 급여, 연봉을 저장하는 테이블을 서브 쿼리를 사용해서 생성
create table employee_copy
as select emp_id as "사번", 
          emp_name as "사원명",
          salary as "급여", 
          salary*12 as "연봉"
    from employee;

-------------------------------------------------- 실습문제 ---------------------------------------
-- 도서관리 프로그램을 만들기 위한 테이블 만들기
-- 이때, 제약조건에 이름을 부여하고, 각 컬럼에 주석 달기

-- 1. 출판사들에 대한 데이터를 담기 위한 출판사 테이블(TB_PUBLISHER) 
--  1) 컬럼 : PUB_NO(출판사 번호) -- 기본 키
--           PUB_NAME(출판사명) -- NOT NULL
--           PHONE(출판사 전화번호) -- 제약조건 없음

--  2) 3개 정도의 샘플 데이터 추가하기


-- 2. 도서들에 대한 데이터를 담기 위한 도서 테이블 (TB_BOOK)
--  1) 컬럼 : BK_NO (도서번호) -- 기본 키
--           BK_TITLE (도서명) -- NOT NULL
--           BK_AUTHOR(저자명) -- NOT NULL
--           BK_PRICE(가격)
--           BK_PUB_NO(출판사 번호) -- 외래 키(TB_PUBLISHER 테이블을 참조하도록)
--                                    이때 참조하고 있는 부모 데이터 삭제 시 자식 데이터도 삭제 되도록 옵션 지정

--  2) 5개 정도의 샘플 데이터 추가하기


-- 3. 회원에 대한 데이터를 담기 위한 회원 테이블 (TB_MEMBER)
--  1) 컬럼 : MEMBER_NO(회원번호) -- 기본 키
--           MEMBER_ID(아이디)   -- 중복 금지
--           MEMBER_PWD(비밀번호) -- NOT NULL
--           MEMBER_NAME(회원명) -- NOT NULL
--           GENDER(성별)        -- 'M' 또는 'F'로 입력되도록 제한
--           ADDRESS(주소)       
--           PHONE(연락처)       
--           STATUS(탈퇴 여부)     -- 기본값으로 'N' 그리고 'Y' 혹은 'N'으로 입력되도록 제약조건
--           ENROLL_DATE(가입일)  -- 기본값으로 SYSDATE, NOT NULL

--  2) 3개 정도의 샘플 데이터 추가하기


-- 4. 도서를 대여한 회원에 대한 데이터를 담기 위한 대여 목록 테이블(TB_RENT)
--  1) 컬럼 : RENT_NO(대여번호) -- 기본 키
--           RENT_MEM_NO(대여 회원번호) -- 외래 키(TB_MEMBER와 참조)
--                                      이때 부모 데이터 삭제 시 NULL 값이 되도록 옵션 설정
--           RENT_BOOK_NO(대여 도서번호) -- 외래 키(TB_BOOK와 참조)
--                                      이때 부모 데이터 삭제 시 NULL 값이 되도록 옵션 설정
--           RENT_DATE(대여일) -- 기본값 SYSDATE

--  2) 샘플 데이터 3개 정도 

-- 5. 2번 도서를 대여한 회원의 이름, 아이디, 대여일, 반납 예정일(대여일 + 7일)을 조회하시오.


-- 6. 회원번호가 1번인 회원이 대여한 도서들의 도서명, 출판사명, 대여일, 반납예정일을 조회하시오.


----------------------------------------------------------------------------------------------------------------