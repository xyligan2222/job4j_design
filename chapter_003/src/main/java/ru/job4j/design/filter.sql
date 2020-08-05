Create table product ( id serial primary key, name_product character(100) not null, type_id int, expired_date timestamp, price real); 
Create table types ( id serial primary key, name_type character(100) not null); 
insert into product (name_product, type_id, expired_date, price, id_types) values ('��� �������������', 1234527, '2020-08-31 06:30:00', 200.00,(select id from types where name_type='���') );
insert into product (name_product, type_id, expired_date, price, id_types) values ('��� ����������', 12345671, '2020-08-31 06:30:00', 208.00, (select id from types where name_type='���'));
insert into product (name_product, type_id, expired_date, price, id_types) values ('��� �����������', 12345271, '2020-08-6 06:30:00', 225.00, (select id from types where name_type='���'));
insert into product (name_product, type_id, expired_date, price, id_types) values ('������ �������', 22345671, '2020-08-11 06:30:00', 80.00, (select id from types where name_type='������'));
insert into product (name_product, type_id, expired_date, price, id_types) values ('������ ��������', 223245671, '2020-08-12 06:30:00', 79.00, (select id from types where name_type='������'));
insert into product (name_product, type_id, expired_date, price, id_types) values ('������ �������� �����������', 223415671, '2020-09-23 06:30:00', 109.00, (select id from types where name_type='������'));
insert into product (name_product, type_id, expired_date, price, id_types) values ('����� �����', 293415671, '2021-09-23 06:30:00', 59.00, (select id from types where name_type='�����'));
select * from product;
insert into types ( name_type) values ('���');
insert into types ( name_type) values ('������');
insert into types ( name_type) values ('�����');

select * from product as u
where u.id_types=1;

select * from product as u
where u.name_product like '%��������%' ;

select * from product as u
where u.expired_date between '2020-08-01 00:00:00' and '2020-08-31 23:59:59';

select * from product as u
where u.price = (Select max (price) from product);

select count(*) from product as u
where u.id_types=1;

select count(*) from product as u
where u.id_types=1 or u.id_types=2;

select name_type from types as c
where ( select count(id_types) from product as u where u.id_types= c.id)<2;

select u.name_product, c.name_type from product as u
inner join types as c on u.id_types=c.id;