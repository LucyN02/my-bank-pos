create table tb_customers(
 id serial PRIMARY KEY,
 document VARCHAR (20) not NULL,
 email VARCHAR(100)  not null,
 requests int not null
);