/*
    <PL/SQL>
        오라클 자체에 내장되어 있는 절차적 언어로 SQL 문장 내에서 변수의 정의, 조건처리(if), 반복 처리(roop, for, while)등을 지원한다
        (다수의 SQL문을 한 번에 실행이 가능하다.)
        
        [PL/SQL의 구조]
            1) 선언부(declare section) : declare로 시작, 변수나 상수를 선언 및 초기화 하는 부분
            2) 실행부(executable section) : begin로 시작, SQL문, 제어문 ( 조건, 반복문 ) 등의 로직을 기술하는 부분
            3) 예외처리(exception section) : exception로 시작, 예외 발생 시 해결하기 위한 구문을 기술하는 부분

    <PS/SQL 선언부(declare section)>
        변수 및 상수를 선언해 놓는 공간이다 ( 선언과 동시에 초기화도 가능 )
        변수 및 상수는 일반 타입 변수, 레퍼런스 타입, ROW 타입 변수로 선언해서 사용할 수 있다
        
        1) 일반 타입 변수의 선언 및 초기화
            [표현법]
                변수명 [constant] 자료형(크기) [:= 값];
        2) 레퍼런스 타입 변수 선언 및 초기화
            [표현법]
                변수명 테이블명.컬럼명%TYPE;
                
                - 해당 하는 테이블의 컬럼에 데이터 타입을 참조해서 그 타입으로 변수를 지정한다.
        3) row 타입 변수 선언 및 초기화
            [표현법]
                변수명 테이블명%ROWTYPE;
                
            - 하나의 테이블을 여러 컬럼의 값을 한꺼번에 저장할 수 있는 변수를 의미
            - 모든 컬럼을 조회하는 경우 사용하기 편리하다
*/
-- 출력기능 활성화
set serveroutput on;

-- 1) 일반 타입 변수의 선언 및 초기화
declare
    eid number;             -- 변수 선언
    ename varchar2(30);     
    pi constant number := 3.14;     -- 선언 및 초기화 
begin
    eid := 888;
    ename := '배장남';
--    pi := 3.15;                   -- constant로 선언한 상수이기 때문에 변경 불가능
    
    dbms_output.put_line('EID : ' || eid);
    dbms_output.put_line('ENAME : ' || ename);
    dbms_output.put_line('PI : ' || pi);
end;
/
-------------------------------------------------------------------------------------------------------
select emp_id,emp_name,salary
from employee
where emp_name = '&사원명';   -- &사원명의 경우를 대체 변수라 하고, 대체 변수 입력창이 나옴, 입력값으로 수행됨

--  2) 레퍼런스 타입 변수 선언 및 초기화
declare 
    eid employee.emp_id%type;
    ename employee.emp_name%type;
    sal employee.salary%type;
begin
    -- 사원명을 입력받아서 사원의 사번, 사원명, 급여정보를 각각 EID, ENAME, SAL 변수에 대입 후 출력
    select emp_id,emp_name,salary
    into eid, ename, sal               -- select와 매칭되는 개수가 같아야함
    from employee
    where emp_name = '&사원명';
    
    dbms_output.put_line('EID : ' || eid);
    dbms_output.put_line('ENANE : ' || ename);
    dbms_output.put_line('SALARY : ' || sal);
end;
/

--실습 문제
declare 
    eid employee.emp_id%type;
    ename employee.emp_name%type;
    jcode employee.job_code%type;
    dtitle department.dept_title%type;
    sal employee.salary%type;
begin
    select e.emp_id, e.emp_name, e.job_code, d.dept_title, e.salary
    into eid,ename, jcode, dtitle, sal
    from employee e
    join department d on ( e.dept_code = d.dept_id )
    where e.emp_id = '&사번';
    
    dbms_output.put_line('EID : ' || eid);
    dbms_output.put_line('ENANE : ' || ename);
    dbms_output.put_line('JCODE : ' || jcode);
    dbms_output.put_line('DTITLE : ' || dtitle);
    dbms_output.put_line('SALARY : ' || sal);
end;
/

------------------------------------------------------------------
--  3) row 타입 변수 선언 및 초기화
declare 
    emp employee%ROWTYPE;
begin
    select *
    into emp
    from employee
    where emp_id = '&사번';
    
    DBMS_OUTPUT.PUT_LINE('사번 : ' || EMP.EMP_ID);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || EMP.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('주민번호 : ' || EMP.EMP_NO);
    DBMS_OUTPUT.PUT_LINE('이메일 : ' || EMP.EMAIL);
    DBMS_OUTPUT.PUT_LINE('전화번호 : ' || EMP.PHONE);
    DBMS_OUTPUT.PUT_LINE('부서 코드 : ' || EMP.DEPT_CODE);
    DBMS_OUTPUT.PUT_LINE('직급 코드 : ' || EMP.JOB_CODE);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || TO_CHAR(EMP.SALARY, 'FM99,999,999'));
end;
/

