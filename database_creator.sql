-- MySQL
create database StudentDB;
use StudentDB;
grant all on StudentDB.* to 'admin'@'localhost' identified by 'test';

CREATE TABLE StudentDB.`students` (
  `studentId` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `dateOfBirth` date DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`studentId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8