package com.example.demo.controllers;

import com.example.demo.models.controlUser;
import com.example.demo.repo.controlUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private controlUserRepository controlUserRepository;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("title", "Батутный центр");
        Iterable<controlUser> users = controlUserRepository.findAll();
        model.addAttribute("users", users);
        return "main";
    }

}
