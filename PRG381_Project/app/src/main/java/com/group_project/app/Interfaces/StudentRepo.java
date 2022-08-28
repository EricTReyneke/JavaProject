package com.group_project.app.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import com.group_project.app.Tables.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{
    
}