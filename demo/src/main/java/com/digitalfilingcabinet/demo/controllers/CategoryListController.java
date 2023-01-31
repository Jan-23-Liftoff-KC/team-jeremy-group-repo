package com.digitalfilingcabinet.demo.controllers;

import com.digitalfilingcabinet.demo.models.data.CategoryListRepository;
import com.digitalfilingcabinet.demo.models.data.RecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("categories")
public class CategoryListController {
    // this thing should render a table showing all the categories that are created
    // can we get this thing to like, also show a thumbnail of the category
    // and then, like, show a list that they can click on to render a thumbnail of a different one
    // and then a button on the thumbnail to take them to a new page with the full view
    // of the category, and the upload/edit functions.

    // thats probably a 'parking lot' idea, we can start with this simply rendering the
    // full category list.

    @Autowired
    private CategoryListRepository categoryListRepository;

    @Autowired
    private RecordsRepository recordsRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("categories", categoryListRepository.findAll());
        return"categories/index";
    }







}
