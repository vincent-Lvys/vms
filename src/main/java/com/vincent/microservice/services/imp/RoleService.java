package com.vincent.microservice.services.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vincent.microservice.entity.Role;
import com.vincent.microservice.mapper.RoleMapper;
import com.vincent.microservice.services.IRoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends ServiceImpl<RoleMapper, Role> implements IRoleService {
}
