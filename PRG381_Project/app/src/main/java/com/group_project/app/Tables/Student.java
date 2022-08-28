package com.group_project.app.Tables;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Student{
    private int student_id;
    private String student_name;
    private String student_address;
    private String student_email;
    private String student_password;


    public Student() {
    }

    public Student(int student_id, String student_name, String student_address, String student_email, String student_password) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_address = student_address;
        this.student_email = student_email;
        this.student_password = student_password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getStudent_id() {
        return this.student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return this.student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_address() {
        return this.student_address;
    }

    public void setStudent_address(String student_address) {
        this.student_address = student_address;
    }

    public String getStudent_email() {
        return this.student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public String getStudent_password() {
        return this.student_password;
    }

    public void setStudent_password(String student_password) {
        this.student_password = student_password;
    }
}