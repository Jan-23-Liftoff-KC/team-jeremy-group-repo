package com.niemannproject.digitalpersonalorganizer.controllers;

import com.niemannproject.digitalpersonalorganizer.models.Provider;
import com.niemannproject.digitalpersonalorganizer.models.data.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("medical/providers")
public class ProviderController {

    @Autowired
    private ProviderRepository providerRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("providers", providerRepository.findAll());
        return "/index";
    }

    @GetMapping("view/{providerId}")
    public String displayViewEmployer(Model model, @PathVariable int providerId) {

        Optional optProvider = providerRepository.findById(providerId);
        if (optProvider.isPresent()) {
            Provider provider = (Provider) optProvider.get();
            model.addAttribute("provider", provider);
            return "/view";
        } else {
            return "redirect:../";
        }
    }
}
