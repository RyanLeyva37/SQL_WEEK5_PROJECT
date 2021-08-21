create database if not exists albums;
	use albums;

	drop table if exists albums;

	create table albums (
		id int(10) not null auto_increment,
		name varchar(50) not null,
		artist varchar(50),
		primary key(id)
	);