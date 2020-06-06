package com.userservice.controller;

import com.userservice.models.UserModel;
import com.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String getHomePage(final Model model){
        List<UserModel> users = userService.fetchAllUserInfo();
        model.addAttribute("users", users);
        return "index";
    }

    @RequestMapping("/user/create")
    public String createUser(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("phn") String phn,@RequestParam("address") String address, final Model model){
        UserModel newUser = new UserModel(name,email,phn,address);
        userService.createUserInfo(newUser);
        model.addAttribute("users",userService.fetchAllUserInfo());
        return "redirect:" + "/";
    }

    @RequestMapping("/add/user")
    public String addUser(final Model model){
        return "addUser";
    }

    @RequestMapping("/user/{term}/search")
    public String searchByName(@PathVariable final String term,final Model model){
        if(term.isEmpty()){
            List<UserModel> users = userService.fetchAllUserInfo();
            model.addAttribute("users", users);
            return "index";
        }else {
            boolean isString = false;
            try {
                Long sTerm = Long.parseLong(term);
            }catch (final Exception e){
                isString = true;
            }
            UserModel user = null;
            if(isString){
                user = userService.findUserByName(term);
            }else{
                user = userService.findUserByPhn(term);
            }
            if (null == user) {
                model.addAttribute("foundUser", "false");
                model.addAttribute("users", userService.fetchAllUserInfo());
            } else {
                List<UserModel> users = new ArrayList<>();
                users.add(user);
                model.addAttribute("foundUser", "true");
                model.addAttribute("users", users);
            }
            return "index";
        }
    }

    @RequestMapping("/user/sort")
    public String sortByName(final Model model){
        List<UserModel> users =userService.sortByName();
        model.addAttribute("users",users);
        return "index";
    }
}
