package com.vincent.microservice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Data;

import java.io.Serializable;
@TableName("sys_role")
@Data
public class Role implements Serializable {
    private String id;
    private String roleName;
    private String creationTime;
    private String creator;
}
