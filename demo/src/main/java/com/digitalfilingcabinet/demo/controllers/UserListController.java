package com.digitalfilingcabinet.demo.controllers;


import com.digitalfilingcabinet.demo.models.User;
import com.digitalfilingcabinet.demo.models.data.RoleListRepository;
import com.digitalfilingcabinet.demo.models.data.UserListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.validation.Errors;
import javax.validation.Valid;
import java.util.Optional;

//this controller allows users to be added and viewed.  need to be able to edit/update and delete users

@Controller
@RequestMapping("users")
public class UserListController {

   @Autowired
   private UserListRepository userListRepository;

  @Autowired
   private RoleListRepository roleListRepository;

  @Autowired
  private RelationshipRepository relationshipRepository;

    @GetMapping("")
    public String index(Model model) {

        model.addAttribute("user", userListRepository.findAll());
        return "users/index";
    }
    @GetMapping("add")
    public String displayAddUserForm(Model model) {
        model.addAttribute("title", "Add User");
        model.addAttribute("user", new User());
        return "users/add";
    }

    @PostMapping("add")
    public String processAddUserForm(@ModelAttribute @Valid User newUser, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add User");
            return "users/add";
        }
        userListRepository.save(newUser);
        return "redirect:";
    }



    @GetMapping("view/{userId}")
    public String displayViewUser(Model model, @PathVariable int userId) {

        Optional optUser = userListRepository.findById(userId);
        if (optUser.isPresent()) {
            User user = (User) optUser.get();
            model.addAttribute("user", user);
            return "users/view";
        } else {
            return "redirect:../";

        }
    }

}
