package com.group_project.app.login;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.group_project.app.Service.AdministratorService;
import com.group_project.app.Service.StudentService;
import com.group_project.app.Tables.Administrator;
import com.group_project.app.Tables.Student;

@Controller
public class AuthController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private AdministratorService adminService;
    
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // handler method to handle home page request
    @GetMapping("")
    public String home(){
        return "Login";
    }

    // method to handle user registration form submit request
    @PostMapping("/AdminData/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){
        AppUser existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null, "There is already an account");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/AdminData";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

    @GetMapping("/AdminDetails")
    public ModelAndView GetAdminDetails(@PathVariable("AdminDetails") String AdminDetails) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("AdminDetails/" + AdminDetails);
        return modelAndView;
    }

    @GetMapping("/UserDetails")
    public String GetUserDetails(Model model) {
        List<Student> list = studentService.ListAll();
        model.addAttribute("list", list);
        return "UserDetails";
    }

    
    @GetMapping("/AdminData")
    public String GetAdminDetails(Model model) {
        List<Student> list = studentService.ListAll();
        model.addAttribute("list", list);
        return "AdminData";
    }

    // handler method to handle login request
    @GetMapping("/Login")
    public String Login(){
        return "Login";
    }
}