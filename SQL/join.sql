/* 
    <join>
        두 개의 이상의 테이블에서 데이터를 조회하고자 할 때 사용하는 구문
        
        1. 등가조인 ( equal join ) / 내부 조인 ( inner join )
            연결시키는 컬럼의 값이 일치하는 행들만 조인되서 조회한다. ( 일치하는 값이 없는 행은 조회 X )
            
            1) 오라클 전용 구문
                [표현법]
                select 컬럼, 컬럼...
                from 테이블1, 테이블 2
                where 테이블1.컬럼명 = 테이블2.컬럼명;
            
                - from 절에 조회하고자 하는 테이블들을 콤마로 구분하여 나열
                - where 절에 매칭 시킬 컬럼명에 대한 조건을 제시한다.
            2) ANSI 표준 구문
                [표현법]
                    select 컬럼,컬럼..
                    from 테이블
                    [inner] join 테이블2 on (테이블1.컬럼명=테이블2.컬럼명);
                
                    - from 절에 기준이 되는 테이블을 기술한다
                    - join 절에 같이 조회하고자 하는 테이블을 기술 후 매칭 시킬 컬럼에 대한 조건을 기술한다
                    - 연결에 사용하려는 컬럼명이 같을 경우 on 구문 대신에 using(컬럼명) 구문을 사용한다
*/
-- 오라클 구문 
-- employee 테이블과 department 테이블을 조인하여 사번, 사원명, 부서코드, 부서명을 조회
-- 1) 연결한 두 컬럼명이 다른 경우
select emp_id, emp_name, dept_id, dept_title
from employee, department
where dept_code= dept_id;

-- employee 테이블과 job 테이블을 조인해서 사번, 사원명, 직급코드, 직급명을 조회
-- 2) 연결할 두 컬럼명이 같은 경우 , 방법 1 테이블명을 이용하는 방법
select emp_id, emp_name, employee.job_code, job_name
from employee, job
where employee.job_code=job.job_code;

-- 방법 2 테이블의 별칭을 이용하는 방법
select e.emp_id, e.emp_name, e.job_code, j.job_name
from employee e, job j
where e.job_code = j.job_code;

-- ANSI 구문
-- 1) 연결할 두 칼럼명이 다른경우
-- employee 테이블과 department 테이블을 조인하여 사번 , 사원명, 부서코드, 부서명을 조회
select e.emp_id, e.emp_name, e.dept_code, job_name
from employee e
inner join department d on(e.dept_code=d.dept_id);

-- 2) 연결할 두 컬럼명이 같은 경우
-- employee 테이블과 job 테이블을 조인해서 사번, 사원명, 직급코드, 직급명을 조회
-- 방법 1) using 구문을 이용하는 방법
select emp_id, emp_name, job_code, job_name
from employee
inner join job using(job_code);

-- 방법 2)테이블의 별칭을 이용하는 방법 
select e.emp_id, e.emp_name, e.job_code, j.job_name
from employee e
inner join job j on(e.job_code = j.job_code);

-- 방법 3) natural join을 이용하는 방법 ( 별로 사용하지 않는 방법 )
-- 동일한 이름의 컬럼이 있으면 using 을 사용하는 것과 비슷한 결과를 만드나 동일한 이름의 컬럼이 많으면 예상과 다른 결과가 나오기 쉬움
select emp_id, emp_name, job_code, job_name
from employee
natural join job;


-- employee 테이블과 job 테이블을 조인하여 직급이 대리인 사원의 사번, 사원명, 직급명, 급여를 조회
select e.emp_id, e.emp_name, j.job_name, e.salary
from employee e, job j
where e.job_code = j.job_code 
    and j.job_name='대리';

-- ANSI 구문
select e.emp_id, e.emp_name, j.job_name, e.salary
from employee e
inner join job j on(e.job_code=j.job_code)
where j.job_name ='대리';

/*
        2. 다중조인 
            여러개의 테이블 조인하는 경우에 사용된다.
*/
-- employee, department, location 테이블을 다중 join하여 사번, 사원명, 부서명, 지역명 조회
-- employee.dept_code = department.dept_id, department.location_id = laction.local_code
-- ANSI 구문                                         다중조인 순서 중요
select e.emp_id, e.emp_name, d.dept_title, l.local_name
from employee e
inner join department d on (e.dept_code=d.dept_id)
inner join location l on (d.location_id = l.local_code);

-- 오라클구문                                        다중조인 순서 중요하지 않음
select e.emp_id, e.emp_name, d.dept_title, l.local_name
from employee e, department d, laction l
where e.dept_code = d.dept_id 
and d.location_id = l.location_code;

/*
        3. 외부 조인 ( outter join )
            테이블 간의 join시 일치하지 않는 행도 포함시켜서 조회가 가능하다
            단, 반드시 기준이 되는 테이블 (컬럼) 을 지정해야 한다 (left/right/(+))
            
            
*/

-- 부서가 지정되지 않는 사원 2명에 대한 정보가 조회되지 않는다
-- 부서가 지정되어 있어서 department에 정보가 조회되지 않는다
select e.emp_name, d.dept_title, e.salary, e.salary * 12 as 연봉
from employee e
inner join department d on (e.dept_code = d.dept_id);

-- 1) left [outer] join : 두테이블 중 왼편에 기술된 테이블의 칼럼을 기준으로 join을 진행한다.
-- ANSI 구문
select e.emp_name, d.dept_title, e.salary, e.salary * 12 as 연봉
from employee e
left outer join department d on (e.dept_code = d.dept_id);

-- 오라클 구문
select e.emp_name, d.dept_title, e.salary, e.salary * 12 as 연봉
from employee e, department d
where e.dept_code = d.dept_id(+);

-- 2) right [outer] join : 두테이블 중 오른편에 기술된 테이블의 칼럼을 기준으로 join을 진행한다.
-- ANSI 구문
select e.emp_name, d.dept_title, e.salary, e.salary * 12 as 연봉
from employee e
right outer join department d on (e.dept_code = d.dept_id);

-- 오라클 구문
select e.emp_name, d.dept_title, e.salary, e.salary * 12 as 연봉
from employee e, department d
where e.dept_code(+) = d.dept_id;

-- 3) full [outer] join : 두 테이블ㅇ ㅣ가지는 모든 행을 조회할 수 있다 ( 오라클 구문은 지원하지 않는다 )
select e.emp_name, d.dept_title, e.salary, e.salary * 12 as 연봉
from employee e
full outer join department d on (e.dept_code = d.dept_id);

select emp_name, dept_title
from employee
cross join department;

/*
        4. 카테시안 곱(cartesian product) / 교차조인(cross join)
            조인되는 모든 테이블의 각 행들이 서로서로 모두 매핑된 데이터가 검색된다.
            테이블의 행들이 모두 곱해진 행들의 조합이 출력 -> 과부화의 위험
            
*/
-- ANSI
select emp_name, dept_title
from employee
cross join department
order by emp_name;

-- 오라클 구문
select emp_name, dept_title
from employee, department
order by emp_name;

/*
        5. 비등가 조인 ( non equal join )
            조인 조건에 등호(=) 를 사용하지 않는 조인문을 비등가 조인이라고 한다
            지정한 컬럼 값이 일치하는 경우가 아닌, 값의 범위에 포함되는 행들을 연결하는 방식이다
            ( = 이외에 비교연산자 >, <, >=, <=, between and, in, not in 등을 사용한다 )
            ANSI 구문으로는 JOIN ON 구문으로만 사용이 가능하다 ( using 사용 불가 )
*/
-- employee 테이블과 sal_grade 테이블을 비등가 조인하여 사원명, 급여, 급여 등급 조회
--ANSI 구문
select e.emp_name, e.salary, s.sal_level
from employee e
join sal_grade s on(e.salary between s.min_sal and s.max_sal);

-- 오라클 구문
select e.emp_name, e.salary, s.sal_level
from employee e, sal_grade s
where e.salary between s.min_sal and s.max_sal;

/*
        6. 자체 조인
            같은 테이블을 다시 한번 조인하는 경우에 사용한다
*/
-- ANSI 구문
-- employee 테이블을 self join하며 사번, 사원명, 부서코드, 사수사번, 사수이름 조회
select e1.emp_id 사번, e1.emp_name 사원명, e1.dept_code 부서코드,
       e1.manager_id 사수사번, e2.emp_name 사수이름
from employee e1
join employee e2 on (e1.manager_id = e2.emp_id);

-- 오라클 구문
select e1.emp_id 사번, e1.emp_name 사원명, e1.dept_code 부서코드,
       e1.manager_id 사수사번, e2.emp_name 사수이름
from employee e1, employee e2
where e1.manager_id  = e2.emp_id(+);

---------------- 실습 문제 ----------------
-- 1. DEPARTMENT 테이블과 LOCATION 테이블의 조인하여 부서 코드, 부서명, 지역 코드, 지역명을 조회
-- 오라클 구문
select d.dept_id,d.dept_title,l.local_code,l.local_name
from department d, location l
where d.location_id=l.local_code;

-- ANSI 구문
select d.dept_id,d.dept_title,l.local_code,l.local_name
from department d
inner join location l on(d.location_id=l.local_code);

-- 2. EMPLOYEE 테이블과 DEPARTMENT 테이블을 조인해서 보너스를 받는 사원들의 사번, 사원명, 보너스, 부서명을 조회
-- 오라클 구문
select e.emp_no as 사번,e.emp_name as 사원명, e.bonus as 보너스, d.dept_title as 부서명
from employee e, department d
where e.dept_code=d.dept_id and e.bonus is not null;
-- ANSI 구문
select e.emp_no as 사번,e.emp_name as 사원명, e.bonus as 보너스, d.dept_title as 부서명
from employee e
inner join department d on (e.dept_code = d.dept_id)
where e.bonus is not null;

-- 3. EMPLOYEE 테이블과 DEPARTMENT 테이블을 조인해서 인사관리부가 아닌 사원들의 사원명, 부서명, 급여를 조회
-- 오라클 구문

-- ANSI 구문 

-- 4. EMPLOYEE 테이블, DEPARTMENT 테이블, LOCATION 테이블의 조인해서 사번, 사원명, 부서명, 지역명 조회
-- 오라클 구문

-- ANSI 구문

-- 5. 사번, 사원명, 부서명, 지역명, 국가명 조회
-- 오라클 구문

-- ANSI 구문

-- 6. 사번, 사원명, 부서명, 지역명, 국가명, 급여 등급 조회 (NON EQUAL JOIN 후에 실습 진행)
-- 오라클 구문

-- ANSI 구문

------------------------------------------------------------------

------------------------- 종합 실습 문제 -------------------------
-- 1. 직급이 대리이면서 ASIA 지역에서 근무하는 직원들의 사번, 사원명, 직급명, 부서명, 근무지역, 급여를 조회하세요.
-- 오라클 구문

-- ANSI 구문

-- 2. 70년대생 이면서 여자이고, 성이 전 씨인 직원들의 사원명, 주민번호, 부서명, 직급명을 조회하세요.
-- 오라클 구문

-- ANSI 구문

-- 3. 보너스를 받는 직원들의 사원명, 보너스, 연봉, 부서명, 근무지역을 조회하세요.
--    단, 부서 코드가 없는 사원도 출력될 수 있게 Outer JOIN 사용
-- 오라클 구문

-- ANSI 구문

-- 4. 한국과 일본에서 근무하는 직원들의 사원명, 부서명, 근무지역, 근무 국가를 조회하세요.
-- 오라클 구문

-- ANSI 구문

-- 5. 각 부서별 평균 급여를 조회하여 부서명, 평균 급여(정수 처리)를 조회하세요.
--    단, 부서 배치가 안된 사원들의 평균도 같이 나오게끔 해주세요^^
-- 오라클 구문

-- ANSI 구문

-- 6. 각 부서별 총 급여의 합이 1000만원 이상인 부서명, 급여의 합을 조회하시오.
-- 오라클 구문

-- ANSI 구문

-- 7. 사번, 사원명, 직급명, 급여 등급, 구분을 조회 (NON EQUAL JOIN 후에 실습 진행)
--    이때 구분에 해당하는 값은 아래와 같이 조회 되도록 하시오.
--    급여 등급이 S1, S2인 경우 '고급'
--    급여 등급이 S3, S4인 경우 '중급'
--    급여 등급이 S5, S6인 경우 '초급'
-- 오라클 구문

-- ANSI 구문

-- 8. 보너스를 받지 않는 직원들 중 직급 코드가 J4 또는 J7인 직원들의 사원명, 직급명, 급여를 조회하시오.
-- 오라클 구문

-- ANSI 구문

-- 9. 부서가 있는 직원들의 사원명, 직급명, 부서명, 근무 지역을 조회하시오.
-- 오라클 구문

-- ANSI 구문

-- 10. 해외영업팀에 근무하는 직원들의 사원명, 직급명, 부서 코드, 부서명을 조회하시오
-- 오라클 구문

-- ANSI 구문

-- 11. 이름에 '형'자가 들어있는 직원들의 사번, 사원명, 직급명을 조회하시오.
-- 오라클 구문

-- ANSI 구문 
