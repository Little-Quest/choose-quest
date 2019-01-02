package com.questing.littlequest.controllers;

//external imports from Springboot for MVC
import com.questing.littlequest.models.Stories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//for delivering content pages about the application itself
@Controller
public class AboutController {
    @GetMapping("/about-us")
    public String about(Model model) {
        model.addAttribute("about-us", model);
        return "about-us";
    }

    @GetMapping("/coming-soon")
    public String comingSoon(Model model) {
        model.addAttribute("coming-soon", model);
        return "coming-soon";
    }
}
