package com.digitalfilingcabinet.demo.controllers;


import com.digitalfilingcabinet.demo.models.data.*;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import com.digitalfilingcabinet.demo.models.*;
import com.digitalfilingcabinet.demo.models.data.*;

import javax.validation.Valid;


@Controller
@RequestMapping("admin")

public class AdminLandingPageController {
   //need to use a conditional about user role=admin to access this page


    //need to also code for editing a user

    @Autowired
    private UserListRepository userListRepository;

    @Autowired
    private RoleListRepository roleListRepository;

    @Autowired
    private RelationshipListRepository relationshipRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "All Users");
        model.addAttribute("users", UserListRepository.getAll());
        return "admin/userindex";
    }
    @GetMapping("adduser")
    public String displayAddUserForm(Model model) {
        model.addAttribute("title", "Add User");
        model.addAttribute("user", new User());
        return "admin/add";
    }

    @PostMapping("add")
    public String processAddUserForm(@ModelAttribute @Valid User newUser, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add User");
            return "admin/add";
        }
        UserListRepository.add(newUser);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteUserForm(Model model) {
        model.addAttribute("title", "Delete User");
        model.addAttribute("users", UserListRepository.getAll());
        return "admin/delete";
    }

    @PostMapping("delete")
    public String processDeleteUserForm(@RequestParam(required = false) int[] userIds) {

        if (userIds != null) {
            for (int id : userIds) {
                UserListRepository.remove(id);
            }
        }

        return "redirect:";
    }


    @Autowired
    private CategoryListRepository categoryListRepository;

    @Autowired
    private UserListRepository userListRepository;

    @Autowired
    private RecordsRepository recordsRepository;

    @RequestMapping("")
    public String index(Model model){

        List users = (List<User>) userListRepository.findAll();
        model.addAttribute("title", "title");
        model.addAttribute("users", users);

        return "index";
    }

    @GetMapping("add")
    public String displayAddCategoryForm(Model model){
        model.addAttribute("title", "title");
        model.addAttribute(new CategoryList());

        return "add";
    }

    @PostMapping("add")
    public String processAddCategoryForm(@ModelAttribute @Valid CategoryList newCategory, Errors errors, Model model){
        if (errors.hasErrors()) {
            model.addAttribute("title", "title");
            return "add";
        }

        CategoryListRepository.save(newCategory);

        return "redirect:";
    }

    @GetMapping("addUser")
    public String displayAddUserForm(Model model){
        model.addAttribute("title", "title");
        model.addAttribute(new UserList());

        return "addUser";
    }

    @PostMapping("addUser")
    public String processAddUserForm(@ModelAttribute @Valid UserList newUser, Errors errors, Model model){
        if (errors.hasErrors()) {
            model.addAttribute("title", "title");
            return "addUser";
        }

        UserListRepository.save(newUser);

        return "redirect:";
    }

    @GetMapping("addRecord")
    public String displayAddRecordForm(Model model) {
        model.addAttribute("title", "title");
        model.addAttribute(new RecordsList());

        return "addRecord";
    }

    @PostMapping("addRecord")
    public String processAddRecordForm(@ModelAttribute @Valid RecordsList newRecord, Errors errors, Model model){
        if (errors.hasErrors()) {
            model.addAttribute("title", "title");
            return "addRecord";
        }

        UserListRepository.save(newRecord);

        return "redirect:";
    }



}
