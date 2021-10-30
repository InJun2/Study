/*
    <trigger>
        테이블이 insert, update, delete 등 DML 구문에 의해서 변경될 경우
        자동으로 실행될 내용을 정의해놓는 객체이다.
        
        * 트리거의 종류
            1) SQL 문의 실행 시기에 따른 분류
                - before trigger : 해당 SQL 문장 실행 전에 트리거를 실행한다
                - after trigger : 해당 SQL 문장 실행 후에 트리거를 실행한다
            
            2) SQL 문에 의해 영향을 받는 행에 따른 분류
                - 문장 트리거 : 해당 SQL 문에 한번만 트리거를 실행한다
                - 행 트리거 : 해당 SQL문에 영향을 받는 행마다 트리거를 실행한다.  ( [for each row] 여부 )
            
            [표현법]
                create or replace trigger 트리거명
                before|after insert|update|delete on 테이블명
                [for each row]
                declare
                    선언부
                begin
                    실행부
                exception
                     예외처리부
                end;
                /
    
*/
-- 문장 트리거
create or replace trigger trg_01
after update on employee
begin
    dbms_output.put_line('업데이트 실행');
end;
/

-- 행 트리거 
create or replace trigger trg_02
after update on employee
for each row
begin
    dbms_output.put_line('변경 전 : ' || :old.dept_code || ' 변경 후 : ' || :new.dept_code); 
end;
/

update employee
set dept_code = 'D1'
where dept_code = 'D9';

------------------------------------------------------------------------------------------
-- 상품 입고, 출고 관련 예시
-- 1. 상품에 대한 데이터를 보관할 테이블 ( product )
create table product (
    pcode number primary key,
    pname varchar2(30),
    brand varchar2(30),
    price number,
    stock number default 0
);

-- 상품 코드가 중복되지 않게 새로운 번호를 발생하는 시퀀스 객체
create sequence seq_pcode;

insert into product values(seq_pcode.nextval, 'z플립', '삼성', 1500000, default);
insert into product values(seq_pcode.nextval, '아이폰13', '애플', 1800000, default);

select * from product;

-- 2. 상품 입출고 상세 이력을 보관할 테이블 ( prodetail )
create table prodetail(
    dcode number primary key,
    pdate date,
    amount number,
    status varchar2(10) check(status in ('입고', '출고')),
    pcode number,
    foreign key(pcode) references product
);

create sequence seq_dcode;

-- 1 번 상품이 오늘 날짜로 10개 입고
insert into prodetail values(seq_dcode.nextval, sysdate, 10, '입고', 1);

select * from prodetail;       -- 상품이 들어가면 product 테이블에 stock에 개수가 추가되도록 업데이트 해야함

-- 2번 상품이 오늘 날짜로 20개 입고
insert into prodetail values(seq_dcode.nextval, sysdate, 20, '입고', 2);

-- 2번 상품이 오늘 날짜로 5개가 출고
insert into prodetail values(seq_dcode.nextval, sysdate, 5, '출고', 2);

-- prodetail 테이블에 데이터 삽입 시 product 테이블에 재고 수량이 업데이트 되도록 트리거를 생성한다
create or replace trigger trg_pro_stock
after insert on prodetail
for each row
begin 
    dbms_output.put_line(:new.status || ', ' || :new.amount || ', ' || :new.pcode);
    
    -- 상품이 입고된 경우
    if(:new.status ='입고') then
        update product
        set stock = stock + :new.amount
        where pcode = :new.pcode;
    elsif(:new.status = '출고') then
        update product
        set stock = stock - :new.amount
        where pcode = :new.pcode;
    end if;
end;
/
