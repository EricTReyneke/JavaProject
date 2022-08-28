package com.group_project.app.Service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.group_project.app.Interfaces.AdministratorRepo;
import com.group_project.app.Tables.Administrator;

@Service
public class AdministratorService {

    @Autowired
    private AdministratorRepo repo;

    public List<Administrator> ListAll() {
        return repo.findAll();
    }

    public void Save(Administrator administrator) {
        repo.save(administrator);
    }

    public Administrator Get(Integer admin_id) {
        return repo.findById(admin_id).get();
    }

    public void Delete(Integer admin_id) {
        repo.deleteById(admin_id);
    }
}