/*
    <sequence>
        정수값을 순차적으로 생성하는 역할을 하는 객체이다
        
    <sequence 생성>
        [표현법]
            create sequence 시퀀스명
            [start with 숫자]
            [increment by 숫자]
            [maxvalue 숫자]
            [minvalue 숫자]
            [cycle | nocycle]
            [cache 바이트크기 | nocache];               -- 캐시메모리 , 기본값 20 바이트
            
        [사용 구문]
            시퀀스명.currval : 현재 시퀀스의 값
            시퀀스명.nextval : 시퀀스 값을 증가시키고 증가된 시퀀스 값 ( 기존 시퀀스 값에서 increment 값 만큼 증가된 값 )
            
        * 캐시메모리
            - 미리 다음 값들을 생성해서 저장해둔다.
            - 매번 호출할 때마다 시퀀스 값을 새로 생성하는 것이 아닌 캐시 메모리 공간에 미리 생성된 값들을 사용한다
*/
create sequence seq_empno
start with 300      -- 시작 시퀀스 값
increment by 5      -- 증가되는 시퀀스 값
maxvalue 310        -- 최대 시퀀스 값
nocycle
nocache;

-- 현재 계정이 가지고 있는 시퀀스들에 대한 정보를 조회하는 데이터 딕셔너리
select * from user_sequences;

select seq_empno.nextval from dual;     -- 시퀀스를 처음 생성한 후 currval로 호출 불가능, nextval을 한번이라도 수행해야함
select seq_empno.currval from dual;

-- 지정한 maxvalue 값을 초과하면 오류가 발생한다

/*
    <sequence 수정>
        [표현법]
            alter sequence 시퀀스명
            [increment by 숫자]
            [maxvalue 숫자]
            [minvalue 숫자]
            [cycle | nocycle]
            [cache 바이트 크기 | nocache]
            
        
        start with값은 변경 불가능
*/
alter sequence seq_empno
--start with 200;   -- 구문 오류 발생
increment by 10
maxvalue 400;

select * from user_sequences;

select seq_empno.currval from dual;

/*
    <sequence 삭제>
        drop sequence 시퀀스명;
*/
drop sequence seq_empno;

-------------------------------------------------------------------------------
-- 매번 새로운 사번이 생성되는 시퀀스 생성
create sequence seq_eid
start with 910;

insert into employee(emp_id, emp_name, emp_no, job_code)    
values(seq_eid.nextval, '홍길동', '800525-1234567', 'J7');

insert into employee(emp_id, emp_name, emp_no, job_code)
values(seq_eid.nextval, '전우치', '780418-1234567', 'J7');

select emp_name,emp_id from employee;