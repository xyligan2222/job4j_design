create table carcase (id serial primary key, name character (100) not null);

insert into carcase (name) values ('hatchback');
insert into carcase (name) values ('wagon');
insert into carcase (name) values ('sedan');
insert into carcase (name) values ('cabriolet');

create table transmission (id serial primary key, name character (100) not null);
insert into transmission (name) values ('3 speed');
insert into transmission (name) values ('4 speed');
insert into transmission (name) values ('5 speed');
insert into transmission (name) values ('6 speed');

create table engine (id serial primary key, name character (100) not null);
insert into engine (name) values ('12 cylinders');
insert into engine (name) values ('16 cylinders');
insert into engine (name) values ('8 cylinders');
insert into engine (name) values ('10 cylinders');

create table car (id serial primary key, name character (100) not null, id_carcase int references carcase(id),id_transmission int references transmission(id),id_engine int references engine(id));
insert into car (name, id_carcase, id_transmission, id_engine) values ('Volvo', 1,2,3);
insert into car (name, id_carcase, id_transmission, id_engine) values ('BMW',1,2,4);
insert into car (name, id_carcase, id_transmission, id_engine) values ('Mercedes',2,4,3);
insert into car (name, id_carcase, id_transmission, id_engine) values ('GAZ',1,3,1);
-- list of all cars 
select c.name, a.name, b.name, d.name from car as c
inner join carcase as a on c.id_carcase = a.id
inner join transmission as b on c.id_transmission = b.id
inner join engine as d on c.id_engine = d.id;
--body type is absent in cars
select  a.name from car as c right outer join carcase as a on a.id=c.id_carcase
where c.name is null;
--transmission  type is absent in cars
select  a.name from car as c right outer join transmission as a on a.id=c.id_transmission
where c.name is null;
--engine  type is absent in cars
select  a.name from car as c right outer join engine as a on a.id=c.id_engine
where c.name is null;
