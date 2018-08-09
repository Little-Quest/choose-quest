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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @GetMapping("/story/{story_id}")
    public String displayPromptAndChoices(@PathVariable int story_id, Model model) {
        if (story_id == 1) {
            List<Prompts> prompts = promptRepository.findAll().subList(0, 1);
            List<Choices> choices = choiceRepository.findAll().subList(0, 1);
            System.out.println(prompts.toString());
            System.out.println(choices.toString());

            model.addAttribute("prompts", prompts);
            model.addAttribute("choices", choices);
        } else {
            return "redirect:/error";
        }

        return "story";
    }

    @GetMapping("/story/{prompt_id}/{choice_id}/{choice_ab_id}")
    public String displayPromptAndChoices(@PathVariable int prompt_id, @PathVariable int choice_id, @PathVariable int choice_ab_id, Model model) {
        if (prompt_id == 1) {
            if (choice_id == 1) {
                if (choice_ab_id == 1) {
                    List<Prompts> prompts = promptRepository.findAll().subList(1, 2);
                    List<Choices> choices = choiceRepository.findAll().subList(1, 2);
                    model.addAttribute("prompts", prompts);
                    model.addAttribute("choices", choices);
                } else if (choice_ab_id == 2) {
                    List<Prompts> prompts = promptRepository.findAll().subList(2, 3);
                    List<Choices> choices = choiceRepository.findAll().subList(2, 3);
                    model.addAttribute("prompts", prompts);
                    model.addAttribute("choices", choices);
                    System.out.println("Prompt = " + prompts);
                    System.out.println("choices = " + choices);
                }
            }
        } else {
            return "redirect:/error";
        }

        return "story";
    }

    //graceful error
    @GetMapping("/error")
    public String error(HttpServletRequest request) {

        return "redirect:/error";
    }
}
