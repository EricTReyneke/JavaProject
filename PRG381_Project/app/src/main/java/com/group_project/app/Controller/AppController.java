package com.group_project.app.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.group_project.app.Service.*;
import com.group_project.app.Tables.*;;

public class AppController {
    @Autowired
    private AdministratorService Administratorservice;

    @Autowired
    private StudentService StudentService;

    @Autowired
    private RegisterService RegisterService;

    int StudentIDMain = -1; 
    
    @GetMapping("")
    public String ViewHomePage() {
        return "index";
    }

    @GetMapping("/viewCrouses")
    public String GetCrouses(Model model) {
        List<Register> listRegister = RegisterService.ListAll();
        Set<String> set = new HashSet<>(listRegister.size());
        listRegister.removeIf(p -> !set.add(p.getCourse_name()));
        model.addAttribute("listcrouse", listRegister);
        return "courseView";
    } 

    @GetMapping("/removeStudents")
    public String GetDeleteStudnet() {
        return "removeStudent";
    } 

    @RequestMapping("/updateStudent")
    public String updateStudents(Model model) {
        Student existingStudent = StudentService.Get(StudentIDMain);
        model.addAttribute("student_id", existingStudent.getStudent_id());
        model.addAttribute("student_name", existingStudent.getStudent_name());
        model.addAttribute("student_address", existingStudent.getStudent_address());
        model.addAttribute("student_email", existingStudent.getStudent_email());
        model.addAttribute("student_password", existingStudent.getStudent_password());
        return "studentupdate";
    }
    
    @RequestMapping("/viewStudents")
    public String viewStudents(Model model) {
    List<Student> liststudents = StudentService.ListAll();
    model.addAttribute("liststudents", liststudents);
    return "studentsview";
    }

    @PostMapping("/removestudentconfirm")
    public String  addStudent(@RequestBody String studentBody , Model model) {
        List<Register> listRegister = RegisterService.ListAll();
        List<Integer> listInt = new ArrayList<Integer>();
        try {
            String[] arrAnd = studentBody.split("&");
            String id = "";
            id = arrAnd[1].split("=")[1];
            
            for (Register list : listRegister) {
                if (list.getStudent_id() == Integer.parseInt(id)) {
                    listInt.add(list.getRegister_id());
                }
            }

            for (Integer num : listInt) {
                RegisterService.Delete(num);
            }

           StudentService.Delete(Integer.parseInt(id));
           List<Student> liststudents = StudentService.ListAll();
           model.addAttribute("liststudents", liststudents);
            return "studentsview";

        } catch (Exception e) {
            return "removeStudent";
        }
    }

}
