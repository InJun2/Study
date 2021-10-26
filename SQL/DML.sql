/*
    <DML ( Data Manipulation Language )>
        데이터 조작언어로 테이블에 값을 삽입(insert)하거나, 수정(update), 삭제(delete)하는 구문이다
        
    <insert>
        테이블에 새로운 행을 추가하는 구문
    
        [표현법]
            1) insert into 테이블명 values(값, 값, 값....);
                테이블에 모든 컬럼에 값을 insert 하고자 할 때 사용한다.
            2) insert into 테이블명(컬럼명,컬럼명......) values (값, 값, 값......)
                테이블에 내가 선택한 컬럼에 대한 값만 insert 하고자 할 때 사용한다
                선택이 안된 컬럼들은 기본적으로 null 값이 들어간다 ( not null 제약조건이 걸려있는 컬럼은 반드시 선택해서 값을 제시해야 한다 )
                단, 기본값(default)이 지정되어 있으면 null 이 아닌 기본값이 들어 간다
            3) insert into 테이블 (서브쿼리);
                values를 대신해서 서브 쿼리로 조회한 결과값을 통채로 insert 한다. ( 즉, 여러행을 insert 시킬수 있다 )
                서브 쿼리의 결과값이 insert 문에 지정된 컬럼의 개수와 데이터 타입이 같아야 한다.
*/
-- 표현법 1 번 사용
insert into employee
values('900','공유','901008-108503','you@kh.or.kr','01055556666','D1','J7',
        4000000,0.2,'200',sysdate,null,default);
    
-- 표현법 2번 사용
insert into employee(emp_id,emp_name,emp_no,job_code)
values('901','문인수','800525-1234567','J7');

-- 표현법 3번 사용
create table emp_01(
    emp_id number,
    emp_name varchar2(30),
    dept_title varchar2(35)
);

-- 전체 사원의 사번, 이름, 부서명을 조회하여 결과값을 emp_01 테이블에 insert한다
insert into emp_01(
    select emp_id, emp_name, d.dept_title
    from employee e
    left outer join department d on (e.dept_code = d.dept_id)
);

insert into emp_01(emp_id, emp_name)(
    select emp_id, emp_name
    from employee
);


select * from emp_01;

rollback;

/*
    <insert all>
        두 개 이상의 테이블에 insert 하는데 동일한 서브 쿼리가 사용되는 경우
        insert all 을 이용해서 여러 테이블에 한 번에 데이터 삽입이 가능하다
        
        [표현법]
            1) insert all
                into 테이블명1[(컬럼,컬럼...)] values(값,값....)
                into 테이블명2[(컬럼,컬럼...)] values(값,값....)
                서브 쿼리;
            
            2)  insert all
                when 조건1 then
                    into 테이블명1[(컬럼,컬럼...)] values(값,값....)
                when 조건2 then 
                    into 테이블명2[(컬럼,컬럼...)] values(값,값....)
                서브 쿼리;
*/
-- 표현법 1)번을 테스트할 테이블 만들기(구조만 생성)
create table emp_dept
as select emp_id, emp_name, dept_code, hire_date
    from employee
    where 1=2;

create table emp_manager
as select emp_id, emp_name, manager_id
    from employee
    where 1=2;
    
-- emp_dept 테이블에 employee 테이블의 부서 코드가 D1인 직원의 사번, 이름, 부서코드, 입사일을
-- emp_manager 테이블에 employee 테이블의 부서코드가 D1인 직원의 사번, 이름, 관리자 사번을 조회하여 삽입한다
insert all
into emp_dept values (emp_id, emp_name, dept_code, hire_date)
into emp_manager values(emp_id, emp_name, manager_id)
    select emp_id, emp_name, dept_code, hire_date, manager_id
    from employee
    where dept_code = 'D1';

-- 표현법 2번을 테스트할 테이블 만들기( 테이블 구조만 복사 )
create table emp_old
as select emp_id,emp_name, hire_date, salary
    from employee
    where 1=2;

create table emp_new
as select emp_id,emp_name, hire_date, salary
    from employee
    where 1=2;

-- employee 테이블의 입사일 기준으로 2000년 1월 1일 이전에 입사한 사원의 정보는 emp_old테이블에 삽입하고
-- 2000년 1월 1일 이후에 입사한 사원의 정보는 emp_new 테이블에 삽입
insert all
when hire_date < '2000/01/01' then
    into emp_old values(emp_id, emp_name, hire_date, salary)
when hire_date >= '2000/01/01' then
    into emp_new values(emp_id,emp_name,hire_date, salary)
select emp_id,emp_name, hire_date, salary
from employee;

/*
    <update>
        테이블에 기록된 데이터를 수정하는 구문
        
        [표현법 1]
            update 테이블명 
            set 컬럼명 = 변경하려는 값, 
                컬럼명 = 변경하려는 값 
                .....
            [where 조건];
        
        [표현법 2]
            update 테이블명 
            set 컬럼명 = (서브쿼리), 
                컬럼명 = (서브쿼리) 
                .....
            [where 조건];
        
        - set 절에서 여러 개의 컬럼을 콤마(,)로 나열해서 값을 동시에 변경할 수 있다
        - where 절을 생략하면 모든 행의 데이터가 변경된다
        - update 시에 서브 쿼리를 사용해서 서브 쿼리를 수행한 결과값으로 컬럼의 값을 변경할 수 있다.
*/
-- 테스트 진행할 테이블 생성
create table dept_copy
as select *
    from department;

create table emp_salary
as select emp_id, emp_name, salary, bonus
    from employee;
   
-- dept_copy 테이블에서 dept_id가 'D9'인 부서명을 '전략기획팀'으로 수정
update dept_copy
set dept_title = '전략기획팀'
where dept_id='D9';       -- where 절 생략시 모든 행 변경 , 조심해야함

-- emp_salary 테이블에서 노옹철 사원의 급여를 5000000원으로 변경
update emp_salary
set salary = 5000000
where emp_name='노옹철';

-- 모든 사원의 급여를 기존 급여에서 10프로 인상한 금액 ( 기존 급여 * 1.1 ) 으로 변경
update emp_salary
set salary = salary * 1.1;

-- update 시 변경할 값은 해당 컬럼에 대한 제약조건에 위배되면 안된다
update emp_salary
set emp_id = null       -- not null 제약조건이 존재하기때문에 에러발생
where emp_id = 200; 

-- employee 테이블에 노옹철 사원의 부서코드 'D0'으로 변경
update employee 
set dept_code = 'D0'        -- foreign key 제약조건에 위배해서 에러발생
where emp_name = '노옹철';

-- 방명수 사원의 급여와 보너스를 유재식 사원과 동일하게 변경
update emp_salary
set (salary,bonus) = (
    select salary,bonus
    from emp_salary
    where emp_name = '유재식'
)
where emp_name = '방명수';

-- 노옹철, 전형돈, 정중하, 하동운 사원의 급여와 보너스를 유재식 사원과 동일하게 변경
update emp_salary
set (salary,bonus) = (
    select salary,bonus
    from emp_salary
    where emp_name = '유재식'
)
where emp_name in ('노옹철','전형돈','정중하','하동운');

-- emp_salar 테이블에서 아시아 지역에 근무하는 직원들의 보너스를 0.3으로 변경
-- 아시아 지역에 근무하는 사원들 조회
update emp_salary
set bonus = 0.3
where emp_id in (
    select e.emp_id
    from employee e
    join department d on (e.dept_code = d.dept_id)
    join location l on (d.location_id = l.local_code)
    where l.local_name like ('ASIA%')
);

/*
    <delete>
        테이블에 기록된 데이터를 삭제하는 구문이다 ( 행 단위로 삭제 )
        
        [표현법]
            delete from 테이블명
            [where 조건식];
        
        - where 절을 제시하지 않으면 전체 행이 삭제된다
*/
commit; -- 롤백해서 돌아올 시점 
-- 공유 사원의 데이터 지우기
delete from emp_salary
where emp_name = '공유';

rollback;   -- 마지막 커밋 시점으로 롤백

delete from department
where dept_id = 'D1';       -- D1값을 참조하는 자식 테이블 데이터가 있기 때문에 삭제가 되지 않는다

/*
    <truncate>
        테이블의 전체 행을 삭제할 때 사용하는 구문으로 delete 보다 수행 속도가 더 빠르다
        별도의 조건 제시가 불가능하고 rollback이 불가능하다
    
    [표현법]
        truncate table 테이블명;
*/
truncate table emp_salary;
truncate table dept_copy;       -- 롤백이 불가능함

