package com.digitalfilingcabinet.demo.controllers;


<<<<<<< HEAD
=======
<<<<<<< HEAD
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

=======
>>>>>>> 03d95b6758675711249db435258ed1c113837c70
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


<<<<<<< HEAD
=======
>>>>>>> dev
>>>>>>> 03d95b6758675711249db435258ed1c113837c70
@Controller
@RequestMapping("users")
public class UserListController {

<<<<<<< HEAD
=======
<<<<<<< HEAD
    @Autowired
    private UserListRepository userListRepository;

    @GetMapping("")
    private String index(Model model){
        model.addAttribute("users", userListRepository.findAll());
        return "users/index";
    }

    @GetMapping("add")
    private String displayAddUserForm(Model model){
        model.addAttribute(new UserList());
        return "users/add";
    }

    @PostMapping("add")
    public String processAddUserForm(@ModelAttribute @Valid UserList newUser, Errors errors, Model model) {
        if(errors.hasErrors()){
            model.addAttribute("users", newUser);
            return "users/add";
        }
        model.addAttribute("users", newUser);
        userListRepository.save(newUser);
        return "redirect:";
    }

    @PostMapping("view/{userId}")
    public String displayViewUser (Model model, @PathVariable int userId){

        Optional<UserList> optUserList = userListRepository.findById(userId);
        if(optUserList.isPresent()){
            UserList userList = (UserList) optUserList.get();
            model.addAttribute("users", userList);
            return "users/view";
        } else {
            return "redirect:../";
        }
    }
=======
>>>>>>> 03d95b6758675711249db435258ed1c113837c70
   @Autowired
   private UserListRepository userListRepository;

  @Autowired
   private RoleListRepository roleListRepository;

  @Autowired
<<<<<<< HEAD
  private RelationshipListRepository relationshipListRepository;
=======
  private RelationshipRepository relationshipRepository;
>>>>>>> 03d95b6758675711249db435258ed1c113837c70

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

<<<<<<< HEAD
=======
>>>>>>> dev
>>>>>>> 03d95b6758675711249db435258ed1c113837c70
}
