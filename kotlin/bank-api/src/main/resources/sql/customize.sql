/*
Custom security schema
*/
CREATE TABLE bank.custom_users (
	id uuid NOT NULL DEFAULT gen_random_uuid(),
	email varchar(45) NOT NULL,
	pwd varchar(200) NOT NULL,
	role_column varchar(45) NOT NULL,
	CONSTRAINT custom_users_pkey PRIMARY KEY (id)
);

/*
Plain password here
*/
insert into bank.custom_users (email, pwd, role_column)
values ('johndoe@gmail.com', '54321', 'admin')

/*
pwd : 12345
*/
insert into bank.custom_users (email, pwd, role_column)
values ('happy@gmail.com', '$2y$12$4zi2WMdLqq7ToKzZF67QeeC2/I0ZVj3X0XXm7AF4cuBu72Mlhf5h.', 'admin')

