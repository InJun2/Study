/*
    <함수>
    컬럼값을 읽어서 계산한 결과를 반환
        - 단일행 함수 : N개의 값을 읽어서 N개의 값을 리턴 ( 매 행 함수 실행 -> 결과 반환 )
        - 그룹함수 : N개의 값을 읽어서 1개의 결과를 리턴 ( 하나의 그룹별로 함수 실행 -> 결과 반환 ) 
    select 절에 단일행 함수와 그룹 함수는 함께 사용하지 못함 ( 결과 행의 개수가 다르기 때문 )
    
    함수를 기술할 수 있는 위치는 select, where, order by, group by, having 절에 기술 할 수 있음
*/

----------------------------------------단일행 함수--------------------------------------------------
/*
    문자 관련 함수
        1) length / lengthb
         - length(컬럼|'문자값') : 글자수 반환
         - lengthb(컬럼|'문자값') : 글자의 바이트 수 반환
            한글 한글자 - > 3byte,   영문자, 숫자, 특수문자 한글자 -> 1byte
*/
select length('오라클'), lengthb('오라클')
from dual;

-- * dual 테이블   : SYS 사용자가 소유하는 테이블, SYS 사용자가 소유하지만 모든 사용자가 접근 가능, 한 행,
--                  한 컬럼을 가지고 있는 더미 테이블, 사용자가 함수(계산)을 사용할 때 임시로 사용하는 테이블
select * from dual;

select emp_name, length(emp_name), lengthb(emp_name)
from employee;

/*
    2) instr
        - instr(컬럼|'문자값','문자'[, POSITION [, OCCURRENCE]])
        - 지정된 위치로부터 지정된 숫자 번째로 나타나는 문자의 시작 위치를 반환한다
*/
select instr('AABAACAABBAA','B') from dual;    -- 3번째 자리의 B의 위치값 출력 ( 앞에서 부터 B를 찾음 )
select instr('AABAACAABBAA','B',1) from dual;  -- 3번째 자리의 B의 위치값 출력
select instr('AABAACAABBAA','B',-1) from dual; -- 10번째 자리의 B의 위치값 출력 ( 뒤에서 부터 B를 찾음 )
select instr('AABAACAABBAA','B', 1, 2) from dual; -- 9번째 자리의 B의 위치값 출력 ( 앞에서부터 두번째 B를 찾음 )

-- @위치와 2번째 S의 위치 찾기 ( 왼쪽으에서 찾도록 )
select email, instr(email,'@'), instr(email,'s',1,2) 
from employee;

/*
     3) lpad / rpad
        - LPAD/RPAD(컬럼|'문자값', 길이(바이트) [, '덧붙이려고 하는 문자'])
        - 제시된 컬럼|'문자열'에 임의의 문자를 왼쪽 또는 오른쪽에 덧붙여 최종 N 길이 만큼의 문자열을 반환
        - 문자에 대해 통일감 있게 표시하고자 할 때 사용한다
        
*/
-- 20만큼의 길이 중 email 값은 오른쪽으로 정렬하고 공백을 왼쪽으로 채운다.
select lpad(email, 20) from employee;
-- 20만큼의 길이 중 email 값은 오른쪽으로 정렬하고 공백을 #으로 채운다.
select lpad(email, 20, '#') from employee;
-- 20만큼의 길이 중 email 값은 왼쪽으로 정렬하고 공백을 #으로 채운다.
select rpad(email, 20, '#') from employee;

/*
    4) ltrim/ rtrim
        - ltrim/rtrim(컬럼|'문자값'[, '제거하고자 하는 문자'])
        - 문자열의 왼쪽 혹은 오른쪽에서 제거하고자 하는 문자들을 찾아서 제거한 결과를 반환
        - 제거하고자 하는 문자값을 생략 시 기본값으로 공백을 제거한다.
*/
select ltrim('      strim   ') from dual; -- 기본으로는 공백제거
select rtrim('strim         ') from dual;
select ltrim('0001234560','0') from dual;
select ltrim('  123123kh','312') from dual;
select rtrim('00012300004560000',  '0') from dual;

select rtrim(ltrim('    strim       ')) from dual;

/*
     5) trim
        - trim(['제거하고자하는 문자값' from] 컬럼|'문자값')
        - 문자값 앞/뒤/양쪽에 있는 지정한 문자를 제거한 나머지를 반환
        - 제거하고자 하는 문자값을 생략 시 기본적으로 양쪽에 있는 공백을 제거
*/
select trim('   strim   ') from dual;   -- 기본으로는 공백제거
select trim('z' from 'zzzstrimzzz') from dual;
select trim(both 'z' from 'zzzstrimzzz') from dual;     -- 양쪽제거
select trim(leading 'z' from 'zzzstrimzzz') from dual;  -- 왼쪽제거
select trim(trailing 'z' from 'zzzstrimzzz') from dual; -- 오른쪽제거

/*
     6) substr
        - substr(컬럼|'문자값', position [, length])
        - 문자데이터에서 지정한 개수만큼의 문자열을 추출해서 반환
*/
select substr('showmethemoney',4) from dual;    -- 길이 따로 적지 않으면 끝까지 반환
select substr('showmethemoney', 5, 10) from dual;
select substr('showmethemoney',-10, 5) from dual;   -- 음수면 뒤에서부터 10번째
select substr('쇼미더머니',-4,2) from dual;

select emp_name as "사원명", substr(emp_no,8,1) as "성별코드"  -- 남자일경우만 주민번호 8번쨰의 성별부분 추출
from employee
where substr(emp_no,8,1) = '1';

/*
     7) lower / upper / initcap ( 컬럼 | '문자값' )
        - lower : 모두 소문자로 변경한다.
        - upper : 모두 대문자료 변경한다.
        - initcap : 단어 앞 글자마다 대문자로 변경한다.
*/

select lower('welcome to my world!') from dual;
select upper('welcome to my world!') from dual;
select initcap('welcome to my world!') from dual;

/*
     8) concat(컬럼|'문자값', 컬럼|'문자값')
        - 문자열 두개를 전달 받아서 하나로 합친 후 결과를 반환한다 , 그러나 문자열 3개 이상은 불가능
*/

select concat('가나다라','ABCD') from dual;     -- ||을 사용한 것과 동일한 결과값

/*
     9) replace
         - replace(컬럼|'문자열', 변경하려고 하는 문자, 변경하고자 하는 문자 )
         - 컬럼 또는 문자값에서 "변경하려는 문자"를 "변경하고자하는 문자"로 변경한다.
*/
select replace('서울시 강남구 역삼동', '역삼동', '삼성동') from dual;

select emp_name, replace(email, 'kh.or.kr','gmail.com')
from employee;
-----------------------------------------------------------문제
--1. employee 테이블 주민등록번호 첫 번째 자리부터 성별까지를 추출한 결과값 오른쪽에 * 문자 채워서 조회
select emp_name as "사원명", rpad(substr(emp_no,1,8), 14, '*') as "주민번호"
from employee;

--2. employee 테이블에서 사원명, 이메일, 아이디(이메일에서 '@'  앞의 문자 값만 출력 조회
select emp_name, substr(email, 1, instr(email,'@') -1)
from employee;


---------------------------------------숫자 함수---------------------------------- 
/*
    <숫자 관련 함수>
         1) abs     : 절대값을 구하는 함수
         2) mod     : 두수를 나눈 나머지를 반환해 주는 함수 ( 자바의 % )
         3) round   : 기본값 0(.) 기준으로 양수(소수점 기준으로 오른쪽)와 음수(소수점 기준으로 왼쪽)로 반올림
         4) ceil    : 소수점 기준으로 올림해주는 함수 ( 특정 자리수에서 올림 불가능 )
         5) floor   : 소수점 기준으로 버림해주는 함수
         6) trunc   : 위치를 지정하여 버림이 가능한 함수, 기본값 0(.) 기준으로 양수(소수점 기준으로 오른쪽)와 음수(소수점 기준으로 왼쪽)로 버림
*/

select abs(-10.9) from dual;

select mod(10,3) from dual;

select round(123.456) from dual;
select round(123.456, -2) from dual;
select round(123.456, 2) from dual;

select ceil(123.456) from dual;

select floor(123.456) from dual;

select trunc(123.456) from dual;
select trunc(123.456, 1) from dual;
select trunc(123.456, -2) from dual;
