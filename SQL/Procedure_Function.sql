/*
    <procedure (프로시저)>
        PL/SQL문을 저장하는 객체
        필요할 때마다 복잡한 구문을 다시 입력할 필요 없이 간단하게 호출해서 실행결과를 얻을 수 있는 객체
        특정 로직을 처리하기만 하고 결과값을 반환하지는 않음
        
        [표현법]
            create procedure 프로시저명
            (
                매개변수 [in/out] 데이터 타입 [:=default값],
                매개변수 [in/out] 데이터 타입 [:=default값],
                ...
            )
            is [as]
                선언부
            begin
                실행부
            exception
                예외처리부
            end [프로시저명];
            /
            
        [실행방법]
            executable(exec) 프로시저명[(매개값1, 매개값2, ... )];
*/
-- 테스트용 테이블 생성
create table emp_dup 
as select * from employee;

-- 테스트 테이블의 데이터를 모두 삭제하는 프로시저 생성
create or replace procedure del_all_emp    -- create 했지만 해당 프로시저가 실행되는 것은 아님
is 
begin
    delete from emp_dup;
    
    commit;
end;
/

-- 프로시저를 관리하는 데이터 딕셔너리
select * from user_source;

--프로시저 호출
execute del_all_emp;            -- 두개다 프로시저 호출
exec del_all_emp;

-- 프로시저 삭제
drop procedure del_all_emp;

-----------------------------------------------------------------------------
/*
    1) 매개변수가 있는 프로시저
        프로시저 실행 시 매개변수로 인자값을 전달해야 한다.
    
    2) in/out 매개변수가 있는 프로시저
        in 매개변수 : 프로시저 내부에서 사용될 변수
        out 매개변수 : 프로시저 호출부(외부)에서 사용될 값을 담아줄 변수
*/

-- 1) 매개변수가 있는 프로시저
create or replace procedure del_emp_id
(
    p_emp_id employee.emp_id%type
)
is
begin
    delete from employee
    where emp_id = p_emp_id;
end;
/

-- 프로시저 실행 ( 매개변수가 있는 프로시저는 매개 값을 전달해야만 실행 됨)
exec del_emp_id('204');


-- 사용자가 입력한 값도 전달이 가능하다
exec emp_emp_id('&사번');

-- 2) in/out 매개변수가 있는 프로시저
create or replace procedure select_emp_id
(
    v_emp_id in employee.emp_id%type,
    v_emp_name out employee.emp_name%type,
    v_salary out employee.salary%type,
    v_bonus out employee.bonus%TYPE
)
is 
begin
    select emp_name,salary,bonus
    into v_emp_name, v_salary, v_bonus
    from employee
    where emp_id = v_emp_id;
end;
/

-- 바인드 변수 ( variable, var )
variable var_emp_name varchar2(30);     -- var 이나 variable이나 똑같이 바인드 변수 생성
var var_salary number;
var var_bonus number;

set autoprint on;   -- 바인드 변수에 변화가 생기면 자동으로 프린트 해주는 설정

-- 바인드 변수는 ':변수명' 형태로 참조 가능
exec select_emp_id('200', :var_emp_name, :var_salary, :var_bonus);

print var_emp_name;
print var_salary;
print var_bonus;


------------------------------------------------------------------------------------
/*
    <function>
        프로시저와 사용 용도가 비슷하지만
        프로시저와 다르게 out변수를 사용하지 않아도 실행 결과를 되돌려 받을 수 있다 (RETURN)
        
        [표현법]
            create function 함수명
            (
                매개변수 1 타입,
                매개변수 2 타입,
                ...
            )
            return 데이터타입
            is
                선언부
            begin
                실행부
                
                return 반환값;     -- 프로시저와 다르게 return 구문이 추가된다.
            exception
                예외처리부
            end [함수명];
            /
*/
-- 사번을 입력받아 해당 사원의 보너스를 포함하는 연봉을 계산하고 리턴하는 함수 생성
create or replace function bonus_calc
(
    v_emp_id employee.emp_id%type
)
return number 
is
    v_sal employee.salary%type;
    v_bonus employee.bonus%type;
begin
    select salary, nvl(bonus,0)
    into v_sal, v_bonus
    from employee
    where emp_id = v_emp_id;
    
    return (v_sal+(v_sal * v_bonus))*12;
end;
/

select * from user_source;

select bonus_calc(200) from dual;

select emp_id, salary, (salary + (salary * bonus)) * 12
from employee
where emp_id = 200;


----------------------------------------------------------------------------------
/*
    <cursor>
        SQL문의 처리 결과 ( 처리결과가 여러 행(ROW))를 담고 있는 객체이다
        커서 사용 시 여러 행으로 나타난 처리 결과에 순차적으로 접근이 가능하다
        
        [커서속성]
            커서명%notfound : 커서 영역에 남아있는 row 수가 없다면 true, 아니면 false
            커서명%found : 커서 영역에 남아있는 row 수가 한 개 이상일 경우 true, 아니면 false
            커서명%isopen : 커서가 open 상태인 경우 true, 아니면 false
            커서명%rowcount : SQL 처리 결과로 얻어온 행(row)의 수

        [사용 방법]
            1) cursor 커서명 is ..     : 커서 선언
            2) open 커서명;            : 커서 오픈
            3) fetch 커서명 into 변수, ... : 커서에서 데이터 추출 ( 한행씩 데이터를 가져온다)
            4) close 커서명            : 커서 닫기
        
        [표현법]
            cursor 커서명 is [select 문]
            
            open 커서명;
            fetch 커서명 into 변수;
            ...
            
            close 커서명;

*/
set serveroutput on;    -- output이 안되면 실행

-- 급여가 3000000 이상인 사원의 사번, 이름, 급여 출력(PL/SQL)
declare 
    eid employee.emp_id%type;
    ename employee.emp_name%type;
    sal employee.salary%type;
    
    -- 커서선언
    cursor c1 is
        select emp_id, emp_name, salary
        from employee
        where salary>3000000;
begin
    -- 커서오픈
    open c1;
    
    loop
        fetch c1 into eid, ename, sal;
        
        exit when c1%notfound;
        
        dbms_output.put_line(eid || ' ' || ename || ' ' || sal);
    end loop;
    
    close c1;
end;
/

-- 전체 부서에 대해 부서코드, 부서명, 지역조회 (procedure)
create or replace procedure cursor_dept
is
    v_dept department%rowtype;
    
    cursor c1 is
        select * from department;   -- 커서를 생성한다고 실행되는것은 아님 
begin
    open c1;
    
    loop
        fetch c1 into v_dept.dept_id, v_dept.dept_title, v_dept.location_id;
        
        exit when c1%notfound;
        
        dbms_output.put_line(v_dept.dept_id || ' ' || v_dept.dept_title || ' ' || v_dept.location_id);
    end loop;
    
    close c1;
end;
/

exec cursor_dept;       


-- for in loop를 이용한 커서 사용
create or replace procedure cursor_dept     -- 프로시저 생성
is
    v_dept department%rowtype;
begin
    for v_dept in (select * from department)
    loop
        dbms_output.put_line(v_dept.dept_id || ' ' || v_dept.dept_title || ' ' || v_dept.location_id);
    end loop;
end;
/

exec surosr_dept;       -- 프로시저 호출
