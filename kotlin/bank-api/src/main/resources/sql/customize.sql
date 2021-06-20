/*
Custom security schema
*/
CREATE TABLE bank.custom_users (
	id uuid NOT NULL DEFAULT gen_random_uuid(),
	email varchar(45) NOT NULL,
	pwd varchar(45) NOT NULL,
	role_column varchar(45) NOT NULL,
	PRIMARY KEY (id)
);

insert into bank.custom_users (email, pwd, role_column)
values ('johndoe@gmail.com', '54321', 'admin')
