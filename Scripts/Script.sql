-- 회원
CREATE TABLE member (
	member_id        VARCHAR(50) NOT null, -- 회원 아이디
	member_pass      VARCHAR(50) NOT NULL, -- 회원 비번
	member_name      VARCHAR(50) NOT NULL, -- 회원 이름
	member_email     VARCHAR(50) NOT NULL, -- 회원 이메일
	member_startdate datetime    NOT null default now(),  -- 회원 가입일
	PRIMARY KEY (member_id)
);

-- 게시판
CREATE TABLE board (
	board_no        int      NOT null AUTO_increment, -- 게시물 번호
	member_id       VARCHAR(50)      not NULL,     -- 회원 아이디
	board_title     VARCHAR(100) NOT NULL, -- 게시물 제목
	board_count     int      default 0, -- 조회수
	board_startdate datetime     NOT null default now(),  -- 작성일자
	PRIMARY KEY (board_no)
);

-- 게시글 내용
create table content(
	board_no int not null,
	board_content text null,
	primary key(board_no)
);

-- 댓글
CREATE TABLE reply (
	reply_no        int       NOT null AUTO_increment, -- 댓글 번호
	board_no        int       NOT NULL, -- 게시물 번호
	member_id       VARCHAR(50)       NOT NULL, -- 회원 아이디
	reply_content   VARCHAR(1000) NOT NULL, -- 댓글 내용
	reply_startdate datetime      NOT null default now(),  -- 댓글일자
	PRIMARY KEY (reply_no)
);

-- 업로드
CREATE TABLE upload (
	upload_no   int          not null AUTO_increment,
	upload_file VARCHAR(200) NOT NULL, -- 업로드 파일
	board_no    int      NOT NULL, -- 게시물 번호
	upload_date datetime     NOT null default now(),  -- 업로드날짜
	primary key(upload_no)
);
drop table point;
-- 포인트장소
CREATE TABLE point (
	point_no      int      NOT null AUTO_increment, -- 포인트 번호
	member_id     VARCHAR(50)      not NULL,     -- 회원 번호
	point_file    VARCHAR(200) NULL,     -- 사진 파일
	point_where   VARCHAR(200) NOT NULL, -- 장소 
	point_title   VARCHAR(100) NOT NULL, -- 글 제목
	point_latiude  double         NULL, -- 위도
	point_hardness double         null, -- 경도
	point_count   int      default 0, -- 조회수
	point_date    datetime   not null default now(),      -- 글 날짜
	point_good int null,
	PRIMARY KEY (point_no)
);
-- 좋아요 컬럼추가
alter table point add point_good int null default '0';

create table pt_content(
	point_no int not null,
	point_content text null,
	primary key(point_no)
);

-- 포인트 댓글
CREATE TABLE point_reply (
	pr_no      int   NOT null AUTO_increment, -- 포인트댓글번호
	member_no  int   NOT NULL, -- 회원 번호
	point_no   int   NOT NULL, -- 포인트 번호
	pr_f       int   NULL,     -- 장소평점
	pr_s       int   NULL,     -- 어류평점
	pr_content TEXT      NULL,     -- 댓글 내용
	pr_date    TIMESTAMP not null default now(),  -- 댓글 일자
	primary key(pr_no)
);

-- 랭크
CREATE TABLE score (
	member_no int NOT NULL, -- 회원 번호
	point_no  int NOT null,  -- 포인트 번호
	primary key(member_no,point_no)
);

create table event(
	event_no int not null AUTO_increment, -- 행사번호
	event_date datetime not null, -- 행사 기간
	event_place varchar(100) not null, -- 행사 장소
	event_latiude double null, -- 행사 위도
	event_hardness double null, -- 행사 경도
	event_homepage varchar(100) not null, -- 홈페이지
	event_intro varchar(1000) not null, -- 행사 소개
	event_content varchar(1000) not null, -- 행사 내용
	event_title varchar(100) not null, -- 행사 타이틀
	primary key(event_no)
);

create table event_img(
	img_no int not null AUTO_increment, -- 행사 이미지 번호
	event_no int not null, -- 행사 번호
	img_file varchar(200) not null, -- 행사 이미지 파일
	primary key(img_no)
);

alter table reply add constraint fk_board
foreign key(board_no) references board(board_no);

alter table point_reply add constraint fk_point
foreign key(point_no) references point(point_no);

alter table score add constraint fk_member
foreign key(member_no) references member(member_no);

ALTER TABLE score add CONSTRAINT FK_point_TO_score 
FOREIGN KEY (point_no) REFERENCES point (point_no);

ALTER TABLE content add CONSTRAINT FK_board_TO_content 
FOREIGN KEY (board_no) REFERENCES board (board_no);


ALTER TABLE pt_content add CONSTRAINT FK_point_TO_pt_content
FOREIGN KEY (point_no) REFERENCES point (point_no);

drop table member;
drop table relply;
drop table board;
drop table upload;
drop table point_reply;
drop table point;
drop table score;

-- 샘플데이터
insert into member(member_id,member_pass,member_name,member_email,member_startdate)
values('osram21','1234','김성환','osram21@naver.com',now()),
('osram22','1234','김성환','osram22@naver.com',now()),
('osram23','1234','신진욱','osram23@naver.com',now()),
('osram24','1234','이승우','osram24@naver.com',now()),
('osram25','1234','설동훈','osram25@naver.com',now());

insert into board(member_no,board_title,board_count,board_startdate)
values(1,'글타이틀1',0,now()),
(2,'글타이틀2',0,now()),
(3,'글타이틀3',0,now()),
(4,'글타이틀4',0,now()),
(5,'글타이틀5',0,now());

insert into content(board_no,board_content)values
(1,'글쓴다1234'),(2,'글쓴다12'),(3,'글쓴다11'),(4,'글쓴다33'),(5,'글쓴다55');

select*from member;
select*from board;
select*from content;

-- 게시판 쿼리
select d.board_title, d.board_count, d.board_startdate,b.member_name,c.board_content 
from board d join member b on d.board_no = b.member_no join content c on d.board_no=c.board_no;

select *
from board d join content c on d.board_no = c.board_no where d.board_no = 1;

select * from board b join content c 
on b.board_no = c.board_no where b.board_no=1;

insert into board(board_title,member_id)
(select board_title,member_id from board);

select * from reply;
select*from member;

select * from member where member_id='test' and member_pass='1234';

select * from point;
select * from pt_content;

select*from point p join pt_content pt on p.point_no = pt.point_no