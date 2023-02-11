package com.digitalfilingcabinet.demo.controllers;

import com.digitalfilingcabinet.demo.models.data.CategoryListRepository;
import com.digitalfilingcabinet.demo.models.data.RecordsRepository;
import com.digitalfilingcabinet.demo.models.data.UserListRepository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "list")
public class CategoryListController {
    @Autowired
    CategoryListRepository categoryListRepository;

    @Autowired
    UserListRepository userListRepository;

    @Autowired
    RecordsRepository recordsRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public CategoryListController() {

        columnChoices.put("all", "All");
        columnChoices.put("records", "Records");
        columnChoices.put("users", "Users");
    }

    @RequestMapping("")
    public String CategoryList(Model model) {
        model.addAttribute("categoryList", CategoryListRepository.findAll());
        model.addAttribute("records", RecordsRepository.findAll());
        return "categoryList";
    }
};





    // this thing should render a table showing all the categories that are created
    // can we get this thing to like, also show a thumbnail of the category
    // and then, like, show a list that they can click on to render a thumbnail of a different 
    // and then a button on the thumbnail to take them to a new page with the full view
    // of the category, and the upload/edit functions.

    // that's probably a 'parking lot' idea, we can start with this simply rendering the
    // full category list.

    //do we need a category editor controller that has a conditional that only role= admin || editor can access or
    //should that be included within this controller?

