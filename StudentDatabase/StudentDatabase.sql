drop database IF EXISTS StudentDetails;
Create database StudentDetails;

Use StudentDetails;


 CREATE TABLE Administrator (
 admin_id INT NOT NULL AUTO_INCREMENT,
 admin_name VARCHAR(50) NOT NULL,
 admin_password VARCHAR(50) NOT NULL,
 admin_contact VARCHAR(10) NOT NULL,
 PRIMARY KEY (admin_id));
 
CREATE TABLE Student (
 student_id INT NOT NULL AUTO_INCREMENT,
 student_name VARCHAR(50) NOT NULL,
 student_address VARCHAR(50) NOT NULL,
 student_email VARCHAR(50) NOT NULL,
 student_password VARCHAR(50) NOT NULL,
 PRIMARY KEY (student_id));
 
 CREATE TABLE Register (
 register_id INT NOT NULL AUTO_INCREMENT,
 student_id INT NOT NULL,
 course_name VARCHAR(50) NOT NULL,
 PRIMARY KEY (register_id),
 FOREIGN KEY (student_id) REFERENCES Student(student_id));
 
 INSERT INTO Administrator VALUES (1, "Eric", "sadgadf", "0234211025"); 
 INSERT INTO Student VALUES (1, "Eric", "Earth", "asdfsfd@gmail.com", "123"); 
 INSERT INTO Student VALUES (2, "Arie", "Mars", "sdfsdf@gmail.com", "sdf3");