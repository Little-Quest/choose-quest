package com.questing.littlequest.controllers;

import com.questing.littlequest.models.Choices;
import com.questing.littlequest.models.Prompts;
import com.questing.littlequest.models.Stories;
import com.questing.littlequest.repositories.ChoiceRepository;
import com.questing.littlequest.repositories.PromptRepository;
import com.questing.littlequest.repositories.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class StoryController {

    @Autowired
    StoryRepository storyRepository;

    @Autowired
    PromptRepository promptRepository;

    @Autowired
    ChoiceRepository choiceRepository;

    @GetMapping("/story-choice")
    public String storyDisplay(Model model) {
        List<Stories> stories = storyRepository.findAll();
        System.out.println("Stories = " + stories.toString());
        model.addAttribute("stories", stories);
        return "story-choice";
    }

//    @GetMapping("/story")
//    public String storyRedirect() {
//        return "story";
//    }

    @GetMapping("/story/{id}")
    public String displayPromptAndChoices(Model model) {
        List<Prompts> prompts = promptRepository.findAll();
        List<Choices> choices = choiceRepository.findAll();

//        Prompts storyPrompt = storyPrompt.story_id;
//        if () {
//        }

        System.out.println(prompts.toString());
        System.out.println(choices.toString());

        int[] numbers = {1, 2, 3};
        model.addAttribute("numbers", numbers);
        model.addAttribute("prompts", prompts);
        model.addAttribute("choices", choices);
//        model.addAttribute("promptid", prompt_id);
//        model.addAttribute("choiceid", choice_id);
        return "story";
    }
}
