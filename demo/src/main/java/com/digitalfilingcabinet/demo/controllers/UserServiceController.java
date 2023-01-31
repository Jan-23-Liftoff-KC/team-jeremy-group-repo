package com.digitalfilingcabinet.demo.controllers;

import com.digitalfilingcabinet.demo.models.User;

import java.util.List;
//not sure if this should be its own controller or on the userlistcontroller.  this allows for editing of the user roles
//will need to include ability to "add user (although this is created when they register...however no permissions
//is the default or does admin then need to go in and edit the new user to assign role?  Also will need to add
//within the edit form a way to delete the user
public class UserServiceController {

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        User user = service.get(id);
        List<Role> roleList = service.roleList();
        model.addAttribute("user", user);
        model.addAttribute("roleList", roleList);
        return "user_form";
    }

    @PostMapping("/users/save")
    public String saveUser(User user) {
        service.save(user);
        return "redirect:/users";
    }
}
