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
        4: HAVING      그룹에 대한 조건식                               -- 그룹에 대한 where 절이라고 생각하면 됨
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















