/* <select>
    [표현법]
        select 컬럼, 컬럼.. 
        from 테이블명;
        
    - 데이터를 조회할때 사용하는 구문
    - select를 통해서 조회된 결과물을 result set이라고 한다. ( 조화된 행들의 집합 )
    - 조회하고자 하는 컬럼들은 반드시 form 절에 기술한 테이블에 존재하는 컬럼이어야 한다.
*/

/*
    연산자 우선순위
    0. ( )
    1. 산술 연산자
    2. 연결 연산자
    3. 비교 연산자
    4. is null, like, in
    5. between and
    6. 논리 연산자 - not
    7. 논리 연산자 - and
    8. 논리 연산자 - or
    
*/

-- employee 테이블에서 전체 사원의 사번, 이름, 월급을 조회
select emp_id, emp_name, salary from employee;

-- 모든컬럼 정보 조회
select * from employee;

-- 리터럴로 표기 가능
select emp_id,salary,'원' as 단위 
from employee;

--sysdate는 컴퓨터에 등록되어 있는 오늘날짜
select emp_name, hire_date, floor(sysdate - hire_date)
from employee;

-- 컬럼명에 별칭 지정 , 컬럼명 as 별칭 / 컬럼명 as "별칭" /  컬럼명 "별칭" 
select distinct job_code
from employee;

--------------------------------------------------------------------------------
/*
    <where절>
    [표현법]
        select 컬럼
        from 테이블명
        where 조건식;
        
    - 조회하고자 하는 테이블에서 해당 조건을 만족하는 결과만을 조회하고자 할 때 사용한다.
    - 조건식에는 다양한 연산자들을 사용할 수 있다.
*/

-- employee 테이블에서 부서 코드가 d9와 일치하는 사원들의 컬럼 정보 조회
select *
from employee
where dept_code = 'd9';

-- d9 가 아닌 사원들의 사번, 사원명, 부서 코드 조회
select emp_id, emp_name, dept_code
from employee
where dept_code != 'd9';
-- where dept_code ^= 'd9';
-- where dept_code <> 'd9';

select emp_id,emp_name,hire_date
from employee
where ent_yn = 'N';

select emp_name, salary, salary*12 as "연봉", hire_date
from employee
where (salary*12) > 50000000;

select emp_name, salary
from employee
where salary between 3500000 and 6000000;

select emp_name, salary
from employee
where salary not between 3500000 and 6000000;
-- where not salary between 3500000 and 6000000;

select * 
from employee
where hire_date between '90/01/01' and '01/01/01'
order by hire_date;

-- like 표현법 where 비교대상컬럼 like '특정 패턴' , 와일드카드 ( '%' , '_' )
select emp_name, salary
from employee
where emp_name like '이__';

select emp_name, salary, hire_date
from employee
where emp_name like '전%';

select emp_name,phone
from employee
where phone not like '010%';

--null 연산자는 is를 사용해야함
select emp_id,emp_name, salary, bonus
from employee
where bonus is null;

--값 목록중 일치하는 값이 있을때 true 리턴
select emp_name,dept_code,salary
from employee
where dept_code in('D5','D6','D8');

-- 연결 연산자 : 여러 컬럼 값을 하나의 컬럼인 것 처럼 연결하거나, 컬럼과 리터럴을 연결할 수 있다.
select emp_id || emp_name || salary
from employee;

select emp_name || '의 월급은 ' || salary || '원 입니다' as "월급 현황"
from employee;

-----------------------------------------------------------------------------------------------
/*
    <order by>절
    [표현법]
    select 컬럼
    from 테이블명
    where 조건식
    order by 정렬 시키고자 하는 컬럼 [asc | desc] [nulls first | nulls last] 
    
    // asc ( 오름차순 정렬 )혹은 desc( 내림차순 정렬 ) 작성 안할시 자동으로 asc 오름차순으로 정렬
    // asc 오름차순시 기본적으로 nulls last, desc 내림차순시 기본적으로 nulls first
    // nulls first : 정렬하고자 하는 컬럼 값에 null 이 있는 경우 해당 데이터 값을 맨 앞으로 정렬 // 
    // nulls last : 정렬하고자 하는 컬럼 값에 null 이 있는 경우 해당 데이터의 값을 맨 뒤로 정렬
*/

select emp_id, emp_name, bonus
from employee
order by bonus nulls first;

select emp_id, emp_name, bonus
from employee
order by bonus desc nulls last, salary asc; -- 첫번째 이후 정렬한후 두번째 정렬조건을 정렬

-- 칼럼의 별칭으로도 정렬 가능
select emp_name, salary * 12 as "연봉"
from employee
order by "연봉" desc; -- 별칭으로 비교연산자는 사용 불가능