/*
    <subquery>
        하나의 sql문 안에 포함된 또 다른 sql문을 뜻한다
        메인 쿼리 ( 기존 쿼리 )를 보조하는 역할을 하는 쿼리문 이다.
        
*/
-- 노옹철 사원과 같은 부서원들을 조회 서브 쿼리가 없다면 두번 진행해야함
select emp_name,dept_code
from employee
where emp_name = '노옹철';

select emp_name,dept_code
from employee 
where dept_code='D9';

-- subquery 사용할 경우
select emp_name,dept_code
from employee
where dept_code = (
    select dept_code 
    from employee 
    where emp_name='노옹철'
);

-------------------------------------
/*
    <서브 쿼리 구문>
        서브 쿼리는 서브 쿼리를 수행한 결과값의 행과 열의 개수에 따라서 분류할 수 있다
        
        1) 단일행 서브 쿼리    : 서브 쿼리의 조회 결과 값의 행과 열의 개수가 1개일때
        2) 다중행 서브 쿼리    : 서브 쿼리의 조회 결과 값의 행의 개수가 여러행일때
        3) 다중열 서브 쿼리    : 서브 쿼리의 조회 결과 값이 한 행이지만 컬럼이 여러개일때
        4) 다중행, 다중열 서브 쿼리   : 서브 쿼리의 조회 결과 값이 여러행, 여러열일때
        
        서브쿼리의 유형에 따라서 서브 쿼리 앞에 붙는 연산자가 달라진다.

        <단일행 서브 쿼리>
            서브 쿼리의 조회 결과 값의 행과 열의 개수가 1개 일때 ( 단일행, 단일열 )
            비교 연산자(단일행 연산자) 사용 가능 (=, !=, <>, ^=, >, <, >=, <=, ... )
*/

-- 1) 전 직원의 평균 급여보다 급여를 적게 받는 직원들의 이름, 직급코드, 급여조회
select emp_name, dept_code, salary
from employee
where salary < ( 
    select avg(nvl(salary,0))
    from employee
);

-- 2) 최저 급여를 받는 직원의 사번, 이름, 직급 코드, 급여, 입시일 조회
select emp_id, emp_name, job_code, salary, hire_date
from employee
where salary = (
    select min(salary)
    from employee
);

-- 3) 노옹철 사원의 급여보다 더 많은 급여받는 사원들의 사번, 사원명, 부서명, 직급코드, 급여조회
select e.emp_id, e.emp_name, d.dept_title, e.job_code, e.salary
from employee e
join department d on e.dept_code = d.dept_id
where salary > (
    select salary 
    from employee 
    where emp_name = '노옹철'
);
-- 오라클 구문
select e.emp_id, e.emp_name, d.dept_title, e.job_code, e.salary
from employee e, department d
where e.dept_code = d.dept_id and e.salary > (
    select salary 
    from employee 
    where emp_name = '노옹철'
);

-- 4) 부서별 급여의 합이 가장 큰 부서의 부서코드, 급여의 합 조회
select dept_code, sum(salary)
from employee
group by dept_code
having sum(salary) = (
    select max(sum(salary))
    from employee
    group by dept_code
)
order by dept_code;

-- 5) 전지연 사원이 속해있는 부서원들 조회 ( 단 전지연 사원은 제외 )
select  e.emp_id, 
        e.emp_name, 
        e.phone, 
        j.job_name, 
        d.dept_title, 
        e.hire_date
from employee e
join job j on (e.job_code = j.job_code)
join department d on (e.dept_code = d.dept_id)
where dept_code = (
select dept_code
from employee 
where emp_name = '전지연'
) and emp_name != '전지연';


/*
    <다중행 서브쿼리>
        서브 쿼리의 조회 결과 값의 행의 개수가 여러 행 일 때 
        in / not in ( 서브 쿼리 ) : 여러 개의 결과값 중에서 한 개라도 일치하는 값이 있다면 혹은 없다면 true를 리턴한다.
        any : 여러개의 값들 중에서 한 개라도 만족하면 true, in 과 다른점은 비교 연산자를 사용한다는 점이다
            salary = any(...) : in과 같은 결과
            salary != any(...) : not in과 같은 결과
            salary > any(...) : 최소값 보다 크면 true
            salary < any(...) : 최대값보다 작으면 true
        all : 여러 개의 값들 모두와 비교하여 만족해야 true, in 과 다른점은 비교 연산자를 사용한다는 점이다.
            salary > all(...) : 최대값 보다 크면 true
            salary < all(...) : 최소값 보다 작으면 true
*/

-- 1) 각 부서별 최고 급여를 받는 직원의 이름, 직급 코드, 부서코드, 급여조회
select emp_name, job_code, nvl(dept_code,'부서없음'), salary
from employee
where salary in (
select max(salary)
from employee
group by dept_code )
order by dept_code;

-- 2) 전 직원들에 대해 사번, 이름, 부서코드, 구분 (사수/사원)
-- 사번이 위와 같은 직원들의 사번, 이름, 부서코드, 구분(사수) 조회
------------------------------------------
select  emp_id, 
        emp_name, 
        dept_code,
        case
            when emp_id in (
                select distinct manager_id 
                from employee 
                where manager_id is not null
            ) then '사수'
            else '사원'
        end as "구분"
from employee;

-- 3) 대리 직급임에도 과장 직급들의 최소 급여보다 많이 받는 직원의 사번, 이름, 직급, 급여 조회
select e.emp_id, e.emp_name, j.job_name, e.salary
from employee e
join job j on (e.job_code = j.job_code)
where j.job_name = '대리' 
    and salary > any(
        select salary
        from employee e
        join job j on (e.job_code = j.job_code)
        where j.job_name='과장'
);
    
-- 4) 과장 직급임에도 차장 직급의 최대 급여보다 더 많이 받는 직원들의 사번, 이름, 직급, 급여 조회
select e.emp_id,e.emp_name, j.job_name, e.salary
from employee e
join job j on ( e.job_code = j.job_code)
where j.job_name='과장' and
    salary > all(
        select salary
        from employee e
        join job j on (e.job_code = j.job_code)
        where j.job_name='차장'
);

/*
    <다중열 서브 쿼리>
        조회 결과 값은 한 행이지만 나열된 컬럼 수가 여러개 일때
*/
-- 1) 하이유 사원과 같은 부서 코드, 같은 직급 코드에 해당하는 사원들 조회
-- 각각 단일행 서브 쿼리로 작성
select emp_name, dept_code, job_code
from employee
where dept_code = (
    select dept_code
    from employee e
    where emp_name = '하이유'
) and job_code = (
    select  job_code
    from employee e
    where emp_name = '하이유'
);

-- 다중열 서브 쿼리를 사용해서 하나의 쿼리로 작성
select emp_name, dept_code, job_code
from employee
where (dept_code, job_code) = (
    select dept_code, job_code
    from employee e
    where emp_name = '하이유'
);

-- where where (dept_code, job_code) = (('D5','J5')); 과 같이 쌍으로 묶어서 연산자 적용가능함

-- 2) 박나라 사원과 직급 코드가 일치하면서 같은 사수를 가지고 있는 사원의 사번, 이름, 직급코드, 사수사번 조회
select e.emp_id,e.emp_name,j.job_code,e.manager_id
from employee e
join job j on (e.job_code = j.job_code)
where (e.job_code,e.manager_id) = (
    select e.job_code,e.manager_id
    from employee e
    join job j on (e.job_code = j.job_code)
    where e.emp_name='박나라'
);

/*
    <다중행 다중열 서브 쿼리>
        서브쿼리의 조회 결과 값이 여러 행, 여러 열일 경우
*/
-- 1) 각 직급 별로 최소 급여를 받는 사원들의 사번, 이름, 직급코드, 급여조회
select job_code, min(salary)
from employee
group by job_code;

select emp_id, emp_name, job_code, salary
from employee
where (job_code, salary) in (
    select job_code, min(salary)
    from employee
    group by job_code
);
    
-- 2) 각 부서별 최소 급여를 받는 사원들의 사번, 이름, 부서코드, 급여조회
select emp_id, emp_name, (nvl(dept_code,'부서없음')), salary
from employee
where (nvl(dept_code,'부서없음'), salary) in (
    select (nvl(dept_code,'부서없음')), min(salary)
    from employee
    group by dept_code
)
order by dept_code;

/*
    <인라인뷰>
        from 절에 서브 쿼리를 제시하고, 서브 쿼리를 수행한 결과를 테이블 대신 사용한다
        * rownum : 오라클에서 제공하는 컬럼, 조회된 순서대로 1부터 순번을 부여하는 컬럼
        
*/
-- 1) 인라인 뷰를 활용한 top-in 분석
-- 전 직원 중 급여가 가장 높은 상위 5명의 순위, 이름, 급여 조회
select rownum, A.*
from (
    select emp_name, salary
    from employee
    order by salary desc
) A
where rownum <=5;

-- 2) 부서별 평균 급여가 높은 3개의 부서의 부서코드, 평균급여 조회
select rownum, 부서, round(평균급여)
from(
    select  nvl(dept_code,'부서없음') as "부서", 
            avg(nvl(salary,0)) as "평균급여"
    from employee
    group by dept_code
    order by 2 desc
)
where rownum <=3;

-- 2-2) with를 이용한 방법 // 별로 사용하지는 않음
with topn_sal as (
    select  nvl(dept_code,'부서없음') as "부서", 
            avg(nvl(salary,0)) as "평균급여"
    from employee
    group by dept_code
    order by 2 desc
)

select rownum, 부서, round(평균급여)
from topn_sal
where rownum <=3 ;

/*
    <RANK 함수>
        [표현법]
            RANK() OVER(정렬기준) / DENSE_RANK() OVER(정렬기준)
            
            Rank() OVER(정렬기준) : 동일한 순위 이후의 등수를 동일한 인원수만큼 건너뛰고 순위를 계산
                                    (ex. 공동 1위가 2명이면 다음순위는 3위)
            DENSE_RANK() OVER(정렬기준) : 동일한 순위 이후의 등수를 무조건 1씩 증가
                                    (ex. 공동 1위가 2명이면 다음순위는 2위)
*/
-- 사원별 급여가 높은 순서대로 순위를 매겨서 순위, 사원명, 급여조회
select dense_rank() over(order by salary desc)as "RANK", 
    emp_name, salary
from employee
where rank() over(order by salary desc) <=5;

-- 동일하게 실행
select rank, emp_name, salary
from (
    select rank() over(order by salary desc) as "RANK",
    emp_name, salary
    from employee
)
where rank <= 5;