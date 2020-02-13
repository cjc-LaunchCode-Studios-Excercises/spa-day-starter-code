package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    //temporary to make sure it exists at user
    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        if(user.getPassword().equals(verify)) {
            model.addAttribute("user", user);
            return "user/index";
        } else {
            model.addAttribute("error", "Passwords should match");
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            return "user/add";
        }

    }

    //exists at user/add
    @GetMapping("add")
    public String displayAddUserForm() {
        return "/user/add";
    }




}
