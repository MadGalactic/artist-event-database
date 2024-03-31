package com.myprojects.artisteventsdb.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("headingText", "Welcome");
        return "index";
    }

}
