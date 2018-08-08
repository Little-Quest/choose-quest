package com.questing.littlequest.controllers;

import com.questing.littlequest.models.Stories;
import com.questing.littlequest.repositories.ChoiceRepository;
import com.questing.littlequest.repositories.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StoryController {

    @Autowired
    StoryRepository storyRepository;

    @Autowired
    ChoiceRepository choiceRepository;

    @GetMapping("/story-choice")
    public String storyDisplay(Model model) {
        List<Stories> stories = storyRepository.findAll();
        System.out.println("Stories = " + stories.toString());
        model.addAttribute("stories", stories);
        return "redirect:/story-choice";
    }
}
