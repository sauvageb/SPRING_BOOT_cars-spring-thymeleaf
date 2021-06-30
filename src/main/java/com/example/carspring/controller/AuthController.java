package com.example.carspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class AuthController {

    @RequestMapping(value = "/login")
    public String displayLogin() {
        return "login";
    }

    @GetMapping("/auth/logout")
    public String displayLogoutPage() {
        return "/auth/logout";
    }

    @PostMapping("/auth/leave")
    public String logout(HttpSession session, @RequestParam("leave") boolean leaveOk) {
        if (leaveOk) {
            session.invalidate();
        }
        return "redirect:/login";
    }


}
