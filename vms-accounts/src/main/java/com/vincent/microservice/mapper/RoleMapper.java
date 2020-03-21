package com.vincent.microservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vincent.microservice.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
}
