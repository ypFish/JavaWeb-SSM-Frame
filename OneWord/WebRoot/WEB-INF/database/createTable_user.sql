use message;

create table User(
	userId int PRIMARY key auto_increment,
	userName VARCHAR(50),
	password VARCHAR(50)
);