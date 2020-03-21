package com.vincent.microservice.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.gson.Gson;
import com.vincent.microservice.entity.Role;
import com.vincent.microservice.services.imp.RoleService;
import com.vincent.microservice.util.PageUtil;
import com.vincent.microservice.vo.BaseSearchVo;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
public class RoleController {
    @Autowired
    HttpServletRequest request;
    @Autowired
    private RoleService roleService;

    @GetMapping("/rolePage")
    public ModelAndView rolePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin-role");
        return modelAndView;
    }

    @GetMapping("/roleEditPage/{id}")
    public ModelAndView roleEditPage(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView();
        Role role = !"@null@".equals(id) ? roleService.getById(id) : new Role();
        modelAndView.addObject("role", role);
        modelAndView.setViewName("/role-add");
        return modelAndView;
    }

    @GetMapping("/searchRoleList")
    public PageUtil searchRoleList(@RequestParam(required = false) String searchParam) {
        BaseSearchVo baseSearchVo = Strings.isNotBlank(searchParam) ? new Gson().fromJson(searchParam, BaseSearchVo.class) : new BaseSearchVo();
        String curr = request.getParameter("page");
        String size = request.getParameter("limit");
        Page<Role> page = new Page<>(Long.parseLong(curr), Long.parseLong(size));
        Page<Role> rolePage = roleService.pageList(page, baseSearchVo);
        return new PageUtil(rolePage);
    }

    @PostMapping(value = {"/updateOrSaveRole"})
    public Boolean updateOrSaveRole() {
        String strRole = request.getParameter("role");
        Role role = new Gson().fromJson(strRole, Role.class);
        role.setCreationTime(new Date());
        return roleService.saveOrUpdate(role);
    }

    @PostMapping(value = {"/changeRoleState"})
    public Boolean changeRoleState(@RequestParam String state, @RequestParam int id) {
        Role role = roleService.getById(id);
        role.setState("1".equals(state) ? "0" : "1");
        return roleService.saveOrUpdate(role);
    }

    @DeleteMapping(value = {"/role/{ids}"})
    public Boolean deleteRole(@PathVariable String ids) {
        return !ids.contains(",") ? roleService.removeById(Integer.parseInt(ids)) : roleService.removeByIds((Arrays.asList(ids.split(","))).stream().map(Integer::parseInt).collect(Collectors.toList()));
    }
}
