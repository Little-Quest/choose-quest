package com.questing.littlequest.controllers;

//application DB and Models imports
import com.questing.littlequest.models.Choices;
import com.questing.littlequest.models.Prompts;
import com.questing.littlequest.models.Stories;
import com.questing.littlequest.repositories.ChoiceRepository;
import com.questing.littlequest.repositories.PromptRepository;
import com.questing.littlequest.repositories.StoryRepository;

//external imports from Springboot for MVC
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//java imports for classes to help make our server/controller work
import javax.servlet.http.HttpServletRequest;
import java.util.List;

//This controller helps manage all parts of the story play
@Controller
public class StoryController {

    //these lines of "autowired" code help connect the JPA repositories
    //which model tables in our DB to the server/controller
    @Autowired
    StoryRepository storyRepository;

    @Autowired
    PromptRepository promptRepository;

    @Autowired
    ChoiceRepository choiceRepository;

    //populate story choice page with story options from database
    //currently (Aug 2018) DB has two story titles, but second story
    //has no content
    //future plans to further populate databse with more stories
    //long term plans to let users build and populate their own stories
    //for other users to read
    @GetMapping("/story-choice")
    public String storyDisplay(Model model) {
        List<Stories> stories = storyRepository.findAll();
        System.out.println("Stories = " + stories.toString());
        model.addAttribute("stories", stories);
        return "story-choice";
    }

    //deliver story choices on the story choice page
    //currently partially hard coded due to lack of content in DB
    //of other stories
    //future plan to further populate story, prompt and choice tables in DB
    //and get variables working
    @GetMapping("/story/{story_id}")
    public String displayPromptAndChoices(@PathVariable int story_id, Model model) {
        if (story_id == 1) {
            Prompts prompts = promptRepository.findAll().get(0);
            Choices choices = choiceRepository.findAll().get(0);

            model.addAttribute("prompts", prompts);
            model.addAttribute("choices", choices);
        } else {

            //graceful error for missing content
            return "redirect:/error";
        }
        return "story";
    }

    //delivering prompt with stories to the story page as users play
    //currently hard coded by numbers to make it work, rather than variables
    //future goal to get DB variables working
    @GetMapping("/story/{prompt_id}/{choice_id}/{choice_ab_id}")
    public String displayPromptAndChoices(@PathVariable int prompt_id, @PathVariable int choice_id, @PathVariable int choice_ab_id, Model model) {
        if (prompt_id == 1) {
            if (choice_id == 1) {
                if (choice_ab_id == 1) {
                    Prompts prompts = promptRepository.findAll().get(1);
                    Choices choices = choiceRepository.findAll().get(1);
                    model.addAttribute("prompts", prompts);
                    model.addAttribute("choices", choices);
                } else if (choice_ab_id == 2) {
                    Prompts prompts = promptRepository.findAll().get(2);
                    Choices choices = choiceRepository.findAll().get(2);
                    model.addAttribute("prompts", prompts);
                    model.addAttribute("choices", choices);
                }
            }
        }

        if (prompt_id == 2) {
            if (choice_id == 2) {
                if (choice_ab_id == 3) {
                    Prompts prompts = promptRepository.findAll().get(3);
                    model.addAttribute("prompts", prompts);
                    boolean isEnd = true;
                    model.addAttribute("isEnd", isEnd);
                } else if (choice_ab_id == 4) {
                    Prompts prompts = promptRepository.findAll().get(5);
                    model.addAttribute("prompts", prompts);
                    boolean isEnd = true;
                    model.addAttribute("isEnd", isEnd);

                }
            }
        }

        if (prompt_id == 3) {
            if (choice_id == 3) {
                if (choice_ab_id == 5) {
                    Prompts prompts = promptRepository.findAll().get(4);
                    model.addAttribute("prompts", prompts);
                    boolean isEnd = true;
                    model.addAttribute("isEnd", isEnd);
                } else if (choice_ab_id == 6) {
                    Prompts prompts = promptRepository.findAll().get(3);
                    model.addAttribute("prompts", prompts);
                    boolean isEnd = true;
                    model.addAttribute("isEnd", isEnd);
                }
            }
        }
        return "story";
    }

    //graceful error
    @GetMapping("/error")
    public String error(HttpServletRequest request) {
        return "redirect:/error";
    }
}
