/*USER_INSERT 회원가입*/
insert into user_info(USER_ID,USER_NAME,USER_PASSWORD,CATEGORY_NO) values ('abc','가나다',9999,200);

/*USER_UPDATE 정보수정*/
update user_info set USER_PASSWORD=8888, USER_PHONE=01099998888, USER_EMAIL='abc@naver.com', USER_ADDRESS='서울 강남구' where USER_ID='abc';

/*USER_DELETE_BY_ID 회원탈퇴*/
delete from user_info where user_id='abc';

/*USER_SELECT_ALL 회원검색*/
select * from user_info;

/*USER_SELECT_BY_ID 회원아이디검색*/
select * from user_info where user_id='yeji';

select * from user_info where user_id='abc';

/*대여권수 제한*/



 /*분야 랜덤 추출 수량고정 조건추가*/
select * from 
(select b.book_no, b.isbn, b.book_title,b.book_author,b.book_publisher,b.book_image, bc.category_no,bc.category_name 
from book b join book_category bc
on b.category_no =bc.category_no
where bc.category_no=100
order by dbms_random.value)
where rownum < 11;

select * from (select b.book_no, b.isbn, b.book_title,b.book_author,b.book_publisher,b.book_image, bc.category_no,bc.category_name from book b join book_category bc on b.category_no =bc.category_no where bc.category_no=? order by dbms_random.value) where rownum < 11;

 /**분야 번호 검색_중복 제거 필요*/
select *
from book b join book_category bc
on b.category_no =bc.category_no
where bc.category_no=100;

select *
from book b join (select DISTINCT category_name from book_category) bc
on b.category_no=bc.category_no
where bc.category_no=100 ;

select * from book b join book_category bc on b.category_no =bc.category_no where bc.category_no=100;

select  b.book_no, b.isbn, b.book_title,b.book_author,b.book_publisher,b.book_image, bc.category_no,bc.category_name 
from book b join book_category bc
on b.category_no =bc.category_no
where bc.category_no=100;

/*분야 랜덤 추출*/
select * from book sample(10) where category_no=100;

/*분야 랜덤 추출 수량고정*/
select * from (select * from book where category_no=100
order by dbms_random.value) where rownum < 11;

/*제목검색*/
select * from book where book_title like '축구 아나토미';

/*아이디 중복체크*/
select count(*) cnt from user_info where user_id='yeji';

/*이메일 중복체크*/
select count(*) cnt from user_info where USER_EMAIL='so@naver.com';

/*전화번호 중복체크*/
select count(*) cnt from user_info where USER_PHONE='01025894567';

/*아이디 찾기*/
select * from user_info where USER_NAME='이정현' and USER_PHONE='01012345678';

/*비밀번호 찾기*/
select * from user_info where user_id='woohyuk' and USER_EMAIL='woohyuk@naver.com';

UPDATE book SET book_rental_cnt = book_rental_cnt + 1 WHERE book_no = 10;