package com.digitalfilingcabinet.demo.controllers;

import com.digitalfilingcabinet.demo.models.dto.LoginFormDTO;
import javax.servlet.http;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

//this allows a user to login
public class HomeController {




//this allows a user to login

    @Controller
    public class HomeController {

        @GetMapping("/login")
        public String displayLoginForm(Model model) {
            model.addAttribute(new LoginFormDTO());
            model.addAttribute("title", "Log In");
            return "login";
        }

        @PostMapping("/login")
        public String processLoginForm(@ModelAttribute @Valid LoginFormDTO loginFormDTO, Errors errors, HttpServletRequest request, Model model) {
            if (errors.hasErrors()) {
                model.addAttribute("title", "Log In");
                return "login";
            }

            User theUser = userRepository.findByUsername(loginFormDTO.getUsername());

            if (theUser == null) {
                errors.rejectValue("username", "user.invalid", "The given username does not exist");
                model.addAttribute("title", "Log In");
                return "login";
            }

            String password = loginFormDTO.getPassword();

            if (!theUser.isMatchingPassword(password)) {
                errors.rejectValue("password", "password.invalid", "Invalid password");
                model.addAttribute("title", "Log In");
                return "login";
            }

            setUserInSession(request.getSession(), theUser);

            return "redirect:";
        }
        }

    }

