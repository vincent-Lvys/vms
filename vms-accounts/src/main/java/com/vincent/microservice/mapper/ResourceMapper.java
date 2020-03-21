package com.vincent.microservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vincent.microservice.entity.Resource;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResourceMapper extends BaseMapper<Resource> {
}
