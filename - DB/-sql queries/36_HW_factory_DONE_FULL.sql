/*1. вывести 3-х человек с самой большой зарплатой (из таблицы employees)*/

select * FROM employees
order by salary desc
limit 3 offset 0;

/*2. вывести департаменты и количество человек в каждом*/

select title, count(department_id) as count_employees
FROM departments as D left join employees as E ON (D.id = E.department_id)
group by title;

/*3. вывести департаменты в которых работает больше 1-го человека*/

select title, count(department_id) as count_employees
FROM departments as D left join employees as E ON (D.id = E.department_id)
group by title
having count_employees > 1;

/*4. вывести 2-х сотрудников с самыми большими суммарными зарплатами в 2015 году*/

select E.id, E.name_first, E.name_last, sum(SP.salary) as biggest_salary_2015
from employees as E left join salaries_paid as SP ON (E.id = SP.employee_id)
where date_pay like '%2015%'
group by E.id
order by biggest_salary_2015 desc
limit 2 offset 0;

/*date_pay >= '2015-01-01' and date_pay < '2016-01-01'*/

/*5. вывести сотрудников, кто не ходил ни на один курс*/

select E.id, E.name_first, E.name_last
from employees as E
where E.id not in (select EC.employee_id FROM employees_courses as EC);

/*6. вывести сотрудников кто ходил на 2 и более курса*/

select EC.employee_id, E.name_first, E.name_last, count(EC.employee_id) as count_courses
FROM employees_courses as EC left join employees as E ON (E.id = EC.employee_id)
group by EC.employee_id
having count_courses >= 2;

/*7. вывести самую массовую должность (неплохо бы добавить может ещё пару человек в базу)*/

select P.id, P.title, count(P.title) as post_often
from employees as E left join Posts as P ON (P.id = E.post_id)
group by P.title
order by post_often desc
limit 1 offset 0;

/* SELECT max(post_often), title_post
FROM (
    SELECT count(E.post_id) as post_often, P.title as title_post
    FROM employees as E, Posts as P
    where P.id = E.post_id
    GROUP BY P.title
    order by P.title desc
) as counts;
*/

/*8. подсчитать среднее количество материальных ценностей, приходящихся на сотрудника*/

select * from tangibles;
select * from employees_tangibles;

select (select count(tangible_id)) / (select count(distinct employee_id)) as AVG_tangibles_by_employee
From employees_tangibles;

/*9. найти самую часто встречающуюся материальную ценность у сотрудников (монитор, комп или что-то другое)*/
	/*Вариант 1*/
    
SELECT title_name, title_id, tangibles_count
FROM (
SELECT T.id as title_id, T.title as title_name, count(ET.tangible_id) as tangibles_count
    FROM employees_tangibles as ET, tangibles as T
    where T.id = ET.tangible_id
    GROUP BY title_id
) as counts
	group by counts.tangibles_count
	having counts.tangibles_count = (select max(tangibles_count1) from (SELECT T.id as title_id, T.title as title_name, count(ET.tangible_id) as tangibles_count1
		FROM employees_tangibles as ET, tangibles as T
		where T.id = ET.tangible_id
		GROUP BY title_id) 
        as counts
);

/*Вариант 2 - Альтернативный*/
SELECT T.id as title_id, T.title as title_name, count(ET.tangible_id) as tangibles_often
    FROM employees_tangibles as ET, tangibles as T
    where ET.tangible_id = T.id
    GROUP BY T.id
    order by tangibles_often desc
    limit 1 offset 0;

/*10. найти департамент, сотрудники которого имеют самую большую сумму материальных ценностей*/

	select D.id, D.title, sum_empl_tangibles_by_Department
		FROM departments as D left join 
		(select E.department_id as department_id, sum(sum_tangibles) as sum_empl_tangibles_by_Department
			FROM (
					select ET.employee_id as employee_id, sum(T.price) as sum_tangibles
					FROM employees_tangibles as ET left join tangibles as T ON (ET.tangible_id = T.id)
					group by ET.employee_id
				 )  as sum_tangibles_by_Emp left join employees as E ON (sum_tangibles_by_Emp.employee_id = E.id)
		group by E.department_id
        ) as sum_tangibles_by_Department on (D.id = sum_tangibles_by_Department.department_id) 
	order by sum_empl_tangibles_by_Department desc
	limit 1 offset 0;

/* 11.  ***********
Супер игра: сформировать выборку по сотрудникам за 2015 год в которой будет: фио сотрудника, суммарная зарплата за год, 
количество отработанных часов за год, количество посещаемых курсов, количество материальных ценностей и их общая цена, 
название должности и название департамента */

SELECT emp_data_and_salary.id, emp_data_and_salary.first_name, emp_data_and_salary.last_name, emp_data_and_salary.sum_salary_2015, sum_tangibles, count_tangibles, 
sum(TIMESTAMPDIFF(SECOND, day_start, day_finish)/3600) as sum_hours_by_year, count_courses_by_empl, name_department, name_post
FROM (
		select E.id as id, E.name_first as first_name, E.name_last as last_name, sum(SP.salary) as sum_salary_2015, E.department_id as department_id, E.post_id as post_id
		from employees as E left join salaries_paid as SP ON (SP.employee_id = E.id and date_pay like ('%2015%'))
		group by E.id
) as emp_data_and_salary right join (
				select ET.employee_id as employee_id, sum(T.price) as sum_tangibles, count(ET.tangible_id) as count_tangibles
				FROM employees_tangibles as ET left join tangibles as T ON (ET.tangible_id = T.id)
				group by ET.employee_id) as sum_tangibles_emp ON (emp_data_and_salary.id = sum_tangibles_emp.employee_id) 
					left join (
                    select *
                    FROM working_days) as working_hours ON (emp_data_and_salary.id = working_hours.employee_id)
						left join (
						select count(EC.course_id) as count_courses_by_empl, EC.employee_id as employee_id
                        FROM employees_courses as EC
                        group by EC.employee_id) as count_courses ON (emp_data_and_salary.id = count_courses.employee_id)
							left join (
							select D.title as name_department, D.id as id
							FROM departments as D) as departments_name ON (emp_data_and_salary.department_id = departments_name.id)
								left join (
								select P.title as name_post, P.id as id
								FROM posts as P) as posts_name ON (emp_data_and_salary.post_id = posts_name.id)
group by emp_data_and_salary.id;
