CREATE SCHEMA bank AUTHORIZATION root;

-- bank.account_transactions definition

-- Drop table

-- DROP TABLE bank.account_transactions;

CREATE TABLE bank.account_transactions (
	transaction_id varchar(255) NOT NULL,
	account_number int8 NULL,
	closing_balance int4 NULL,
	create_dt varchar(255) NULL,
	customer_id int4 NULL,
	transaction_amt int4 NULL,
	transaction_dt date NULL,
	transaction_summary varchar(255) NULL,
	transaction_type varchar(255) NULL,
	CONSTRAINT account_transactions_pkey PRIMARY KEY (transaction_id)
);

-- bank.accounts definition

-- Drop table

-- DROP TABLE bank.accounts;

CREATE TABLE bank.accounts (
	account_number int8 NOT NULL,
	account_type varchar(255) NULL,
	branch_address varchar(255) NULL,
	create_dt varchar(255) NULL,
	customer_id int4 NULL,
	CONSTRAINT accounts_pkey PRIMARY KEY (account_number)
);

-- bank.cards definition

-- Drop table

-- DROP TABLE bank.cards;

CREATE TABLE bank.cards (
	card_id int4 NOT NULL,
	amount_used int4 NULL,
	available_amount int4 NULL,
	card_number varchar(255) NULL,
	card_type varchar(255) NULL,
	create_dt date NULL,
	customer_id int4 NULL,
	total_limit int4 NULL,
	CONSTRAINT cards_pkey PRIMARY KEY (card_id)
);

-- bank.contact_messages definition

-- Drop table

-- DROP TABLE bank.contact_messages;

CREATE TABLE bank.contact_messages (
	contact_id varchar(255) NOT NULL,
	contact_email varchar(255) NULL,
	contact_name varchar(255) NULL,
	create_dt timestamp NULL,
	message varchar(255) NULL,
	subject varchar(255) NULL,
	CONSTRAINT contact_messages_pkey PRIMARY KEY (contact_id)
);

-- bank.customer definition

-- Drop table

-- DROP TABLE bank.customer;

CREATE TABLE bank.customer (
	customer_id int4 NOT NULL,
	create_dt varchar(255) NULL,
	email varchar(255) NULL,
	mobile_number varchar(255) NULL,
	"name" varchar(255) NULL,
	pwd varchar(255) NULL,
	"role" varchar(255) NULL,
	CONSTRAINT customer_pkey PRIMARY KEY (customer_id)
);

-- bank.loans definition

-- Drop table

-- DROP TABLE bank.loans;

CREATE TABLE bank.loans (
	loan_number int4 NOT NULL,
	amount_paid int4 NULL,
	create_dt varchar(255) NULL,
	customer_id int4 NULL,
	loan_type varchar(255) NULL,
	outstanding_amount int4 NULL,
	start_dt timestamp NULL,
	total_loan int4 NULL,
	CONSTRAINT loans_pkey PRIMARY KEY (loan_number)
);

-- bank.notice_details definition

-- Drop table

-- DROP TABLE bank.notice_details;

CREATE TABLE bank.notice_details (
	notice_id int4 NOT NULL,
	create_dt timestamp NULL,
	notic_beg_dt timestamp NULL,
	notic_end_dt timestamp NULL,
	notice_details varchar(255) NULL,
	notice_summary varchar(255) NULL,
	update_dt timestamp NULL,
	CONSTRAINT notice_details_pkey PRIMARY KEY (notice_id)
);

INSERT INTO bank.account_transactions
(transaction_id, account_number, closing_balance, create_dt, customer_id, transaction_amt, transaction_dt, transaction_summary, transaction_type)
VALUES('', 0, 0, '', 0, 0, '', '', '');

INSERT INTO bank.accounts
(account_number, account_type, branch_address, create_dt, customer_id)
VALUES(0, '', '', '', 0);

INSERT INTO bank.cards
(card_id, amount_used, available_amount, card_number, card_type, create_dt, customer_id, total_limit)
VALUES(0, 0, 0, '', '', '', 0, 0);

INSERT INTO bank.contact_messages
(contact_id, contact_email, contact_name, create_dt, message, subject)
VALUES('', '', '', '', '', '');

INSERT INTO bank.customer
(customer_id, create_dt, email, mobile_number, "name", pwd, "role")
VALUES(0, '', '', '', '', '', '');

INSERT INTO bank.loans
(loan_number, amount_paid, create_dt, customer_id, loan_type, outstanding_amount, start_dt, total_loan)
VALUES(0, 0, '', 0, '', 0, '', 0);

INSERT INTO bank.notice_details
(notice_id, create_dt, notic_beg_dt, notic_end_dt, notice_details, notice_summary, update_dt)
VALUES(0, '', '', '', '', '', '');


