package com.group_project.app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.group_project.app.Interfaces.StudentRepo;
import com.group_project.app.Tables.Student;
import java.util.List;

@Service
public class StudentService{

    @Autowired
    private StudentRepo repo;

    public List<Student> ListAll() {
        return repo.findAll();
    }

    public void Save(Student student) {
        repo.save(student);
    }

    public Student Get(Integer student_id) {
        return repo.findById(student_id).get();
    }

    public void Delete(Integer student_id) {
        repo.deleteById(student_id);
    }
}