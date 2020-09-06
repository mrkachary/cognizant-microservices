
CREATE TABLE CUSTOMER (
cust_id bigint auto_increment primary key,
first_name varchar(25) not null,
last_name varchar(25) not null,
age int not null,
cust_addrs_id bigint,
created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);