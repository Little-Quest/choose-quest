package com.questing.littlequest.controllers;

import com.questing.littlequest.models.Users;
import com.questing.littlequest.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@SessionAttributes("username")
public class UserController {


    @Autowired
    UserRepository userRepository;


    @PostMapping("/register")
    public ModelAndView createUser (@RequestParam String username, @RequestParam String password, Model model){
        List<Users> usersList = userRepository.findByUsername(username);

        System.out.println(Arrays.toString(new List[]{usersList}));
        ModelAndView mv = new ModelAndView();

        if (usersList.size() != 0){
            mv.setViewName("login-error");
            mv.addObject("error", "That username already exists. Please choose another.");
        } else {
            String passhash = BCrypt.hashpw(password, BCrypt.gensalt(12));
            Users user = userRepository.save(new Users(username, passhash));
            System.out.println("Succesfully added user: " + username);
            mv.setViewName("index");
        }

        model.addAttribute("username", username);
        model.addAttribute("password", password);
//        return "redirect:/";
        return mv;
    }
}
