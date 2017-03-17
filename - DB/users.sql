update users 
set email = 'eagles@gmail.com', user_name = 'Eagles'
where id = 5;

select *
from users;

insert into users (user_name, email, password)
values ('Pink Floyd', 'pinkfloyd@gmail.com', 'pinkfloyd1919');

delete from users
where id in (9,10,11,12);