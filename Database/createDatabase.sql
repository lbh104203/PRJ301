create database [PRJ301]
use PRJ301
create table [User](
	username varchar (200),
	[password] nvarchar(255),
	displayName nvarchar(255),
	email nvarchar(255),
	dob date,
	phonenumber varchar(20),
	createdDate datetime,
	updateDate datetime,
	constraint PK_User primary key(username)
)
create table [Role](
	id int,
	[name] varchar(255)
	constraint PK_Role primary key(id)
)
create table User_Role(
	username varchar(200) foreign key references [User](username),
	roleId int foreign key references [Role](id),
	constraint PK_User_Role primary key (username, roleId) 
)