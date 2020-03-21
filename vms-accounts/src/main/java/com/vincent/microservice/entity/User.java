package com.vincent.microservice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName("sys_user")
@Data
public class User implements Serializable {
    private int id;
    private String loginName;
    private String password;
    private String passwordSalt;
    private Date creationTime;
    private Date updateTime;
    private String creator;
}
