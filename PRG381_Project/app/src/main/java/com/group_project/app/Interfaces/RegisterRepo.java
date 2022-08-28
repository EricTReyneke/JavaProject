package com.group_project.app.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group_project.app.Tables.Register;

public interface RegisterRepo extends JpaRepository<Register, Integer>{
    
}