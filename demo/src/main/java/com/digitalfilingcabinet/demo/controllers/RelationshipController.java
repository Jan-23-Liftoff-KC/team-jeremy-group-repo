package com.digitalfilingcabinet.demo.controllers;

import com.digitalfilingcabinet.demo.models.Relationship;
import com.digitalfilingcabinet.demo.models.data.RelationshipListRepository;
import com.digitalfilingcabinet.demo.models.data.UserListRepository;

import java.util.Optional;

@Controller
@RequestMapping("relationships")
public class RelationshipController {

    @Autowired
    private RelationshipListRepository relationshipListRepository;

    @Autowired
    private UserListRepository userListRepository;

    @GetMapping(""
    public String index(Model model) {
        model.addAttribute("relationships", relationshipRepository.findAll());
        return "relationships/index";
            }

            @GetMapping("add")
            public String displayAddRelationshipForm(Model model) {
            model.addAttribute("title", "Add Relationship");
            model.addAttribute("relationship", new Relationship());
            return "relationships/add";
            }

    @PostMapping("add")
    public String processAddRelationshipForm(@ModelAttribute @Valid Relationship newRelationship, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Relationship");
            return "relationships/add";
        }
        relationshipListRepository.save(newRelationship);
        return "redirect:";
    }

    @GetMapping("view/{relationshipId}")
    public String displayViewRelationship(Model model, @PathVariable int relationshipId) {


        Optional optRelationship = relationshipListRepository.findById(relationshipId);
        if (optRelationship.isPresent()) {
            Relationship skill = (Relationship) optRelationship.get();
            model.addAttribute("relationship", relationship);
            return "relationships/view";
        } else {
            return "redirect:../";

        }

    }
}
