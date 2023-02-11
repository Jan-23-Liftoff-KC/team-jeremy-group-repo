package com.digitalfilingcabinet.demo.controllers;


import com.digitalfilingcabinet.demo.models.User;
import com.digitalfilingcabinet.demo.models.data.UserListRepository;
import com.digitalfilingcabinet.demo.models.data.RoleListRepository;
import com.digitalfilingcabinet.demo.models.data.UserListRepository;
import com.digitalfilingcabinet.demo.models.data.RelationshipListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.validation.Errors;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Optional;

//this controller allows users to be viewed and searched by different criteria.


@Controller
@RequestMapping("users")
public class UserListController {

   @Autowired
   private UserListRepository userListRepository;

  @Autowired
   private RoleListRepository roleListRepository;

  @Autowired
  private RelationshipListRepository relationshipListRepository;

    @GetMapping("")
    public String index(Model model) {

        model.addAttribute("user", userListRepository.findAll());
        return "users/index";
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
