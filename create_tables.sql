create table tb_customers(
 id serial PRIMARY KEY,
 document VARCHAR (20) not NULL,
 email VARCHAR(100)  not null,
 requests int not null
);

create table tb_cards(
 id serial PRIMARY KEY,
 flag VARCHAR (20) not NULL,
 name VARCHAR(100)  not null,
 limits int not null
);
