package com.jingchu.web.controller;

import com.jingchu.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author pc
 * creat 2021/11/13-21:21
 */

@Controller

public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping({"/",""})


    public String ToIndex(Model model, HttpSession session){
//        User user = new User();
//        user.setStatus(0);
//        session.setAttribute("user",user);

        return "redirect:/catagory/cyxx";
    }

}

