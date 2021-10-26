/*
    <TCL ( Transcation Control Language) >
        트랜잭션을 제어하는 언어이다
        
        * 트랜잭션
            - 하나의 논리적인 작업 단위를 트랜잭션이라고 한다
            ATM 에서 현금 출금
                1. 카드 삽입
                2. 메뉴 선택
                3. 금액 확인 및 인증
                4. 실제 계좌에서 금액만큼 차감
                5. 실제 현금 인출
                6. 완료
            - 각각의 작업들을 묶어서 하나의 작업 단위로 만들어 버리는 것을 트랜잭션이라고 한다
            - 하나의 트랜잭션으로 이루어진 작업들은 반드시 한꺼번에 완료가 되어야 하며, 그렇지 않을 경우 한꺼번에 취소되어야 한다
            - 데이터의 변경 사항 (DML(insert,update,delete))들을 묶어서 하나에 트랜잭션에 담아 처리한다
            - commit( 트랜잭션 종료 처리 후 저장 ), rollback( 트랜잭션 취소 ), savepoint( 임시저장 )를 통해서 트랜잭션을 제어한다.
*/  
create table emp_01
as select e.emp_id, e.emp_name, d.dept_title
    from employee e
    left outer join department d on (e.dept_code = d.dept_id);
    
-- emp_01 테이블에서 emp_id가 900, 901인 사원 지우기
delete from emp_01
where emp_id in (900,901);

savepoint sp;

delete from emp_01
where emp_id = 200;

rollback to sp;     -- savepoint 시점으로 돌아감

rollback;           -- commit 시점으로 돌아감

--emp_id가 200인 사원 지우기
delete from emp_id
where emp_id = 200;

--DDL 구문을 실행하는 순간 기존에 메모리 버퍼에 있던 변경사항들이 무조건 DB에 반영된다 ( commit 시켜버린다 )
create table test(
    tid number
);
    
rollback;
