package com.digitalfilingcabinet.demo.controllers;

import com.digitalfilingcabinet.demo.models.data.UserListRepository;
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
public class AdminLandingPageController {
    // handler method that displays the homepage
    // will render the index.html template. or whatever we call it
    // maybe adminLandingPage.html

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
