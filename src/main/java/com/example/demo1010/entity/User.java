package com.example.demo1010.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;


/**
 * @author mrpeng
 * @description
 * @create 2020 - 08 - 07 13:04
 */
@Data
public class User {
//    @TableId(type = IdType.AUTO)
    private Long id;



    private String name;

    private Integer age;

    private String email;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    @TableLogic
    private Integer deleted;
}
