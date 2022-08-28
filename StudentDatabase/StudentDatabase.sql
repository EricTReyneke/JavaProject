drop database IF EXISTS StudentDetails;
Create database StudentDetails;

Use StudentDetails;
create table Student(Student_ID varChar(10) not null primary key,
Student_Name varChar(20) not null,
Student_Address varChar(20) not null,
Student_Email varChar(20) not null,
Student_Password varChar(20) not null);

 CREATE TABLE Administrator (
 admin_id INT NOT NULL AUTO_INCREMENT,
 admin_name VARCHAR(50) NOT NULL,
 admin_password VARCHAR(50) NOT NULL,
 admin_contact VARCHAR(10) NOT NULL,
 admin_email VARCHAR(50) NOT NULL,
 PRIMARY KEY (admin_id));
 
 CREATE TABLE Register (
 register_id INT NOT NULL AUTO_INCREMENT,
 student_id INT NOT NULL,
 course_name VARCHAR(50) NOT NULL,
 PRIMARY KEY (register_id),
 FOREIGN KEY (student_id) REFERENCES Student(student_id));