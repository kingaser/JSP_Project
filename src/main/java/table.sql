create sequence member_seq
start with 1 increment by 1;

create sequence product_seq
start with 1 increment by 1;

create sequence purchase_seq
start with 1 increment by 1;

create sequence reply_seq
start with 1 increment by 1;

create sequence basket_seq
start with 1 increment by 1;


create table member(
	memberId number primary key,
	username varchar(20) unique,
	password varchar(20) not null,
	address varchar(50) not null,
	phoneNumber number not null,
	role varchar(10) not null	
);

create table product(
	productId number primary key,
	title varchar(30) unique,
	author varchar(20) not null,
	content clob not null,
	price number not null,
	quantity number not null,
	image varchar(20)
);

create table purchase(
	purchaseId number primary key,
	p_memberId number references member(memberId),
	title varchar(30) not null,
	price number not null,
	quantity number not null
);

create table reply(
	replyId number primary key,
	r_productId number references product(productId),
	r_memberId number references member(memberId),
	content clob
);

create table basket(
	basketId number primary key,
	b_productId number references product(productId),
	b_memberId number references member(memberId),
	title varchar(30) not null,
	price number not null,
	quantity number
);


commit;
rollback;

drop table basket;
drop table reply;
drop table purchase;
drop table product;
drop table member;