package com.vincent.microservice.services.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vincent.microservice.entity.User;
import com.vincent.microservice.mapper.UserMapper;
import com.vincent.microservice.services.IUserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService extends ServiceImpl<UserMapper,User> implements IUserService {
    @Resource
    private UserMapper userMapper;


    @Override
    public Page<User> pageList(Page<User> userPage, String startDate, String endDate, String keyword) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        if (Strings.isNotBlank(startDate))userQueryWrapper.ge("creation_time",startDate);
        if (Strings.isNotBlank(endDate))userQueryWrapper.le("creation_time",endDate);
        if (Strings.isNotBlank(keyword))userQueryWrapper.like("login_name","%"+keyword+"%").or().like("creator","%"+keyword+"%");
        userMapper.selectPage(userPage,userQueryWrapper.orderByDesc("creation_time"));
        return userPage;
    }
}
