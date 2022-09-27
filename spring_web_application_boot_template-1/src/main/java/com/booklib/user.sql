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