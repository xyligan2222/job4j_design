create table meeting ( id serial primary key, name text);

create table status ( id serial primary key, name text);

create table users ( id serial primary key, name text, id_meeting int references meeting (id), id_status int references status (id));

insert into meeting ( name ) values ( 'business' );
insert into meeting ( name ) values ( 'free' );
insert into meeting ( name ) values ( 'obligatory' );
insert into meeting ( name ) values ( 'Happy Birthday' );

insert into status ( name ) values ( 'confirmed' );
insert into status ( name ) values ( 'rejected' );
insert into status ( name ) values ( 'no answer' );

insert into users ( name ) values ( 'Petr' );
insert into users ( name ) values ( 'Andrew' );
insert into users ( name ) values ( 'Ivan' );
insert into users ( name ) values ( 'Alex' );
insert into users ( name ) values ( 'Kokos' );
insert into users ( name ) values ( 'Vadim' );
insert into users ( name ) values ( 'Serg' );
insert into users ( name ) values ( 'Nicolay' );

select * from users;
insert into users ( name, id_meeting, id_status) values ( 'Petr', (select id from meeting where name = 'business'), (select id from status where name = 'rejected'));
insert into users ( name, id_meeting, id_status) values ( 'Andrew', (select id from meeting where name = 'business'), (select id from status where name = 'confirmed'));
insert into users ( name, id_meeting, id_status) values ( 'Ivan', (select id from meeting where name = 'business'), (select id from status where name = 'confirmed'));
insert into users ( name, id_meeting, id_status) values ( 'Nicolay', (select id from meeting where name = 'business'), (select id from status where name = 'rejected'));
insert into users ( name, id_meeting, id_status) values ( 'Serg', (select id from meeting where name = 'business'), (select id from status where name = 'confirmed'));
insert into users ( name, id_meeting, id_status) values ( 'Kostya', (select id from meeting where name = 'business'), (select id from status where name = 'confirmed'));
insert into users ( name, id_meeting, id_status) values ( 'Koko', (select id from meeting where name = 'business'), (select id from status where name = 'confirmed'));
insert into users ( name, id_meeting, id_status) values ( 'Valenok', (select id from meeting where name = 'business'), (select id from status where name = 'rejected'));
insert into users ( name, id_meeting, id_status) values ( 'Psix', (select id from meeting where name = 'business'), (select id from status where name = 'confirmed'));
insert into users ( name, id_meeting, id_status) values ( 'Vanya', (select id from meeting where name = 'business'), (select id from status where name = 'confirmed'));
insert into users ( name, id_meeting, id_status) values ( 'Alesha', (select id from meeting where name = 'free'), (select id from status where name = 'confirmed'));
insert into users ( name, id_meeting, id_status) values ( 'Andrew', (select id from meeting where name = 'free'), (select id from status where name = 'confirmed'));
insert into users ( name, id_meeting, id_status) values ( 'Valera', (select id from meeting where name = 'Happy Birthday'), (select id from status where name = 'rejected'));
insert into users ( name, id_meeting, id_status) values ( 'Eugene', (select id from meeting where name = 'business'), (select id from status where name = 'no answer'));
insert into users ( name, id_meeting, id_status) values ( 'Kokos', (select id from meeting where name = 'obligatory'), (select id from status where name = 'no answer'));
-- select the number of confirmed users.
select count(s.name) from users as u
inner join  meeting as m on m.id= u.id_meeting
inner join  status as s on u.id_status = s.id
where s.name = 'confirmed'
group by s.name
--list all users which confirmed participation
select u.name, m.name from users as u
inner join  meeting as m on m.id= u.id_meeting
inner join  status as s on u.id_status = s.id
where s.name = 'confirmed'
--list all meetings where there was no request to attend
select  m.name from users as u
right outer join  meeting as m on m.id= u.id_meeting
right outer join  status as s on u.id_status = s.id
where s.name != 'confirmed'
group by  m.name
EXCEPT
select  m.name from users as u
right outer join  meeting as m on m.id= u.id_meeting
right outer join  status as s on u.id_status = s.id
where s.name = 'confirmed'
group by  m.name


