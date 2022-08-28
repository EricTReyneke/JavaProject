package com.group_project.app.Service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group_project.app.Interfaces.RegisterRepo;
import com.group_project.app.Tables.Register;

@Service

public class RegisterService {
    @Autowired
    private RegisterRepo repo;

    public List<Register> ListAll() {
        return repo.findAll();
    }

    public void Save(Register register) {
        repo.save(register);
    }

    public Register Get(Integer register_id) {
        return repo.findById(register_id).get();
    }

    public void Delete(Integer register_id) {
        repo.deleteById(register_id);
    }
}