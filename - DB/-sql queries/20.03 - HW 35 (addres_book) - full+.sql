create schema address_book;

select * from street;

create table street
(id int(11) not null AUTO_INCREMENT, street_name varchar(45),
PRIMARY KEY (id),
UNIQUE KEY id_UNIQUE (id));

create table citizen
(id int(11) not null AUTO_INCREMENT, 
first_name varchar(45) not null,
last_name varchar(45) not null,
age int(11) not null,
street_id int(11),
PRIMARY KEY (id),
UNIQUE KEY id_UNIQUE (id));

update street
set street_name = 'Bobrova'
where id = 8;

update citizen
set first_name = 'Антон',
last_name = 'Березюк',
age = 37,
street_id = 3
where id = 2;

update citizen
set last_name = 'Березюк'
where id = 8;

update citizen
set age = 15
where id = 4;

insert into citizen 
(first_name, last_name, age, street_id) 
values ('Петр', 'Козиков', '22', 3);

insert into street 
(street_name) 
values ('Komsomolskaya');

/* 1) Общее число жителей*/
select count(*) from citizen;

/*  2) Средний возраст жителей*/
select avg(age) from citizen;

/*  3) отсортированный по алфавиту список фамилий без повторений - 1*/

select last_name
from citizen
group by last_name;

/* 3) отсортированный по алфавиту список фамилий без повторений - 2*/

select distinct last_name
from citizen
order by last_name;

/* 4) Вывести список фамилий, с указанием количества повторений этих фамилий в общем списке*/

select last_name, count(last_name) as COUNT
from citizen
group by last_name;

/* 5) фамилии, которые содержат в середине букву «н»*/

select last_name
from citizen
where last_name like '%н%';

/* 6) Вывести список «бомжей»*/

select last_name
from citizen
where street_id is null;

/* 7) Вывести список несовершеннолетних, проживающих на улице*/

select last_name, age
from citizen
where street_id is null and age < 18;

/* 8) Вывести упорядоченный по алфавиту список всех улиц с указанием, сколько жильцов живет на улице*/

select street_name, count(street_id) as count_citizens
from street left JOIN citizen on(street.id = citizen.street_id)
group by street_name;

/* 9) Вывести список улиц, название которых состоит из 6-ти букв*/

select street_name
from street
where length(street_name) = 6;

/* 10) Вывести список улиц с количеством жильцов на них меньше 3*/

select street_name, count(street_id) as count_citizens
from street left JOIN citizen on(street.id = citizen.street_id)
group by street_name
having count_citizens < 3;