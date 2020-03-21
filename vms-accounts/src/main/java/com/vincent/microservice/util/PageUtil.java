package com.vincent.microservice.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class PageUtil {

    private String code;
    private Object data;
    private String message;
    private long count;
    private long size;

    public PageUtil(String code, Page data, String message) {
        this.message = message;
        this.data = data.getRecords();
        this.code = code;
        this.count = data.getTotal();
        this.size = data.getSize();
    }
    public PageUtil(Page data){
        this("200",data,"success");
    }
}
