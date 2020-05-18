create table CAR (
  id IDENTITY primary key,
  brand VARCHAR2(150),
  model VARCHAR2(200),
  power DOUBLE,
  year_of_issue YEAR,
  assessed_value DEC(20)
);

INSERT INTO CAR VALUES(1, 'Mersedes', 'GL', 200, 2015, 20000);
INSERT INTO CAR VALUES(2, 'AUDI', 'A6', 220, 2018, 22000);
INSERT INTO CAR VALUES(3, 'Porshe', 'Macan', 230, 2019, 40000);

create table AIRPLANE (
  id IDENTITY primary key,
  brand VARCHAR2(150),
  model VARCHAR2(200),
  manufacturer VARCHAR2(500),
  year_of_issue YEAR,
  fuel_capacity INT,
  seats INT,
  assessed_value DECIMAL(20)
);

INSERT INTO AIRPLANE VALUES(1, 'Boeing', '737', 'USA', 2009, 5000, 200, 2000000);
INSERT INTO AIRPLANE VALUES(2, 'Boeing', '757', 'USA', 2006, 5500, 220, 2200000);
INSERT INTO AIRPLANE VALUES(3, 'TU', '154', 'RU', 2008, 4000, 120, 1000000);

create table ASSESSED_VALUE
(
	id IDENTITY primary key,
	collateral_id BIGINT,
	assessed_cost DECIMAL (20),
	date_time DATETIME
);

 INSERT INTO ASSESSED_VALUE VALUES(1, 1, 20000,  '2005-12-31 23:59:59-10:00');
 INSERT INTO ASSESSED_VALUE VALUES(2, 1, 20500, '2005-12-31 23:59:59-12:00');