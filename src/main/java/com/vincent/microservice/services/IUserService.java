package com.vincent.microservice.services;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.IPage;
import com.vincent.microservice.entity.User;
import org.springframework.stereotype.Service;

public interface IUserService extends IService<User> {
    Page<User> pageList(Page<User> userPage);
}
