package com.vincent.microservice.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
@TableName("sys_role")
public class Role implements Serializable {
    private String id;
    private String roleName;
    private String creationTime;
    private String creator;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
