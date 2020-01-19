package com.vincent.microservice.services;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.vincent.microservice.entity.Role;
import com.vincent.microservice.vo.BaseSearchVo;

public interface IRoleService extends IService<Role> {
    Page<Role> pageList(Page<Role> page, BaseSearchVo baseSearchVo);
}
