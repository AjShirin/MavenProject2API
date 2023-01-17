create database MavenApi;
USE MavenApi;

CREATE TABLE Mytable(
	ID Integer Primary Key identity (1,1),
   	common VARCHAR(100),
	cca2 VARCHAR(100),
	ccn3 VARCHAR(100),
	cca3 VARCHAR(100),
	cioc VARCHAR(100),
     independent tinyInt,
	 status VARCHAR(100),
	region VARCHAR(100),
	 flag VARCHAR(100),
     fifa VARCHAR(100),
	startOfWeek VARCHAR(100));

Select * From RandomTable;

DROP TABLE Mytable;