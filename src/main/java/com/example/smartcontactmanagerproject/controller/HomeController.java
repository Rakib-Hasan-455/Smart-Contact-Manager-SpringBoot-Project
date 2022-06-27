package com.example.smartcontactmanagerproject.controller;

import com.example.smartcontactmanagerproject.dao.UserRepository;
import com.example.smartcontactmanagerproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Home - Smart Contact Manager");
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About - Smart Contact Manager");
        return "about";
    }

    @GetMapping("/signup")
    public String signUp(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "Signup - Smart Contact Manager");
        return "signup";
    }

    @RequestMapping(value = "/process-signup", method = RequestMethod.POST)
    public String doSignUp(@Valid @ModelAttribute User user, BindingResult bindingResult, @RequestParam(value = "agreed", defaultValue = "false") boolean agreed, Model model) {
        System.out.println("Agreed = " + agreed);
        user.setRole("ROLE_USER");
        user.setEnabled(true);
        user.setImageURL("default.jpg");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println(user);
        if (this.userRepository.getUserByEmailNative(user.getEmail()) != null) {
            System.out.println("User Already Registered With this Email");
             bindingResult.rejectValue("email", "error.user", "An account already exists for this email.");
        }

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            model.addAttribute("title", "Signup - Smart Contact Manager");
            return "signup";
        }
        model.addAttribute("successMsg", "successfully signed up. Please Login!");
        model.addAttribute("successMsgType", "alert-success");
        this.userRepository.save(user);
        return "signup";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }


}
