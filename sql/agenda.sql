create database dbagenda;
show databases;
use dbagenda;

create table tblcontatos(
 idcon int primary key auto_increment,
 nome varchar(50) not null,
 fone varchar(15) not null,
 email varchar(50)
);