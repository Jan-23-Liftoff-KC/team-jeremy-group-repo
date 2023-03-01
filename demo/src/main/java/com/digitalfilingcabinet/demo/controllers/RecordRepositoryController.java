package com.digitalfilingcabinet.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import com.digitalfilingcabinet.demo.models.*;
import com.digitalfilingcabinet.demo.models.data.*;

@Controller
@RequestMapping("Records")
public class RecordRepositoryController {
    // im pretty sure controllers are mainly rendering tables
    // so they can be displayed on the view.

    @Autowired
    private CategoryListRepository categoryListRepository;

    @Autowired
    private RecordsRepository recordsRepository;

    @RequestMapping("")
    public String records(Model model) {
        model.addAttribute("Categories", categoryListRepository.findAll());
        model.addAttribute("Records", recordsRepository.findAll());

        return "records";
    }


}
