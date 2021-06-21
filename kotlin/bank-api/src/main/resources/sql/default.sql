/*
Scripts to create the database in Postgresql
*/
-- bank.authorities definition

-- Drop table

-- DROP TABLE bank.authorities;

CREATE TABLE bank.authorities (
	id uuid NOT NULL DEFAULT gen_random_uuid(),
	username varchar(45) NOT NULL,
	authority varchar(45) NOT NULL,
	CONSTRAINT authorities_pkey PRIMARY KEY (id)
);

-- bank.users definition

-- Drop table

-- DROP TABLE bank.users;

CREATE TABLE bank.users (
	id uuid NOT NULL DEFAULT gen_random_uuid(),
	username varchar(45) NOT NULL,
	"password" varchar(200) NOT NULL,
	enabled int4 NOT NULL,
	CONSTRAINT users_pkey PRIMARY KEY (id)
);

insert into bank.users (username , "password" , enabled ) values ('happy', '12345', 1)
insert into bank.authorities (username, authority ) values ('happy', 'write')
