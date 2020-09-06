

CREATE TABLE ADDRESS (
cust_addrs_id bigint auto_increment primary key,
door_no varchar(20) not null,
street varchar(30) not null,
city varchar(20) not null,
country varchar(20) not null,
zip varchar(20) not null,
created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
