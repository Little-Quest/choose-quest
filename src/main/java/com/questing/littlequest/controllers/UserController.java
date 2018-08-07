package com.questing.littlequest.controllers;

import com.questing.littlequest.models.Users;
import com.questing.littlequest.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
//@RequestMapping("/login")
@SessionAttributes("username")
public class UserController {


    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String homepage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        //I wanted a more meaningful and easily read console log to follow the program through
        System.out.println("From UserController: \n"
                + "Session ID: " + session.getId() + " for User " + "\"" + username + "\""
                + "\n" + "Logged In = " + session.getAttribute("loggedin") + "\n");

        //Only change the value of username to "user" if the logged in session is false/null
        if (session.getAttribute("loggedin") == null) {
            model.addAttribute("username", "user");
        }
        //If the session is null, the user name will be set to user. If the session above is not null, then
        //the username will persist from the previous session.
        if (username != null) {
            model.addAttribute("username", username);
        }
        return "login";
    }


    @PostMapping("/register")
    public ModelAndView createUser (@RequestParam String username, @RequestParam String password, Model model, HttpServletRequest request){
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
            HttpSession session = request.getSession();
            session.setAttribute("loggedin", true);
        }

        model.addAttribute("username", username);
        model.addAttribute("password", password);
        return mv;
    }
}
