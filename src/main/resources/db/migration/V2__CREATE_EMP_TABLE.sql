CREATE TABLE USERS (
		user_id bigint generated by default as identity,
        name varchar(255),
        role varchar(255),
        primary key (user_id)
        
        );
        
CREATE TABLE VALUE_RECORDS (
		value_id bigint generated by default as identity,
        data timestamp(6),
        descricao varchar(255),
        tipo boolean not null,
        user_id bigint,
        valor varchar(255),
        primary key (value_id)
        );
INSERT INTO USERS
VALUES (1, 'Eduardo Abreu', 'admin');


INSERT INTO VALUE_RECORDS
VALUES 

( 1 , DATE '2022-01-05' , 'Salário' , true , 1 , '8500' ), 
( 2 , DATE '2022-01-07' , 'Cartão de crédito' , false , 1 , '1500' ), 
( 3 , DATE '2022-01-23' , 'IPVA' , false , 1 , '2500' ), 
( 4 , DATE '2022-01-25' , 'IPTU' , false , 1 , '1500' ), 
( 5 , DATE '2022-01-06' , 'Faculdade' , false , 1 , '690' ), 
( 6 , DATE '2022-01-10' , 'Conta de Celular' , false , 1 , '50' ), 
( 7 , DATE '2022-01-05' , 'Financiamento Casa' , false , 1 , '1800' ), 
( 8 , DATE '2022-02-05' , 'Salário' , true , 1 , '8500' ), 
( 9 , DATE '2022-02-07' , 'Cartão de crédito' , false , 1 , '1500' ), 
( 10 , DATE '2022-02-23' , 'IPVA' , false , 1 , '2500' ), 
( 11 , DATE '2022-02-25' , 'IPTU' , false , 1 , '1500' ), 
( 12 , DATE '2022-02-06' , 'Faculdade' , false , 1 , '690' ), 
( 13 , DATE '2022-02-10' , 'Conta de Celular' , false , 1 , '50' ), 
( 14 , DATE '2022-02-05' , 'Financiamento Casa' , false , 1 , '1800' ), 
( 15 , DATE '2022-03-05' , 'Salário' , true , 1 , '8500' ), 
( 16 , DATE '2022-03-07' , 'Cartão de crédito' , false , 1 , '1500' ), 
( 17 , DATE '2022-03-23' , 'IPVA' , false , 1 , '2500' ), 
( 18 , DATE '2022-03-25' , 'IPTU' , false , 1 , '1500' ), 
( 19 , DATE '2022-03-06' , 'Faculdade' , false , 1 , '690' ), 
( 20 , DATE '2022-03-10' , 'Conta de Celular' , false , 1 , '50' ), 
( 21 , DATE '2022-03-05' , 'Financiamento Casa' , false , 1 , '1800' ), 
( 22 , DATE '2022-04-05' , 'Salário' , true , 1 , '8500' ), 
( 23 , DATE '2022-04-07' , 'Cartão de crédito' , false , 1 , '1500' ), 
( 24 , DATE '2022-04-23' , 'IPVA' , false , 1 , '2500' ), 
( 25 , DATE '2022-04-25' , 'IPTU' , false , 1 , '1500' ), 
( 26 , DATE '2022-04-06' , 'Faculdade' , false , 1 , '690' ), 
( 27 , DATE '2022-04-10' , 'Conta de Celular' , false , 1 , '50' ), 
( 28 , DATE '2022-04-05' , 'Financiamento Casa' , false , 1 , '1800' ), 
( 29 , DATE '2022-05-05' , 'Salário' , true , 1 , '8500' ), 
( 30 , DATE '2022-05-07' , 'Cartão de crédito' , false , 1 , '1500' ), 
( 31 , DATE '2022-05-23' , 'IPVA' , false , 1 , '2500' ), 
( 32 , DATE '2022-05-25' , 'IPTU' , false , 1 , '1500' ), 
( 33 , DATE '2022-05-06' , 'Faculdade' , false , 1 , '690' ), 
( 34 , DATE '2022-05-10' , 'Conta de Celular' , false , 1 , '50' ), 
( 35 , DATE '2022-05-05' , 'Financiamento Casa' , false , 1 , '1800' ), 
( 36 , DATE '2022-06-05' , 'Salário' , true , 1 , '8500' ), 
( 37 , DATE '2022-06-07' , 'Cartão de crédito' , false , 1 , '1500' ), 
( 38 , DATE '2022-06-23' , 'IPVA' , false , 1 , '2500' ), 
( 39 , DATE '2022-06-25' , 'IPTU' , false , 1 , '1500' ), 
( 40 , DATE '2022-06-06' , 'Faculdade' , false , 1 , '690' ), 
( 41 , DATE '2022-06-10' , 'Conta de Celular' , false , 1 , '50' ), 
( 42 , DATE '2022-06-05' , 'Financiamento Casa' , false , 1 , '1800' ), 
( 43 , DATE '2022-07-05' , 'Salário' , true , 1 , '8500' ), 
( 44 , DATE '2022-07-07' , 'Cartão de crédito' , false , 1 , '1500' ), 
( 45 , DATE '2022-07-23' , 'IPVA' , false , 1 , '2500' ), 
( 46 , DATE '2022-07-25' , 'IPTU' , false , 1 , '1500' ), 
( 47 , DATE '2022-07-06' , 'Faculdade' , false , 1 , '690' ), 
( 48 , DATE '2022-07-10' , 'Conta de Celular' , false , 1 , '50' ), 
( 49 , DATE '2022-07-05' , 'Financiamento Casa' , false , 1 , '1800' ), 
( 50 , DATE '2022-08-05' , 'Salário' , true , 1 , '8500' ), 
( 51 , DATE '2022-08-07' , 'Cartão de crédito' , false , 1 , '1500' ), 
( 52 , DATE '2022-08-23' , 'IPVA' , false , 1 , '2500' ), 
( 53 , DATE '2022-08-25' , 'IPTU' , false , 1 , '1500' ), 
( 54 , DATE '2022-08-06' , 'Faculdade' , false , 1 , '690' ), 
( 55 , DATE '2022-08-10' , 'Conta de Celular' , false , 1 , '50' ), 
( 56 , DATE '2022-08-05' , 'Financiamento Casa' , false , 1 , '1800' ), 
( 57 , DATE '2022-09-05' , 'Salário' , true , 1 , '8500' ), 
( 58 , DATE '2022-09-07' , 'Cartão de crédito' , false , 1 , '1500' ), 
( 59 , DATE '2022-09-23' , 'IPVA' , false , 1 , '2500' ), 
( 60 , DATE '2022-09-25' , 'IPTU' , false , 1 , '1500' ), 
( 61 , DATE '2022-09-06' , 'Faculdade' , false , 1 , '690' ), 
( 62 , DATE '2022-09-10' , 'Conta de Celular' , false , 1 , '50' ), 
( 63 , DATE '2022-09-05' , 'Financiamento Casa' , false , 1 , '1800' ), 
( 64 , DATE '2022-10-05' , 'Salário' , true , 1 , '8500' ), 
( 65 , DATE '2022-10-07' , 'Cartão de crédito' , false , 1 , '1500' ), 
( 66 , DATE '2022-10-23' , 'IPVA' , false , 1 , '2500' ), 
( 67 , DATE '2022-10-25' , 'IPTU' , false , 1 , '1500' ), 
( 68 , DATE '2022-10-06' , 'Faculdade' , false , 1 , '690' ), 
( 69 , DATE '2022-10-10' , 'Conta de Celular' , false , 1 , '50' ), 
( 70 , DATE '2022-10-05' , 'Financiamento Casa' , false , 1 , '1800' ), 
( 71 , DATE '2022-11-05' , 'Salário' , true , 1 , '8500' ), 
( 72 , DATE '2022-11-07' , 'Cartão de crédito' , false , 1 , '1500' ), 
( 73 , DATE '2022-11-23' , 'IPVA' , false , 1 , '2500' ), 
( 74 , DATE '2022-11-25' , 'IPTU' , false , 1 , '1500' ), 
( 75 , DATE '2022-11-06' , 'Faculdade' , false , 1 , '690' ), 
( 76 , DATE '2022-11-10' , 'Conta de Celular' , false , 1 , '50' ), 
( 77 , DATE '2022-11-05' , 'Financiamento Casa' , false , 1 , '1800' ), 
( 78 , DATE '2022-12-05' , 'Salário' , true , 1 , '8500' ), 
( 79 , DATE '2022-12-07' , 'Cartão de crédito' , false , 1 , '1500' ), 
( 80 , DATE '2022-12-23' , 'IPVA' , false , 1 , '2500' ), 
( 81 , DATE '2022-12-25' , 'IPTU' , false , 1 , '1500' ), 
( 82 , DATE '2022-12-06' , 'Faculdade' , false , 1 , '690' ), 
( 83 , DATE '2022-12-10' , 'Conta de Celular' , false , 1 , '50' ), 
( 84 , DATE '2022-12-05' , 'Financiamento Casa' , false , 1 , '1800' ), 
( 85 , DATE '2023-01-05' , 'Salário' , true , 1 , '8500' ), 
( 86 , DATE '2023-01-07' , 'Cartão de crédito' , false , 1 , '1500' ), 
( 87 , DATE '2023-01-23' , 'IPVA' , false , 1 , '2500' ), 
( 88 , DATE '2023-01-25' , 'IPTU' , false , 1 , '1500' ), 
( 89 , DATE '2023-01-06' , 'Faculdade' , false , 1 , '690' ), 
( 90 , DATE '2023-01-10' , 'Conta de Celular' , false , 1 , '50' ), 
( 91 , DATE '2023-01-05' , 'Financiamento Casa' , false , 1 , '1800' ), 
( 92 , DATE '2023-02-05' , 'Salário' , true , 1 , '8500' ), 
( 93 , DATE '2023-02-07' , 'Cartão de crédito' , false , 1 , '1500' ), 
( 94 , DATE '2023-02-23' , 'IPVA' , false , 1 , '2500' ), 
( 95 , DATE '2023-02-25' , 'IPTU' , false , 1 , '1500' ), 
( 96 , DATE '2023-02-06' , 'Faculdade' , false , 1 , '690' ), 
( 97 , DATE '2023-02-10' , 'Conta de Celular' , false , 1 , '50' ), 
( 98 , DATE '2023-02-05' , 'Financiamento Casa' , false , 1 , '1800' );







		