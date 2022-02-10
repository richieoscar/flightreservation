package com.richieoscar.flightreservation.controller;

import com.richieoscar.flightreservation.model.AppUser;
import com.richieoscar.flightreservation.service.SecurityService;
import com.richieoscar.flightreservation.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userservice;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    SecurityService securityService;


    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);


    @RequestMapping("/registration")
    public String registerUser() {
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute AppUser appUser, Model model) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        userservice.registerUser(appUser);
        model.addAttribute("username", appUser.getFirstName());
        return "login";

    }

    @RequestMapping("/showLogin")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
        logInfo("loginUser()");
        boolean loginResponse = securityService.login(email, password);

        if (loginResponse) {
            model.addAttribute("username", email);
            logInfo("LoginUSer retruns: " + email);
            return "dashboard";
        } else {
            model.addAttribute("error", "Invalid Details");
        }

        return "login";

    }

    private void logInfo(String info) {
        LOGGER.info(info);
    }

    private void logError(String error) {
        LOGGER.error(error);
    }
}
