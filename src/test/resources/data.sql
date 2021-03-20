-- INSERT EMPLOYEES			
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Mirjahon', 'Ulmasov', 'mirjahonulmoasv@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Mirhamid', 'Ulmasov', 'ulmasovmirhamid@gmail.com' );
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Sevara', 'Ulmasova', 's.ulmasova@mail.ru' );
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Shahzoda', 'Mirsaitova', 'shahzoda@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Nodira', 'Sultanova', 'nodira@inbox.ru');
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Nusratilla', 'Mirsaitov', 'n.mirsaitov@mail.ru');
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Shuhrat', 'Sultanov', 's.sultanov@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Miran', 'Mirsaitov', 'miran@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Sora', 'Mirsaitova', 'sora.mirsaitova@gmail.com');

-- INSERT PROJECTS
insert into project (project_id, name, stage, description,start_date,end_date) values (nextval('project_seq'), 'New Year 2021', 'NOTSTARTED', 'Happy New Year, wish all people luck','2020-12-9 00:00:00.000','2021-1-1 00:00:00.000');
insert into project (project_id, name, stage, description,start_date,end_date) values (nextval('project_seq'), 'Large Production Deploy', 'NOTSTARTED', 'This requires all hands on deck for the final deployment of the software into production','2020-12-8 00:00:00.000','2020-12-31 00:00:00.000');
insert into project (project_id, name, stage, description,start_date,end_date) values (nextval('project_seq'), 'New Employee Budget',  'COMPLETED', 'Decide on a new employee bonus budget for the year and figure out who will be promoted','2020-10-4 00:00:00.000','2020-12-8 00:00:00.000');
insert into project (project_id, name, stage, description,start_date,end_date) values (nextval('project_seq'), 'Office Reconstruction', 'INPROGRESS', 'The office building in Monroe has been damaged due to hurricane in the region. This needs to be reconstructed','2021-1-1 00:00:00.000','2021-2-17 00:00:00.000');
insert into project (project_id, name, stage, description,start_date,end_date) values (nextval('project_seq'), 'Improve Intranet Security', 'INPROGRESS', 'With the recent data hack, the office security needs to be improved and proper security team needs to be hired for implementation','2021-1-15 00:00:00.000','2021-6-17 00:00:00.000');

-- INSERT PROJECT_EMPLOYEE_RELATION
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.first_name ='Mirjahon' AND p.name = 'Large Production Deploy');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.first_name ='Mirjahon' AND p.name = 'New Employee Budget');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.first_name ='Mirhamid' AND p.name = 'Office Reconstruction');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.first_name ='Shahzoda' AND p.name = 'Large Production Deploy');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.first_name ='Nodira' AND p.name = 'Improve Intranet Security');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.first_name ='Shuhrat' AND p.name = 'Office Reconstruction');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.first_name ='Nusratilla' AND p.name = 'Improve Intranet Security');