<<<<<<< HEAD
create sequence memberId
start with 1 increment by 1;

create sequence productId
start with 1 increment by 1;

create sequence purchaseId
start with 1 increment by 1;

create sequence replyId
start with 1 increment by 1;

create sequence basketId
start with 1 increment by 1;

--member
create table member( 
	memberId number primary key,
	username varchar2(20) unique,
	passwd varchar2(20) not null,
	address varchar2(50) not null,
	tel varchar2(20) not null,
	role varchar2(10) not null	
);

--product
create table product(
	productId number primary key,
	title varchar2(30) unique,
	author varchar2(20) not null,
	productcontent clob,
	price varchar2(20) not null,
	quantity varchar2(20) not null,
	image varchar2(200)
);

--basket
create table basket(
	basketId number primary key,
    b_memberId number,
	b_productId number,
    constraint fk_b_memberId foreign key(b_memberId) references member(memberId) on delete cascade,
    constraint fk_b_productId foreign key(b_productId) references product(productId) on delete cascade
);

--order
create table purchase(
	purchaseId number primary key,
    p_memberId number,
	title varchar2(30) not null,
	price varchar2(20) not null,
	quantity varchar2(20) not null,
    constraint fk_p_memberId foreign key(p_memberId) references member(memberId) on delete cascade
);

--comment
create table reply(
	replyId number primary key,
	r_memberId number,
	r_productId number,
	replycontent clob,
    constraint fk_r_memberId foreign key(r_memberId) references member(memberId) on delete cascade,
    constraint fk_r_productId foreign key(r_productId) references product(productId) on delete cascade
);

select * from (select * from member m left join reply r on m.memberId=r.r_memberId order by m.username asc) a left join product p on a.r_productId=p.productId order by a.username asc;
select * from member m left join purchase p on m.memberId=p.p_memberId order by m.username asc;
rollback;
commit;

select * from member;
select * from product;
select * from basket;
select * from purchase;
select * from reply;

=======
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
>>>>>>> 27274548fbcbcd35f4ec9c1ae6a62d595cc0c362
