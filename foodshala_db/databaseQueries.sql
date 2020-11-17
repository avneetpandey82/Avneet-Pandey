create database foodshala;
create table customerlist(id int auto_increment primary key,name varchar(100),dob varchar(10),phone varchar(30),address varchar(500),gender varchar(20),foodType varchar(10),username varchar(100) unique not null,password varchar(50));
create table restlist(id int auto_increment primary key,name varchar(100),dob varchar(10),phone varchar(30),address varchar(500),gender varchar(20),foodType varchar(10),username varchar(100) unique not null,password varchar(50));
create table cart(username varchar(100) ,name varchar(100),image varchar(50),types varchar(10),price int,id int);
create table menu(id int,name varchar(50),image varchar(200),types varchar(10),price int);
create table orders(username varchar(100),name varchar(100),image varchar(100),types varchar(10),price int);

