package com.vincent.microservice.services.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vincent.microservice.entity.Role;
import com.vincent.microservice.mapper.RoleMapper;
import com.vincent.microservice.services.IRoleService;
import com.vincent.microservice.vo.BaseSearchVo;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleService extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Resource
    RoleMapper roleMapper;

    @Override
    public Page<Role> pageList(Page<Role> page, BaseSearchVo baseSearchVo) {
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        if (Strings.isNotBlank(baseSearchVo.getStart()))wrapper.ge("creation_time",baseSearchVo.getStart());
        if (Strings.isNotBlank(baseSearchVo.getEnd()))wrapper.le("creation_time",baseSearchVo.getEnd());
        if (Strings.isNotBlank(baseSearchVo.getKeyword()))wrapper.like("role_name",baseSearchVo.getKeyword())
                .or().like("description",baseSearchVo.getKeyword())
                .or().like("creator",baseSearchVo.getKeyword());
        roleMapper.selectPage(page,wrapper);
        return page;
    }
}
