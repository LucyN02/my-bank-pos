create table tb_customers(
 id serial PRIMARY KEY,
 document VARCHAR (20) not NULL,
 email VARCHAR(100)  not null,
 requests int not null
);

create table tb_cards (
 id serial PRIMARY KEY,
 name VARCHAR (20) not NULL,
 flag VARCHAR(100)  not null,
 card_limits decimal  not null
);
