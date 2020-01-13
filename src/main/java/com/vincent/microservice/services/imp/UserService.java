package com.vincent.microservice.services.imp;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.IPage;
import com.vincent.microservice.entity.User;
import com.vincent.microservice.mapper.UserMapper;
import com.vincent.microservice.services.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService extends ServiceImpl<UserMapper,User> implements IUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public Page<User> pageList(Page<User> userPage) {
        Page<User> page = userPage.setRecords(userMapper.pageList(userPage));
        return page;
    }
}
