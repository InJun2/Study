use exam;

select * from board_seq;
select * from board where board_deleted='N';

drop table board_seq;
drop table board;

create table board_seq(
	seq int default 0
);

insert into board_seq values ();

update board_seq set seq =
	(
	select seq +1 from 
		(
			select seq 
            from board_seq
		)tmp
);

create table board(
	board_no int primary key,
    board_title varchar(40) not null,
    board_content varchar(2000) not null,
    board_writer varchar(20) not null,
    board_date date default (sysdate()),
    board_deleted char(1) check ( board_deleted in ('Y', 'N')) default('N')
);

insert into board(board_no, board_title, board_content, board_writer, board_date, board_deleted ) 
	values ( (select seq from board_seq) , 'title', 'contents', 'writer', sysdate(), 'N' ); 
    
    
    
    create table board(
	board_no int primary key,
    board_title varchar(40) not null,
    board_content varchar(2000) not null,
    board_writer varchar(20) not null,
    board_date date default (sysdate()),
    board_deleted char(1) check ( board_deleted in ('Y', 'N')) default('N')
);


insert into board values (10300, 'asdfasdfsda', 'fsadfsdafsdafa', '333', '2022-04-30', 'N' );
insert into board values (10301, 'asdfasdfsda', 'fsadfsdafsdafa', '333', '2022-12-30', 'N' );

commit;

desc board;


select to_char(board_date, 'YYYY-MM-DD HH24:MI:SS') from board;