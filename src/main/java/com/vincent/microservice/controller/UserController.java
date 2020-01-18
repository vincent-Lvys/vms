package com.vincent.microservice.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vincent.microservice.entity.User;
import com.vincent.microservice.services.imp.UserService;
import com.vincent.microservice.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest request;

    @GetMapping("/userPage")
    public ModelAndView userPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin-list");
        return modelAndView;
    }

    @GetMapping("/userEditPage/{id}")
    public ModelAndView userEditPage(@PathVariable(required = false) String id) {
        ModelAndView modelAndView = new ModelAndView();
        User user = !"@null@".equals(id) ? userService.getById(id) : new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("/admin-edit");
        return modelAndView;
    }

    @RequestMapping(value = "/searchList", method = RequestMethod.GET)
    public PageUtil searchList() {
        String current = request.getParameter("page");
        String size = request.getParameter("limit");
        String startDate = request.getParameter("start");
        String endDate = request.getParameter("end");
        String keyword = request.getParameter("keyword");
        Page<User> userPage = new Page<User>(Long.parseLong(current), Long.parseLong(size));
        userService.pageList(userPage, startDate, endDate, keyword);
        return new PageUtil(userPage);
    }

    @PostMapping(value = "/deleteAllUser")
    public Boolean deleteAllUser() {
        String selectIds = request.getParameter("selectIds");
        List<Integer> idList = new ArrayList<>();
        for (String userId : selectIds.split(",")) {
            idList.add(Integer.parseInt(userId));
        }
        return userService.removeByIds(idList);
    }

    @PostMapping(value = "/deleteOneUser")
    public Boolean deleteOneUser() {
        String id = request.getParameter("id");
        return userService.removeById(id);
    }

    @PostMapping("/updateOrSaveUser")
    public Boolean saveUser(@RequestParam String id, @RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setLoginName(username);
        user.setPassword(password);
        if (!StringUtils.isEmpty(id)) user.setId(Integer.parseInt(id));
        user.setCreationTime(new Date());
        return userService.saveOrUpdate(user);
    }

}
