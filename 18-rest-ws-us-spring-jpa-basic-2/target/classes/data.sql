-- create table users (id integer not null, dob timestamp(6), name varchar(40), primary key (id))
insert into users values (101, '2024-01-02', 'Ravi');
insert into users values (102, '2024-02-02', 'Naveen');
insert into users values (103, '2024-03-02', 'Lokesh');
insert into users values (104, '2024-04-02', 'Abhi');
insert into users values (105, '2024-05-02', 'Karan');
insert into users values (106, '2024-06-02', 'Krishna');

-- create table posts (post_id integer not null, user_id integer, content varchar(255), primary key (post_id))
insert into posts (post_id, content, user_id) values (1001, 'post 1', 101);
insert into posts (post_id, content, user_id) values (1002, 'post 2', 101);
insert into posts (post_id, content, user_id) values (1003, 'post 3', 101);
insert into posts (post_id, content, user_id) values (1004, 'post 1', 102);
insert into posts (post_id, content, user_id) values (1005, 'post 2', 102);
insert into posts (post_id, content, user_id) values (1006, 'post 1', 105);