package com.example.demo.controllers;

import com.example.demo.models.controlUser;
import com.example.demo.repo.controlUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

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

    @PostMapping
    public String addUser(@RequestParam String username, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateEnd, Model model) {
        LocalDateTime dateStart = LocalDateTime.now();
        controlUser user = new controlUser(username, dateStart, dateEnd);
        controlUserRepository.save(user);
        return "main";
    }

}
