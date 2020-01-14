package com.vincent.microservice.services.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vincent.microservice.entity.Resource;
import com.vincent.microservice.mapper.ResourceMapper;
import com.vincent.microservice.services.IResourceService;
import org.springframework.stereotype.Service;

@Service
public class ResourceService extends ServiceImpl<ResourceMapper, Resource> implements IResourceService {
}
