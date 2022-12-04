create database demobe;
create table category
(
    id int not null primary key AUTO_INCREMENT,
    name  varchar(50) not null,
    description    varchar(255) not null
);

create table Product
(
    id int not null primary key AUTO_INCREMENT,
    name  varchar(50) not null,
    description    varchar(255) ,
    price decimal not null,
    image  varchar(255) ,
    created_date date ,
    active bit DEFAULT '0' ,
    category_id int,
    FOREIGN KEY (category_id) REFERENCES category(id)
);

create table manufacturer
(
    id int not null primary key AUTO_INCREMENT,
    name  varchar(50) not null,
    country    varchar(255) not null
);


create table pro_man
(
    id int not null primary key AUTO_INCREMENT,
    product_id int,
    manufacturer_id int,
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (manufacturer_id) REFERENCES manufacturer(id)
);