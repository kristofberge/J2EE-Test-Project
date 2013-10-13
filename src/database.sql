create table appuser (
	id number,
	firstNAme varchar2(20),
	lastName varchar2(20),
	userName varchar2(30),
	password varchar2(40),
	constraint appuser_pk primary key (id),
	constraint app_username_uk unique (username)
);