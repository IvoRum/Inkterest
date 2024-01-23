insert into public."User"(id, email, name, first_name, surname_name, last_name, date_of_birth, status, time_stamp)
values(1,'ivo@mail.com','IvoRume','Ivaylo','Plamenov','Rumenov','2000-07-06',1,'2023-10-28');

insert into public."Post"(id, name, image, likes) VALUES (1,'New Tattoo','tattoo.png',0);

insert into public."Artist"(user_id, post) VALUES (1,1);

insert into public."Location"(id, street, number) VALUES (1,'VichoPapazov22',22);

insert into public."Studio"(id, name, location, owner, staff) VALUES (1,'Ivos studio',1,1,1);
