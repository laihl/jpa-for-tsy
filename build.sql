create schema if not exists temp collate utf8_general_ci;
use temp;
create table if not exists t_address
(
	address_id int auto_increment
		primary key,
	address varchar(255) null,
	jiliang double null,
	user_id int null
)
engine=MyISAM;

create table if not exists t_data_lib
(
	id int auto_increment
		primary key,
	description varchar(255) null,
	father_id int null,
	str_id varchar(255) null,
	value varchar(255) null
)
engine=MyISAM;

create table if not exists t_news
(
	id int auto_increment
		primary key,
	author_user int null,
	context varchar(255) null,
	good varchar(255) null,
	reg_date varchar(255) null,
	title varchar(255) null,
	top varchar(255) null,
	type varchar(255) null
)
engine=MyISAM;

create table if not exists t_order_detail
(
	order_detail_id int auto_increment
		primary key,
	danjia double null,
	danwei int null,
	danweiname varchar(255) null,
	danweiupjishu int null,
	danweiupname varchar(255) null,
	fandian double null,
	jiliang varchar(255) null,
	price double null,
	product_id int null,
	product_name varchar(255) null,
	quantity int null,
	xiaoji double null
)
engine=MyISAM;

create table if not exists t_order_list
(
	order_id int auto_increment
		primary key,
	admin varchar(255) null,
	adress_id int null,
	chareter varchar(255) null,
	deletedata varchar(255) null,
	gustphone varchar(255) null,
	huansuan varchar(255) null,
	massage varchar(255) null,
	odernumber varchar(255) null,
	price double null,
	reg_iate datetime null,
	state varchar(255) null,
	user_id int null,
	wuliu varchar(255) null
)
engine=MyISAM;

create table if not exists t_pay_data
(
	pay_id int auto_increment
		primary key,
	address_id int null,
	charecter varchar(255) null,
	create_by varchar(255) null,
	data varchar(255) null,
	money double null,
	payway varchar(255) null,
	uip varchar(255) null,
	user_id int null
)
engine=MyISAM;

create table if not exists t_product
(
	product_id int auto_increment
		primary key,
	fandian double null,
	jiliang double null,
	product_left int null,
	product_name varchar(255) null,
	product_classify_id int null,
	unit_id int null
)
engine=MyISAM;

create table if not exists t_product_classify
(
	product_classify_id int auto_increment
		primary key,
	father_id int null,
	name varchar(255) null
)
engine=MyISAM;

create table if not exists t_unit
(
	id int auto_increment
		primary key,
	base int null,
	base_name varchar(255) null,
	father_id int null,
	price double null
)
engine=MyISAM;

create table if not exists t_user
(
	user_id int auto_increment
		primary key,
	user_name varchar(255) null,
	fandian double null,
	login_id varchar(255) null,
	reg_date varchar(255) null,
	sex varchar(255) null,
	user_auth varchar(255) null
);

