package com.vincent.microservice.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.gson.Gson;
import com.vincent.microservice.entity.User;
import com.vincent.microservice.services.imp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest request;

    @GetMapping("/searchList")
    public String searchList(){
        String current = request.getParameter("current");
        String size = request.getParameter("size");
        Page<User> userPage = new Page<>(Long.parseLong(current),Long.parseLong(size));
        Page<User> page = userService.pageList(userPage);

        return new Gson().toJson(page);
    }
    @PostMapping("/saveUser")
    public String saveUser(@RequestBody User user){
        boolean save = userService.save(user);
        if (save)return "success";
        return "false";
    }

}
