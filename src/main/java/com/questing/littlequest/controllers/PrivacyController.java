package com.questing.littlequest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/private")
public class PrivacyController {


    /*
    Check about the correct routing for privacy checker instead of using the wildcard
     */


    @RequestMapping("/*")
    public ModelAndView handlePrivateRequests(HttpServletRequest request, Model model) {
        String servlet = request.getServletPath();
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();

        boolean isLoggedIn = (boolean) session.getAttribute("loggedin");
        if (isLoggedIn) {
            mv.setViewName("story");
            String username = (String) session.getAttribute("username");

        } else {
            //setting username to null if the session is not logged in
            model.addAttribute("username", null);
            mv.setViewName("accessdenied");
        }

        //I wanted a more meaningful and easily read console log to follow the program through
        System.out.println("From Private Controller:"
                + "\n" + "Logged In = " + session.getAttribute("loggedin") + "\n");

        return mv;
    }
}