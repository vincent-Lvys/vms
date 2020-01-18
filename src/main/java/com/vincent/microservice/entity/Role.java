package com.vincent.microservice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName("sys_role")
@Data
public class Role implements Serializable {
    private int id;
    private String roleName;
    private Date creationTime;
    private String creator;
    private String state;
    private String description;
}
