package com.example.demo.chatper02.controller;

import android.widget.RemoteViews;
import com.example.demo.chatper02.service.IUserService;
import com.example.demo.chatper02.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@Controller
public class UserController {

//    @Autowired
//    IUserService userService;
//
//    @RequestMapping("users")
//    public List<User> getAllUser() {
//        return userService.findAll();
//    }
//
//    @RequestMapping("user/{userName}")
//    public User findByUserName(@PathVariable String userName) {
//        return userService.findByUserName(userName);
//    }

    @Resource
    IUserService userService;

    @RequestMapping("/")
    public String index() {
        return "redirect:list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping("toEdit")
    public String toEditUserInfo(Model model, Long id) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    @RequestMapping("/edit")
    public String editUserInfo(User user) {
        userService.edit(user);
        return "redirect:/list";
    }

    @RequestMapping("/delete")
    public String toDeleteUser(Long id) {
        userService.delete(id);
        return "redirect:/list";
    }

    @RequestMapping("/toAdd")
    public String toAddUserInfo() {
        return "user/userAdd";
    }

    @RequestMapping("/add")
    public String addUserInfo(User user) {
        userService.save(user);
        return "redirect:/list";
    }
}
