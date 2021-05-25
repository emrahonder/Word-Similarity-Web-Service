package com.nioya.similarity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    private final static String HOME_TEMPLATE = "home";

    @GetMapping("/")
    public String main(Model model) {
        return HOME_TEMPLATE;
    }
}
