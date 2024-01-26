insert into "user"
(id, firstname, lastname, birthdate,role,sex,age_category,password,age,image,user_id)
values ('parent1_id', 'Mika', 'Londres', '2001-11-08','PARENT','M','ADULT','test1',23,null,null),
       ('child1_id', 'Rei', 'Maxess', '2014-11-08','CHILD','M','KIDS','test2',10,null,'parent1_id'),
       ('parent2_id', 'Fujo', 'Lax', '2000-11-08','PARENT','M','ADULT','test3',24,null,null),
       ('child2_id', 'Ko', 'Saiba', '2017-11-08','CHILD','M','KIDS','test2',7,null,'parent2_id');