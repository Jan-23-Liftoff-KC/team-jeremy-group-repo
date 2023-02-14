package com.digitalfilingcabinet.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RecordRepositoryController {
    // im pretty sure controllers are mainly rendering tables
    // so they can be displayed on the view.
    @GetMapping("RecordsRepository")
    public List RecordsRepository() {

        return null;
    }


}
