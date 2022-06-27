package com.example.smartcontactmanagerproject.controller;

import com.example.smartcontactmanagerproject.dao.UserRepository;
import com.example.smartcontactmanagerproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/index")
    public String adminHome(Model model, Principal principal) {
        System.out.println(principal.getName() + " is the username");
        model.addAttribute("title", "Admin Dashboard");
        addCommonData(model, principal);
        return "admin/admin_dashboard";
    }

    @ModelAttribute
    public void addCommonData(Model model, Principal principal) {
        String userEmail = principal.getName();
        System.out.println("Email = "+userEmail);
        User user = this.userRepository.getUserByEmailNative(userEmail);
        model.addAttribute("user", user);
    }
}
