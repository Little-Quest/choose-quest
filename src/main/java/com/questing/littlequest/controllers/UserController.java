package com.questing.littlequest.controllers;

//application DB models and repositories
import com.questing.littlequest.models.Users;
import com.questing.littlequest.repositories.UserRepository;

//encryption library for user password security
import org.mindrot.jbcrypt.BCrypt;

//Springboot MVC libraries for controller, model and view functionality
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//Java libraries for help with basic server and program functionality
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

//This controller helps manage all parts of user interaction
@Controller
@SessionAttributes("username")
public class UserController {

    //these lines of "autowired" code help connect the JPA user repository
    //which models the user table in our DB to the server/controller
    @Autowired
    UserRepository userRepository;

    //manage user interaction with application of sign up and login
    @GetMapping("/portal")
    public String portalPage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        System.out.println("session = " + session);
        String username = (String) session.getAttribute("username");

        //Meaningful console log to follow the program through
        System.out.println("From UserController: \n"
                + "Session ID: " + session.getId() + " for User " + "\"" + username + "\""
                + "\n" + "Logged In = " + session.getAttribute("loggedin") + "\n");

        //Only change the value of username to "user" if the logged in session is false/null
        Object rawIsLoggedIn = session.getAttribute("loggedin");
        boolean isLoggedIn = false;
        if (rawIsLoggedIn != null) {
            isLoggedIn = (boolean) rawIsLoggedIn;
        }
        if (!isLoggedIn) {
            model.addAttribute("username", "user");
            model.addAttribute("isLoggedIn", isLoggedIn);
        } else {
            model.addAttribute("isLoggedIn", isLoggedIn);
        }

        //If the session is null, the user name will be set to user.
        // If the session above is not null, then
        //the username will persist from the previous session.
        if (username != null) {
            model.addAttribute("username", username);
        }
        return "portal";
    }

    //Log in a returning user
    @PostMapping("/login")
    public ModelAndView login(
            HttpServletRequest request,
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ) {
        ModelAndView mv = new ModelAndView();

        //needed to check if the username coming back actually exists
        List<Users> checkUsername = userRepository.findByUsername(username);
        System.out.println("CheckUsername from List = " + checkUsername.toString());

        //needed to call the method of checkPassword on this instance of user
        Users user = userRepository.findUsersByUsername(username);

        //if the list of usernames is empty, it means the username entered does not exist
        if (checkUsername.size() == 0) {
            mv.setViewName("login-error");
            mv.addObject("error", "Username not found. Please choose another or register.");
        } else {
            boolean isCorrectPassword = user.checkPassword(password);
            System.out.println("checkPassword = " + user.checkPassword(password));
            if(isCorrectPassword) {
                mv.setViewName("redirect:/story-choice");
                mv.addObject("username", username);

                HttpSession session = request.getSession();
                session.setAttribute("loggedin", true);
                session.setAttribute("username", username);
                session.setAttribute("user_id", user.user_id);
                session.setAttribute("user", user);

                boolean isLoggedIn = true;
                model.addAttribute("isLoggedIn", isLoggedIn);
            } else {
                mv.setViewName("login-error");
                mv.addObject("error", "Wrong password. Try again.");
            }
        }
        return mv;
    }

    //register a new user
    @PostMapping("/register")
    public ModelAndView createUser (@RequestParam String username,
                                    @RequestParam String password,
                                    Model model,
                                    HttpServletRequest request){

        List<Users> checkUsername = userRepository.findByUsername(username);
        System.out.println(Arrays.toString(new List[]{checkUsername}));
        ModelAndView mv = new ModelAndView();

        if (checkUsername.size() != 0){
            mv.setViewName("login-error");
            mv.addObject("error", "That username already exists. Please choose another.");
        }

        String passhash = BCrypt.hashpw(password, BCrypt.gensalt(12));
        Users user = userRepository.save(new Users(username, passhash));
        System.out.println("Succesfully added user: " + username);

        mv.setViewName("redirect:/story-choice");
        mv.addObject("username", username);

        HttpSession session = request.getSession();
        session.setAttribute("loggedin", true);
        session.setAttribute("username", username);
        session.setAttribute("user_id", user.user_id);
        session.setAttribute("user", user);

        boolean isLoggedIn = true;
        model.addAttribute("isLoggedIn", isLoggedIn);

        return mv;
    }

    //manage user logging out and resetting session attributes accordingly
    @PostMapping("/logout")
    public String logout(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        session.setAttribute("loggedin", false);

        //Once a user has been logged out(as opposed to never having visited), the user name will be set to
        //"user" so it will work with the thymleaf template
        String username = (String) session.getAttribute("username");
        boolean isLoggedIn = (boolean) session.getAttribute("loggedin");
        if (!isLoggedIn) {
            username = "user";
            model.addAttribute("username", "user");
            model.addAttribute("isLoggedIn", isLoggedIn);

        }

        //Once the username is not null (as it would be if the visitor has never visited before)
        //the user name is set. Both the if statement above and this one are necessary for the thymleaf
        //to get the information it needs for proper user info
        if (username != null) {
            model.addAttribute("username", username);
        }

        //Meaningful console log to follow the program through
        System.out.println("From Logout Page: \n"
                + "Session ID: " + session.getId() + " for User " + "\"" + username + "\""
                + "\n" + "Logged In = " + session.getAttribute("loggedin") + "\n");

        model.addAttribute("isLoggedIn", isLoggedIn);
        return "index";
    }

    //delete a currently existing user, with user confirmation that they want to be deleted
    @GetMapping("/delete")
    public ModelAndView deleteUser (HttpServletRequest request, Model model) {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        Long userid = (Long) session.getAttribute("user_id");
        Users user = (Users) session.getAttribute("user");

        List<Users> du1 = userRepository.removeByUsername(user.username);
        System.out.println("DU1 = " + du1);

        String du2 = userRepository.deleteByUsername(user.username);
        System.out.println("DU2 = " + du2);

        mv.setViewName("delete");
        mv.addObject("error", "Please click the button below to verify you wish to be erased from our users list completely. We'll miss you! Register again if you'd like to come back.");

        boolean isLoggedIn = false;
        model.addAttribute("isLoggedIn", isLoggedIn);

        return mv;
    }
}
