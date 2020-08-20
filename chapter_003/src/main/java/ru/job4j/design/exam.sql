CREATE TABLE company
(
id serial NOT NULL,
name character varying,
CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
id serial NOT NULL,
name character varying,
company_id integer references company (id),
CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company (name) values ('Gazprom');
insert into company (name) values ('Rosneft');
insert into company (name) values ('Yandex');
insert into company (name) values ('Lukoil');
insert into company (name) values ('VTB');
insert into company (name) values ('Sberbank');
insert into company (name) values ('Sberbank');


insert into person (name, company_id) values ('Vadim Ivanov', 1 );
insert into person (name, company_id) values ('Vadim Petrov', 2 );
insert into person (name, company_id) values ('Vadim Petrov', 3 );
insert into person (name, company_id) values ('Ivan Petrov', 2 );
insert into person (name, company_id) values ('Andrey Petrov', 1 );
insert into person (name, company_id) values ('Kot Petrov', 5 );
insert into person (name, company_id) values ('Nikolay Petrov', 5 );
insert into person (name, company_id) values ('Gleb Petrov', 3 );
insert into person (name, company_id) values ('Boris Petrov', 4 );
insert into person (name, company_id) values ( 'Andrey K', 5);

select p.name from person as p
right join company as c on c.id = p.company_id
where p.company_id != 5

select p.name, c.name  from person as p
right join company as c on c.id = p.company_id

select  max(c.name), count(p.name) from company as c
inner join person as p on c.id = p.company_id
group by c.name
order by count desc limit 1;
