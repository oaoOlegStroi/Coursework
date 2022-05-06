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

import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MINUTES;

@Controller
public class MainController {

    @Autowired
    private controlUserRepository controlUserRepository;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("title", "Система управления посещаемости батутного центра");
        Iterable<controlUser> users = controlUserRepository.findAll();
        model.addAttribute("users", users);
        return "main";
    }

    @GetMapping("/addUser")
    public String addUserPage(Model model) {
        return "addUser";
    }
    @PostMapping("/addUser")
    public String addUser(@RequestParam String username, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateEnd, Model model) {
        controlUser user = new controlUser(username, dateEnd);
        controlUserRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/updateTable")
    public String updateTablePage(Model model) {
        return "updateTable";
    }

    @PostMapping("/updateTable")
    public String updateTable(Model model) {
        long el = 30;
        controlUser user = controlUserRepository.findById(el).orElseThrow();
        LocalDateTime tempDate = LocalDateTime.now();
        LocalDateTime endDate = user.getEnd_time();
        System.out.println(tempDate);
        System.out.println(endDate);

        if(tempDate.truncatedTo(MINUTES)
                .isBefore(endDate.truncatedTo(MINUTES)))
        {
            //Проверка прошла успешно, дата начала раньше чем дата окончания
        }
        else
        {
            user.setIsTimeEnd(true);
            controlUserRepository.save(user);
        }

        return "redirect:/";
    }

}
