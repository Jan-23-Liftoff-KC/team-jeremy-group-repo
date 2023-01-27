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
        model.addAttribute("users",users);

        return "index";
    }

    @GetMapping("add")
    public String displayAddCategoryForm(){

    }


}
