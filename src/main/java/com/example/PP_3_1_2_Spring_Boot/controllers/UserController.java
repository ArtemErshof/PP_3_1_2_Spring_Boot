package com.example.PP_3_1_2_Spring_Boot.controllers;

import com.example.PP_3_1_2_Spring_Boot.models.User;
import com.example.PP_3_1_2_Spring_Boot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user/{id}")
    public String gerUserById(@PathVariable("id") int id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping(value = "/")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "all_users";
    }

    @PostMapping(value = "/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }

    @GetMapping(value = "/editUser/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "edit_page";
    }

    @PostMapping(value = "/updateUser/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/";
    }

    @PostMapping(value = "/createUser")
    public String createUser(@ModelAttribute("user") User user) {
        userService.create(user);
        return "redirect:/";
    }

    @GetMapping(value = "/newUser")
    public String newUser(@ModelAttribute("user") User user) {
        return "new_user";
    }
}
