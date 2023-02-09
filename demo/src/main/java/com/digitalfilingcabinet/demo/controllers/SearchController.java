package com.digitalfilingcabinet.demo.controllers;

import com.digitalfilingcabinet.demo.models.data.RecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.digitalfilingcabinet.demo.controllers.CategoryListController.columnChoices;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private RecordsRepository recordsRepository;


    @RequestMapping("")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        Iterable<RecordsList> records;
        if(searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            records = recordsRepository.findAll();
        } else {
            records = CategoryData.findByColumnAndvalue(searchType, searchTerm, recordsRepository.findAll());
        }
        model.addAttribute("columns", columnChoices);
        model.addAttribute("title", "Records with " + columnChoices.get(searchType) + ": " + searchTerm);
        model.addAttribute("records", records);

        return "search";
    }






    // i think we need a search controller
    // this should have a method to display search results.
    // i think its something like this
    // displaySearchResults
    // (Model model, @RequestParam String searchType, @RequestParam String searchTerm){


}
