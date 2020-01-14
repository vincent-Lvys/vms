package com.vincent.microservice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName("sys_resource")
@Data
public class Resource implements Serializable {
    private int id;
    private String resourceName;
    private int parentId;
    private String type;
    private Date creationTime;
    private String creator;

}
