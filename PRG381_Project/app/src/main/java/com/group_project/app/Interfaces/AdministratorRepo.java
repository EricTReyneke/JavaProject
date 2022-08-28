package com.group_project.app.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.group_project.app.Tables.Administrator;

public interface AdministratorRepo extends JpaRepository<Administrator, Integer>{
    
}

