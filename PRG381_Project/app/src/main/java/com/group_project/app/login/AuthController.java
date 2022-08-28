package com.group_project.app.login;


import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
    @GetMapping("/AdminData")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "AdminData";
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
    public ModelAndView GetUserDetails(@PathVariable("UserDetails") String AdminDetails) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("UserDetails/" + AdminDetails);
        return modelAndView;
    }

    // handler method to handle login request
    @GetMapping("/Login")
    public String Login(){
        return "Login";
    }
}