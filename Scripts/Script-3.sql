select * from point_reply;

select point_no, round(avg(pr_f),1)from point_reply 
		where point_no=2
		group by point_no;
		
		select point_no, round(avg(pr_f),1)from point_reply 
		group by point_no;

-- point 평균 컬럼 추가
alter table point add prfavg double default 0;
alter table point add prsavg double default 0;

select* from point;

select point_no, round(avg(prfavg),1)from point 
where point_no = 2
group by point_no;

update point
set prfavg = 1.1
where point_no = 2;


-- 컬럼삭제 point 업로드 테이블 생성
alter table point drop point_file;

select*from member;
select*from point;
select*from pt_content;
select*from point_upload;

select*from point p join pt_content pt join point_upload pUp on p.point_no = pt.point_no = pUp.point_no;

select*from point p join pt_content pt  on p.point_no = pt.point_no
join point_upload pUp on p.point_no = pUp.point_no;

p.point_no 

select*from point p join point_upload pl on p.point_no=pl.point_no;