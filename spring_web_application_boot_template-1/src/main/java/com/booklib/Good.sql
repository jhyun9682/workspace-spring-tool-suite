/*분야 번호 검색*/
select *
from book b join book_category bc
on b.category_no =bc.category_no
where bc.category_no=100;

select  b.book_no, b.isbn, b.book_title,b.book_author,b.book_publisher,b.book_image, bc.category_no,bc.category_name 
from book b join book_category bc
on b.category_no =bc.category_no
where bc.category_no=100;

/*분야 랜덤 추출*/
select * from book sample(10) where category_no=100;

/*분야 랜덤 추출 수량고정*/
select * from (select * from book where category_no=100
order by dbms_random.value) where rownum < 11;

/*분야 랜덤 추출 수량고정 조건추가*/
select * from 
(select b.book_no, b.isbn, b.book_title,b.book_author,b.book_publisher,b.book_image, bc.category_no,bc.category_name 
from book b join book_category bc
on b.category_no =bc.category_no
where bc.category_no=100
order by dbms_random.value)
where rownum < 11;

select * from 
(select b.book_no, b.isbn, b.book_title,b.book_author,b.book_publisher,b.book_image, bc.category_no,bc.category_name 
from book b join book_category bc on b.category_no =bc.category_no where bc.category_no=? order by dbms_random.value) 
where rownum < 11;

select * from book b, book_category bc
where b.category_no=bc.category_no
order by b.category_no;

select * from book, book_category order by book.category_no;

/*분야검색_이름명*/
select b.*,bc.category_name from book b
left join  book_category bc
on b.category_no=bc.category_no
 where bc.category_name like '소설%';

select b.*,bc.category_name from book b left join  book_category bc on b.category_no=bc.category_no  where bc.category_name='만화';

select b.*,bc.category_name from book b left join  book_category bc 
on b.category_no=bc.category_no
where book_title like '정신%' or book_author like '' or bc.category_name like '' or book_publisher like '';

select b.*,bc.category_name from book b left join  book_category bc on b.category_no=bc.category_no
where book_title like '' or book_author like '' or bc.category_name like '' or book_publisher like '';
