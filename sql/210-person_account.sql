-- load pgcrypto extension
-- CREATE EXTENSION pgcrypto;

-- create a new person
INSERT INTO person (first_name, last_name, birthday, sex, create_time, update_time, location_id)
VALUES ('Srdjan', 'Tijanic', now(), 'M', now(), now(), 1);

-- create a new account and set the password
INSERT INTO account (user_name, password, email, account_person_id)
VALUES ('stijanic', crypt('new password', gen_salt('bf')), 'stijanic@astroweb.com', 1);

-- update the password
UPDATE account SET password = crypt('password', gen_salt('bf')) WHERE user_name='stijanic';

-- check the password
SELECT password = crypt('password', password) FROM account WHERE user_name='stijanic';
