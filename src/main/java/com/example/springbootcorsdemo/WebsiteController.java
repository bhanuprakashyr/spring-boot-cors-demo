package com.example.springbootcorsdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebsiteController {
    @GetMapping(value = "/website", produces = "text/html")
    public String website(Model model) {
        return "SimpleWebsite";
    }
}
