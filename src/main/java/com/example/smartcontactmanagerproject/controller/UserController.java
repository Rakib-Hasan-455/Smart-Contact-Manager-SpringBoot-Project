package com.example.smartcontactmanagerproject.controller;

import com.example.smartcontactmanagerproject.dao.UserRepository;
import com.example.smartcontactmanagerproject.entity.Contact;
import com.example.smartcontactmanagerproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/index")
    public String userDashboard(Model model, Principal principal) {
        model.addAttribute("title", "User Dashboard");
        addCommonData(model, principal);
        return "user/user_dashboard";
    }

    @RequestMapping("/add-contact")
    public String openAddContactForm(Model model, Principal principal) {
        model.addAttribute("contact", new Contact());
        model.addAttribute("title", "Add Contact");
        addCommonData(model, principal);
        return "user/add_contact_form";
    }

    @PostMapping("/process-add-contact")
    public String processAddContact(Model model, Principal principal) {
        model.addAttribute("contact", new Contact());
        model.addAttribute("title", "Add Contact");
        addCommonData(model, principal);
        return "user/add_contact_form";
    }

    @ModelAttribute
    public void addCommonData(Model model, Principal principal) {
        String userEmail = principal.getName();
        System.out.println("Email = "+userEmail);
        User user = this.userRepository.getUserByEmailNative(userEmail);
        model.addAttribute("user", user);
    }

}
