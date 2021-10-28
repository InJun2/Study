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

-------------------------------------------------------------------------------------
/*
    <PL/SQL 실행부 ( executable section )
        1) 선택문
            1-1) 단일 IF
                [표현법]
                    IF 조건식 THEN
                        실행문장
                    END IF;
                    
            1-2) IF ~ ELSE 구문
                [표현법]
                    if 조건식 then
                        실행문장
                    else
                        실행문장
                    end if;
                    
            1-3) if ~ elsif ~ else 구문
                [표현법]
                    if 조건식 then
                        실행 문장
                    elsif 조건식 then      -- 여러개 입력 가능
                        실행 문장
                    else
                        실행문장
                    end if;
            
            1-4) case 구문
                [표현법]
                    case 비교 대상
                        when 비교값1 then 결과값1
                        when 비교값2 then 결과값2
                        ...
                        [else 결과값]
                    end;

-------------------------------------------------------------------------------------
        2) 반복문
            2-1) basic loop 구문
                [표현법]
                    loop
                        반복적으로 실행시킬 구문
                        
                        [반복문을 빠져나갈 조건문 작성]
                        1) if 조건식 then
                                exit;
                            end if
                            
                        2) exit when 조건식;
                    end loop;
                    
            2-2) while loop
                [표현법]
                    while 조건식
                    loop
                        반복적으로 실행할 구문;
                    end loop;
            
            2-3) for loop
                [표현법]
                    for 변수 in [reverse] 초기값..최종값        ( .. 가 2개여야함 )
                    loop 
                        반복적으로 실행할 구문;
                    end loop;
                    
            
*/
-- 사번을 입력받은 후 해당 사원의 사번, 이름, 급여, 보너스를 출력
-- 단, 보너스를 받지 않는 사원은 보너스 출력 전에 '보너스를 지급받지 않는 사원입니다' 라는 문구를 출력한다
declare 
    eid employee.emp_id%type;
    ename employee.emp_name%type;
    sal employee.salary%type;
    bonus employee.bonus%type;
begin
    select emp_id, emp_name, salary,bonus
    into eid,ename,sal,bonus
    from employee
    where emp_id='&사번';
    
    dbms_output.put_line('사번 : ' || eid);
    dbms_output.put_line('이름 : ' || ename);
    dbms_output.put_line('급여 : ' || sal);
    
     if ( bonus is null ) then
        dbms_output.put_line('보너스를 지급받지 않는 사원입니다');
    end if;
    
    dbms_output.put_line('보너스 : ' || nvl(bonus,0));
end;
/


-- if else 구문
declare 
    eid employee.emp_id%type;
    ename employee.emp_name%type;
    sal employee.salary%type;
    bonus employee.bonus%type;
begin
    select emp_id, emp_name, salary,bonus
    into eid,ename,sal,bonus
    from employee
    where emp_id='&사번';
    
    dbms_output.put_line('사번 : ' || eid);
    dbms_output.put_line('이름 : ' || ename);
    dbms_output.put_line('급여 : ' || sal);
    
     if ( bonus is null ) then
        dbms_output.put_line('보너스를 지급받지 않는 사원입니다');
    else 
        dbms_output.put_line('보너스 : ' || nvl(bonus,0));
    end if;
end;
/

-- if ~ elsif ~ else 구문
-- 사용자에게 점수를 입력받아 score 변수에 저장한 후 학점은 입력된 점수에 따라 grade 변수에 저장한다
-- 90점이상은 'A', 80점 이상은 'B', 70점이상은 'C', 60점이상은 'D', 60점 미만은 'F'
-- 출력은 '당신의 점수는 95점이고, 학점은 A학점입니다' 와 같이 출력
declare 
    score number;
    grade char(1);
begin
    score := '&점수';
    
    
    if (score >=90) then
        grade := 'A';
    elsif (score >=80) then
        grade := 'B';
    elsif (score >=70) then
        grade := 'C';
    elsif (score >=60) then
        grade := 'd';
    else
        grade := 'F';
    end if;
    
    dbms_output.put_line('당신의 점수는 ' || score || '점 이고, 학점은 ' || grade || ' 학점 입니다');
end;
/

-- case 구문
-- 사번을 입력받은 후에 사원의 모든 컬럼 데이터를 emp에 대입하고 dept_code에 알맞는 부서를 출력한다
declare 
    emp employee%rowtype;
    dname varchar(30);
begin 
    select *
    into emp
    from employee
    where emp_id = '&사번';
    
    dname := case emp.dept_code
            when 'D1' then '인사관리부'
            when 'D2' then '회계관리부'
            when 'D3' then '마케팅부'
            when 'D4' then '국내영업부'
            when 'D5' then '해외영업1부'
            when 'D6' then '해외영업2부'
            when 'D7' then '해외영업3부'
            when 'D8' then '기술지원부'
            when 'D9' then '총무부'
        end;

    dbms_output.put_line('사번 : ' || emp.emp_id);
    dbms_output.put_line('이름 : ' || emp.emp_name);
    dbms_output.put_line('부서코드 : ' || emp.dept_code);
    dbms_output.put_line('부서명 : ' || dname);
end;
/

--------------------------------------------------------------------------------------------
-- 2) 반복문
-- 1 ~ 5 까지 순차적으로 1씩 증가하는 값을 출력
declare 
    num number :=1;
begin
    loop
        dbms_output.put_line(num);
        
        num := num+1;
        
--        if num > 5 then
--            exit;
--        end if;
        
        exit when num > 5 ;
    end loop;
end;
/


-- 2-2) while
declare 
    num number :=1;
begin
    while num <=5
    loop
        dbms_output.put_line(num);
        
        num := num+1;
    end loop;
end;
/

-- 2-3) for loop
begin 
    for num in 1..5
    loop
        dbms_output.put_line(num);
    end loop;
end;
/

-- 구구단 출력
begin
    for dan in 2..9
    loop
        if (mod(dan,2) = 0) then        -- 2로 나누었을때 0이면 실행
        for dan2 in 1..9
        loop
            dbms_output.put_line(dan || ' X ' || dan2 || ' = ' || dan * dan2);
        end loop;
        end if;
        
    end loop;
end;
/

-- 반복문 (for 구문)을 이용한 데이터 삽입
create table test(
    num number,
    create_date date
);

select * from test;

-- test 테이블에 1~10까지의 값중 짝수인 행을 insert 하는 PL/SQL 작성
begin 
    for num in 1..10
    loop
            insert into test values(num, sysdate);
            
            if(mod(num,2) = 0) then
                commit;
            else
                rollback;
            end if;
    end loop;
end;
/

--------------------------------------------------------------------------------------------
/*
    <PL/SQL 예외처리부 ( exception section )
        예외란 실행 중 발생하는 오류를 뜻하고 PL/SQL 문에서 발생한 예외를 예외처리부에서 코드적으로 처리가 가능하다.
        
        [표현법]
            declare
                ...
            begin
                ...
            exception
                when 예외명1 then 예외처리구문 1;
                when 예외명1 then 예외처리구문 2;
                ...
                when others then 예외처리구문;    -- 위에 기술되지 않은 예외에 포함되지 않는 기타 예외
            
        * 오라클에서 미리 정의되어 있는 예외
            - no_data_found : select 문의 수행 결과가 한 행도 없을 경우 발생한다
            - too_many_rows : 한 행이 리턴 되어야 하는데 select 문에서 여러 개의 행을 리턴할 때 발생한다
            - zero_divide : 숫자를 0으로 나눌 때 발생한다
            - dup_val_on_index : unique 제약 조건을 가진 컬럼에 중복된 데이터가 insert 될 때 발생한다.
*/
-- 사용자가 입력한 수로 나눗셈 연산
declare 
    result number;
begin
    result := 10 / '&숫자';               -- 0으로 나눈다고 할때 오류 발생
    
    dbms_output.put_line('결과 : ' || result);
exception 
    when zero_divide then dbms_output.put_line('0으로는 나눌수 없습니다');
end;

-- 너무 많은 행이 조회가 되었을 때
declare
    eid employee.emp_id%type;
    ename employee.emp_name%type;
begin
    select emp_id, emp_name
    into eid, ename
    from employee
    where manager_id = '&사수번호';     -- 데이터가 없다면 no_data_found, 여러 결과가 나오면 too_many_rows 에러
    
    dbms_output.put_line('사번 : ' || eid);
    dbms_output.put_line('사원명 : ' || ename);
    
    exception 
        when no_data_found then dbms_output.put_line('해당 데이터가 없습니다');
        when too_many_rows then dbms_output.put_line('너무 많은 행이 조회되었습니다');
        when others then dbms_output.put_line('에러가 발생했습니다');        -- 기술한 예외에 포함되지 않는 기타 예외
end;
/
