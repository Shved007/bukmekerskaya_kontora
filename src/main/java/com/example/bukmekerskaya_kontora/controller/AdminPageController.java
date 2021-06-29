package com.example.bukmekerskaya_kontora.controller;

import com.example.bukmekerskaya_kontora.config.Verification;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AdminPageController {
    @Value("${admin.login}")
    private String login;
    @Value("${admin.password}")
    private String password;

    @GetMapping(value = "/verification")
    public String showVerificationForm(Model model){
        model.addAttribute("title","Verification Page");
        model.addAttribute("verification",new Verification());
        return "admin/verification";
    }

    @PostMapping(value = "verification")
    public String verification(@ModelAttribute("verification") Verification verification){
        if (verification.getLogin().equals(login)&&verification.getPassword().equals(password)){
            return "redirect:/adminPage";
        }
        return "redirect:/homePage";
    }

    @GetMapping(value = "/adminPage")
    public String showAdminPage(Model model){
        model.addAttribute("title","Admin Page");
        return "admin/adminPage";
    }


}
