package com.example.demo1010.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author mrpeng
 * @description
 * @create 2020 - 08 - 07 17:01
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {


    //使用mp实现添加操作，这个方法会执行
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", new Date(),metaObject );
        this.setFieldValByName("updateTime", new Date(),metaObject );
        this.setFieldValByName("version", 1, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(),metaObject );
    }
}
