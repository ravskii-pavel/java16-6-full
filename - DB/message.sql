select *
from message;


select email
from users
where id in (select author_id
from message
where theme_id in (2,6)); 

insert into message (text, author_id, theme_id)
values('We dont need no education
We dont need no thought control
No dark sarcasm in the classroom
Hey teacher, leave those kids alone', 15, 6);
