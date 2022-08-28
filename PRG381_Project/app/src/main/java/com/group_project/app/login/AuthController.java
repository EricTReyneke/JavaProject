package com.group_project.app.login;


import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // handler method to handle home page request
    @GetMapping("")
    public String home(){
        return "Login";
    }

    // method to handle user registration form request
    @GetMapping("/Details")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "Details";
    }

    // method to handle user registration form submit request
    @PostMapping("/Details/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){
        AppUser existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/Details";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

    // handler method to handle list of users
    @GetMapping("/Details")
    public String users(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("Details", users);
        return "Details";
    }

    // handler method to handle login request
    @GetMapping("/Login")
    public String Login(){
        return "Login";
    }
}