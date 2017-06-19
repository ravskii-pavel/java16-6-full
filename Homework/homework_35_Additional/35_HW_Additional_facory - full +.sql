/* 1. найти курсы в названии которых есть слово Ubuntu и стоимость больше 500 */

select * from courses
where title like '%Ubuntu%' and price > 500;

/* 2. найти второго  сотрудника с самой большой зарплатой, не первого (подсказка, у LIMIT есть 2 параметра)  */

select salary from employees
order by salary desc
limit 1 offset 1; /* limit - количество записей для вывода, offset - с какой записи начинать вывод (нумерация начинается с нуля)*/

/*3. добавить в таблицу сотрудников любого однофамильца и запросом найти фамилии, которые встречаются более 1 раза */

select name_last
from employees
group by name_last
having count(name_last) > 1;

/*4. вывести id сотрудника у которого больше всего материальных ценностей (таблица employees_tangibles) */

select employee_id
from employees_tangibles
group by employee_id
order by count(employee_id) desc
limit 1 offset 0; ;

/*5. из таблицы tangibles найти все стулья ценой больше 570 */

select * from tangibles
where title like '%стул%' and price > 570;

/*6. из таблицы salaries_paid вывести все записи с salary больше-равно 1200 и меньше 100 */

select * from salaries_paid
where salary >= 1200 or salary < 100;  

/*7. найти одним запросом минимальную зарплату, максимальную зарплату и количество сотрудников */

select min(sp.salary), max(sp.salary), count(distinct employees.id) as count_employees
FROM salaries_paid as sp, employees;

/*8. в таблице employees_courses найти id сотрудников, которые  окончили 2 курса */
select employee_id
from employees_courses
group by employee_id
having count(employee_id) > 1 and count(date_finish) = 2;

/*9. из salaries_paid выбрать все записи кроме! марта и августа, отсортировав по date_create */

select * from salaries_paid
where date_pay < '2015-03-01' or date_pay > '2015-08-01'
order by date_create;

/*10. из таблицы tangibles выбрать либо столы стоимостью меньше 1300, либо другие предметы кроме столов, 
стоимостью больше 1000, отсортировать предметы по стоимости */

select *
from tangibles
where (title like '%стол%' and price < 1300) or (title not like '%стол%' and price > 1000)
order by price;
