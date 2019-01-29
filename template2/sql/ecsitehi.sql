set names utf8;
set foreign_key_checks = 0;
/*もしデータベースが存在したら消す*/
drop database if exists ecsitehi;

/*データベースを作る*/
create database if not exists ecsitehi;

/*データベースを使う*/
use ecsitehi;

/*----------------ログインの方---------------------*/

/*もしテーブルがあるなら消す*/
drop table if exists login_user_transaction;


/*テーブルを作る*/
create table login_user_transaction(

	/*テーブルに情報を保存する */
	id int not null primary key auto_increment,
	login_id varchar(16) unique,
	login_pass varchar(16),
	user_name varchar(50),
	/*時間を表示する設定*/
	insert_date datetime,
	updated_date datetime
	);

/*---------------商品情報の方--------------------------*/
drop table if exists item_info_transaction;

create table item_info_transaction(

id int not null primary key auto_increment,
item_name varchar(30),
item_price int,
item_stock int,
insert_date datetime,
update_date datetime
);

drop table if exists user_buy_item_transaction;

create table user_buy_item_transaction(
id int not null primary key auto_increment,
item_transaction_id int,
total_price int,
total_count int,
user_master_id varchar(16),
pay varchar(30),
insert_date datetime,
deelete_date datetime
);
/*作成したものに情報を挿入*/
INSERT INTO item_info_transaction(item_name, item_price,item_stock) VALUES("NoteBook",100,50);

INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("internous","internous01","test");
