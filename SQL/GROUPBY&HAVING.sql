/*
    <GROUP BY>
        그룹 기준을 제시할 수 있는 구문
        여러 개의 값들을 하나의 그룹으로 묶어서 처리할 목적으로 사용한다.
*/
-- 전체 사원을 하나의 그룹으로 묶어서 충합을 구한 결과 조회
SELECT SUM(SALARY)
FROM EMPLOYEE;

-- 각 부서별 그룹으로 묶어서 부서별 총합을 구한 결과 조회
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE;

-- 전체 사원수
SELECT COUNT(*) 
FROM EMPLOYEE;

-- 각 부서별 사원수
SELECT DEPT_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE;

-- 각 부서별 보너스를 받는 사원수
SELECT DEPT_CODE, COUNT(BONUS)
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE;

-- 각 직급별 급여 평균 조회
SELECT JOB_CODE AS "직급 코드", 
       TO_CHAR(FLOOR(AVG(NVL(SALARY, 0))), 'FML99,999,999') AS "급여 평균"
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE;

-- 부서별 사원수, 보너스를 받는 사원수, 급여의 합, 평균 급여, 최고 급여, 최저 급여를 조회
SELECT DEPT_CODE AS "부서 코드",
       COUNT(*) AS "사원수",
       COUNT(BONUS) AS "보너스를 받는 사원수",
       TO_CHAR(SUM(SALARY), '99,999,999') AS "급여의 합",
       TO_CHAR(FLOOR(AVG(NVL(SALARY, 0))), '99,999,999') AS "평균 급여",
       TO_CHAR(MAX(SALARY), '99,999,999') AS "최고 급여",
       TO_CHAR(MIN(SALARY), '99,999,999') AS "최저 급여"
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE DESC NULLS LAST;

-- 성별 별 사원수
SELECT SUBSTR(EMP_NO, 8, 1) AS "성별 코드",
       COUNT(*) AS "사원수"
FROM EMPLOYEE
GROUP BY SUBSTR(EMP_NO, 8, 1)
ORDER BY "성별 코드";

-- 여러 컬럼을 제시해서 그룹 기준을 선정
SELECT DEPT_CODE, JOB_CODE, COUNT(*), SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE
ORDER BY 1, 2;

/*
    <HAVING>
        그룹에 대한 조건을 제시할 때 사용하는 구문(주로 그룹 함수의 결과를 가지고 비교 수행)
    
    * 실행 순서
        5: SELECT      조회하고자 하는 컬럼명 AS "별칭" | 계산식 | 함수식
        1: FROM        조회하고자 하는 테이블명
        2: WHERE       조건식
        3: GROUP BY    그룹 기준에 해당하는 컬럼명 | 계산식 | 함수식
        4: HAVING      그룹에 대한 조건식
        6: ORDER BY    정렬 기준에 해당하는 컬럼명 | 별칭 | 컬럼 순번
*/
-- 각 부서별 평균 급여 조회
SELECT DEPT_CODE, FLOOR(AVG(NVL(SALARY, 0)))
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE;

-- 각 부서별 급여가 300만원 이상인 직원의 평균 급여 조회
SELECT DEPT_CODE, FLOOR(AVG(NVL(SALARY, 0)))
FROM EMPLOYEE
WHERE SALARY >= 3000000
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE;

-- 각 부서별 평균 급여가 300만원 이상인 부서들만 조회
SELECT DEPT_CODE, FLOOR(AVG(NVL(SALARY, 0)))
FROM EMPLOYEE
--WHERE FLOOR(AVG(NVL(SALARY, 0))) >= 3000000 -- 에러 발생
GROUP BY DEPT_CODE
HAVING FLOOR(AVG(NVL(SALARY, 0))) >= 3000000
ORDER BY DEPT_CODE;

-- 직급별 총 급여의 합이 10000000 이상인 직급들만 조회
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
HAVING SUM(SALARY) >= 10000000
ORDER BY JOB_CODE;

-- 부서별 보너스를 받는 사원이 없는 부서들만 조회
SELECT DEPT_CODE, COUNT(BONUS)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING COUNT(BONUS) = 0
ORDER BY DEPT_CODE;

/*
    <집계 함수>
        그룹별 산출한 결과 값의 중간 집계를 계산 해주는 함수
*/
-- 직급별 급여의 합계를 조회
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE;

-- 마지막 행에 전체 총 급여의 합계까지 조회
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(JOB_CODE)
ORDER BY JOB_CODE;

SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY CUBE(JOB_CODE)
ORDER BY JOB_CODE;

-- 부서 코드도 같고 직급 코드도 같은 사원들을 그룹 지어서 급여의 합계를 조회
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE
ORDER BY DEPT_CODE, JOB_CODE;

-- ROLLUP(컬럼 1, 컬럼 2, ...) -> 컬럼 1을 가지고 중간집계를 내는 함수

-- CUBE(컬럼 1, 컬럼 2, ...) -> 컬럼 1을 가지고 중간집계를 내고, 컬럼 2를 가지고 중간집계를 낸다. 즉, 전달되는 컬럼 모두 집계하는 함수

/*
    <집합 연산자>
        union : 두쿼리문의 수행한 결과값을 더한후 중복되는 행은 제거한다 ( 합집합 )
        union all : union 문과 동일하게 두 쿼리문을 수행한 결과값을 더하고 중복은 허용한다 ( 합집합 )
        intersect : 두 쿼리문을 수행한 결과값에 중복한 결과값만 추출한다 ( 교집합 )
        minus : 선행 쿼리의 결과값에서 후행 쿼리의 결과값을 뺀 나머지 결과값만 추출한다 ( 차집합 )
*/

-- employee 테이블에서 부서 코드가 D5인 사원들만 조회
select emp_id, emp_name, dept_code, salary
from employee
where dept_code='D5';

-- employee 테이블에서 급여가 300만원 초과인 사원들만 조회
select emp_id, emp_name, dept_code, salary
from employee
where salary>3000000;


-- union
select emp_id, emp_name, dept_code, salary
from employee
where dept_code='D5'
union
select emp_id, emp_name, dept_code, salary
from employee
where salary>3000000;

-- 위 쿼리문 대신에 where절에 or를 사용해서 처리 가능
select emp_id, emp_name, dept_code, salary
from employee
where salary>3000000 or dept_code='D5';

-- union all
select emp_id, emp_name, dept_code, salary
from employee
where dept_code='D5'
union all
select emp_id, emp_name, dept_code, salary
from employee
where salary>3000000;

-- intersect
select emp_id, emp_name, dept_code, salary
from employee
where dept_code='D5'
intersect
select emp_id, emp_name, dept_code, salary
from employee
where salary>3000000;

--and 를 이용하여 위와 동일한 결과값을 가짐
select emp_id, emp_name, dept_code, salary
from employee
where dept_code='D5' and salary>3000000;

-- minus
-- 부서코드가 D5인 사원들 중에서 급여가 300만원 초과인 사원들을 제외해서 조회
select emp_id, emp_name, dept_code, salary
from employee
where dept_code='D5'
minus
select emp_id, emp_name, dept_code, salary
from employee
where salary>3000000;

-- and 를 이용해서 위와동일하게 실행가능
select emp_id, emp_name, dept_code, salary
from employee
where dept_code='D5' and salary<=3000000;


select dept_code, count(*)
from employee
group by dept_code;

/* 특정행을 count 하는경우 해당 행의 null값은 제외해서 조회함
select dept_code, count(dept_code)
from employee
group by dept_code;
*/

/*
    <grouping set>
        그룹별로 처리된 여러 개의 select 문을 하나로 합친 결과를 원할때 사용한다
*/

select dept_code, job_code, count(*), sum(salary),min(salary)
from employee
group by grouping sets(dept_code, job_code);



-- 부서코드, 직급코드, 사수 사번이 동일한 사원의 급여 평균 조회
select dept_code, job_code, manager_id, floor(avg(nvl(salary,0)))
from employee
group by dept_code, job_code, manager_id;

-- 부서코드, 사수 사번이 동일한 사원의 급여 평균 조회
select dept_code, manager_id, floor(avg(nvl(salary,0)))
from employee
group by dept_code, manager_id;

-- 직급 코드, 사수 사번이 동일한 사원의 급여 평균 조회
select job_code, manager_id, floor(avg(nvl(salary,0)))
from employee
group by job_code, manager_id;

-- 위의 쿼리를 각각 실행해서 합친 것과 동일한 결과를 갖는다
select dept_code, job_code, manager_id, floor(avg(nvl(salary,0)))
from employee
group by grouping sets((dept_code, job_code, manager_id),(dept_code,manager_id),(job_code,manager_id));
