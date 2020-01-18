package com.vincent.microservice.services;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.vincent.microservice.entity.User;

public interface IUserService extends IService<User> {

    Page<User> pageList(Page<User> userPage, String startDate, String endDate, String keyword);
}
