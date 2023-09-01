package com.study.boardTwo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MemberController {

    private Map<String, String> userMap = new HashMap<>();

    @GetMapping("/signup")
    public String showSignupForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@RequestParam String username, @RequestParam String password) {
        userMap.put(username, password);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        if (userMap.containsKey(username) && userMap.get(username).equals(password)) {
            model.addAttribute("username", username);
            return "welcome";
        } else {
            return "login";
        }
    }
}
