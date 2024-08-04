package com.tingyu.system.controller;

import com.tingyu.system.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class MainController {
    @Autowired
    UserService userService;

    @RequestMapping("/")
    public RedirectView home(HttpSession session) {
        if (session.getAttribute("username") == null) return new RedirectView("/login");

        return new RedirectView("/home");
    }

    @RequestMapping("/login")
    public String login() {
        return "this is login";
    }

    @RequestMapping("/home")
    public String index() {
        return "this is home";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
