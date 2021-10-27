/*
    <view>
        select 문을 지정할 수 있는 객체 ( 논리적인 가상 테이블 )
        데이터를 저장하고 있지 않으며 테이블에 대한 sql만 저장되어 있어 view 접근할 때 sql을 수행하면서 결과값을 가져온다
        
        [표현법]
            create [or replace] veiw 뷰명
            as 서브쿼리;
*/
-- '한국'에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무 국가명을 조회하시오
select e.emp_id, e.emp_name, d.dept_title, e.salary, n.national_name
from employee e
join department d on e.dept_code = d.dept_id
join location l on d.location_id = l.local_code
join national n on l.national_code = n.national_code
where n.national_name = '한국';

-- '러시아'에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무 국가명을 조회하시오
select e.emp_id, e.emp_name, d.dept_title, e.salary, n.national_name
from employee e
join department d on e.dept_code = d.dept_id
join location l on d.location_id = l.local_code
join national n on l.national_code = n.national_code
where n.national_name = '러시아';
-------------------------------------------------------
-- 한줄짜리 주석
-- 사용자 게정 생성하는 구문 ( 관리자 계정만 할 수 있음 )
-- [표현법] create user 계정명 indentified by 비밀번호;

-- 위에서 만든 사용자 계정에게 최소한의 권한 
create user KH identified by kH;

GRANT CREATE VIEW TO kh;
---------------------------------------------------------
create or replace view v_employee
as select e.emp_id, e.emp_name, d.dept_title, e.salary, n.national_name
from employee e
join department d on e.dept_code = d.dept_id
join location l on d.location_id = l.local_code
join national n on l.national_code = n.national_code;

select *
from v_employee;        -- 가상 테이블로 실제 데이터가 담겨있는 것은 아니다

-- '한국'에서 근무하는 사원들의 정보를 조회
select*
from v_employee
where national_name='한국';

-- '한국'에서 근무하는 사원들의 정보를 조회
select*
from v_employee
where national_name='한국';

-- '러시아'에서 근무하는 사원들의 정보를 조회
select*
from v_employee
where national_name='러시아';

-- 총무부에서 근무하는 사원들의 정보를 조회
select emp_name, salary
from v_employee
where dept_title='총무부';

select *
from user_views;

-------------------------------------------------------------------------
/*
    <뷰 컬럼에 별칭 부여>
        서브쿼리의 select 절에 함수나 산술연산이 기술되어 있는 경우 반드시 별칭을 지정해야 한다.
*/

-- 사원의 사번, 사원명, 성별, 근무년수를 조회할 수 있는 뷰를 생성
create view v_emp_01
as select   emp_id,
            emp_name, 
            decode(substr(emp_no,8,1),'1','남','2','여') as "성별",
            extract(year from sysdate) - extract(year from hire_date) as "근무년수"
from employee;


create view v_emp_02("사번","사원명","성별","근무년수")        -- 모든 컬럼에 별칭을 부여해야 한다
as select   emp_id,
            emp_name, 
            decode(substr(emp_no,8,1),'1','남','2','여') as "성별",
            extract(year from sysdate) - extract(year from hire_date) as "근무년수"
from employee;

select * from user_views;   -- 사용자가 만들어둔 뷰 확인 가능
select * from v_emp_01;
select * from v_emp_02;

drop view v_emp_01;             -- 뷰 삭제
drop view v_emp_02;
----------------------------------------------------------------------------------------------------------
/*
    <view를 이용해서 DML (insert, update, delete) 사용>
        뷰를 통해 데이터를 변경하게 되면 실제 데이터가 담겨있는 기본 테이블에도 적용된다
        
*/
create view v_job
as select *
    from job;
 
select *
from v_job;

insert into v_job values('J8','알바');

select *
from job;       -- 뷰를 참고한 테이블에도 값이 변경됬음

update v_job
set job_name='인턴'
where job_code='J8';

delete from v_job
where job_code='J8';

-------------------------------------------------------------------------------
/*
    <DML 구문으로 view 조작이 불가능한 경우>
    
    1) 뷰 정의에 포함되지 않는 컬럼을 조작하는 경우
    
    2) 뷰에 포함되지 않은 컬럼 중에 기본 테이블 상에 not null 제약조건이 지정된 경우
    
    3) 산술 표현식으로 정의된 경우
    
    4) 그룹 함수나 group by 절을 포함한 경우
    
    5) distinct를 포함한 경우
    
    6) join을 이용해서 여러 테이블을 연결한 경우
*/
-- 하나의 뷰를 생성후 삭제하는 것을 전제로 6가지 생성
--    1) 뷰 정의에 포함되지 않는 컬럼을 조작하는 경우
create or replace view v_job
as select job_code              -- job_code만 생성
from job;

-- insert 
insert into v_job values('J8','알바');    -- job_name은 정의 되있지 않음. 삽입 불가
-- update 
update v_job
set job_name = '알바'
where job_code = 'J8';
-- delete 
delete from v_job 
where job_name='사원';


--    2) 뷰에 포함되지 않은 컬럼 중에 기본 테이블 상에 not null 제약조건이 지정된 경우
create or replace view v_job            -- or replace는 만드려는 중복되는 뷰가 있으면 기존에 뷰를 덮어쓰고 생성함
as select job_name 
from job;

-- insert 
insert into v_job values('알바');     -- 기존 테이블인 job 테이블에 job code가 not null 제약 조건이 있기때문에 삽입 불가능
-- update 
update v_job
set job_name = '인턴'
where job_name = '사원';              -- 문제 없이 실행됨
-- delete 
delete from v_job 
where job_name='인턴';                -- employee 테이블에서 job 코드를 참조키로 걸고 있기 때문에 삭제 불가능


--    3) 산술 표현식으로 정의된 경우
create or replace view v_emp_sal
as select emp_id, emp_name, salary, salary * 12 as "연봉"
    from employee;

--insert 
insert into v_emp_sal values (800,'홍길동',3000000,36000000);  -- 산술 연산식으로 만들어진 컬럼은 기존 테이블의 employee 테이블에 존재하지 않기때문에 삽입 불가능
insert into v_emp_sal values(800,'홍길동',3000000);    -- 값이 충분하지 않다고 나옴
--update
update v_emp_sal
set "연봉" = 8000000
where emp_id = '200';                                   -- 산술 연산식 업데이트 불가능, 산술연산식이 아니라면 업데이트 가능
--delete 
delete from v_emp_sal
where "연봉" = 60000000;                                -- 기존테이블의 employee 테이블에 존재하지 않기 떄문에 delete 문은 사용 가능

    
--    4) 그룹 함수나 group by 절을 포함한 경우
create or replace view v_emp_sal
as select dept_code, sum(salary) as "합계", floor(avg(nvl(salary, 0))) as "평균"
    from employee
    group by dept_code;
    
-- insert 
insert into v_emp_sal values('D0',8000000,4000000);     -- 위와 동일하게 기존테이블에 없는 가상 컬럼이므로 삽입 불가능
-- update
update v_emp_sal
set "합계" = 12000000                                    -- 위와 동일하게 기존 테이블에 벗는 가상 컬럼이므로 수정 불가능
where dept_code = 'D1';

update v_emp_sal
set dept_code = 'D0'                                   -- 그룹핑한 컬럼 수정 불가능
where dept_code = 'D1';
-- delete
delete from v_emp_sal
where dept_code = 'D1';                                -- 그룹핑한 가상 컬럼 삭제 불가능

--    5) distinct를 포함한 경우
create or replace view v_dt_job
as select distinct job_code
    from employee;

-- insert 
insert into v_dt_job values('J8');                    --  기존 테이블에서 중복만 제거한 가상 컬럼이므로 추가 불가능
-- update
update v_dt_job
set job_code = 'J8'
where job_code = 'J7';                                -- 기존 테이블에서 중복만 제거하여 만들어진 가상 컬럼이므로 수정 불가능
-- delete
delete from v_dt_job
where job_code = 'J7';                                -- 중복만을 제거하여 만들어진 뷰이기 때문에 삭제 불가능


--    6) join을 이용해서 여러 테이블을 연결한 경우
create or replace view v_emp
as select e.emp_id,e.emp_name, d.dept_title
    from employee e
    join department d on e.dept_code = d.dept_id;
    
-- insert 
insert into v_emp values(800,'홍길동', '총무부');       -- join하고 있는 테이블 삽입 불가능
-- update
update v_emp
set dept_title = '총무1팀'                             -- join하고 있는 테이블 수정 불가능
where emp_id = 200;
-- delete
delete from v_emp
where emp_id = 200;                                    -- join 하는 상태의 컬럼 삭제가 아니므로 삭제 가능


------------------------------------------------------------------------------------
/*
    <view 옵션>
        create [or replace] [force | noforce] view
        as 서브쿼리
        [with check option]
        [with read olny];
        
        -or replace : 기존에 동일한 뷰가 있을 경우 덮어쓰고, 존재하지 않으면 뷰를 새로 생성한다
        -force : 서브쿼리에 기술된 테이블이 존재하지 않는 테이블이어도 뷰가 생성된다
        - noforce : 서브 쿼리에 기술된 테이블이 존재해야만 뷰가 생성된다
        - with check option : 서브 쿼리에 기술된 조건에 부합하지 않는 값으로 수정하는 경우 오류를 발생시킨다
        - with read only : 뷰에 대해 조회만 가능 (DML 수행불가)
*/

-- 1) or replace
create or replace view v_emp_01
as select emp_name, salary, hire_date
    from employee;
    
select * from user_views;

select * from v_emp_01;

create force view v_emp_02
as select tcode,tname,tcontent
    from tt;

select * from user_views;

select * from v_emp_02;

-- tt 테이블을 생성하면 그때부터 view 조회 가능
create table tt(
    tcode number,
    tname varchar2(10),
    tcontent varchar2(20)
);

-- 3) with check option
create or replace view v_emp_03
as select *
    from employee
    where salary >= 3000000
    with check option;
    
select * from v_emp_03;

-- 서브쿼리의 조건에 부합하지않기 때문에 변경불가능
update v_emp_03
set salary = 2000000
where emp_id = 200;

-- 서브쿼리의 조건에 부합하기 때문에 변경가능
update v_emp_03
set salary = 4000000
where emp_id = 200;

-- 4) with read only
create view v_dept_01
as select *
    from department
    with read only;
-- read only 는 DML 구문 모두 불가능

select * from  user_views;

-- insert
insert into v_dept_01 values('D0','해외영업 4부','L5');
-- update 
update v_dept_01
set location_id = 'L2'
where dept_title = '해외영업1부';
--delete 
delete from v_dept_01
where dept_id = 'D1';