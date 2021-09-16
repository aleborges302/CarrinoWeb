create database dbmercadolivre;

use  dbmercadolivre;



create table carrinho (
id int primary key auto_increment,
produto varchar(100) not null,
quantidade int not null,
valor decimal(10,2) not null
);


insert into carrinho(produto,quantidade,valor)  
values ('Game','1','100');
insert into carrinho(produto,quantidade,valor)  
values ('Jogos','3','160');
show tables;

describe carrinho;


select * from carrinho;

select * from carrinho order by produto; 






