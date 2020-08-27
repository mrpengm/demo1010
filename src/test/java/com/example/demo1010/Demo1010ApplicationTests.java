package com.example.demo1010;

import com.example.demo1010.entity.User;
import com.example.demo1010.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class Demo1010ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
   public void findAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    //增加
    @Test
    public void addUser(){
        User user = new User();
        user.setName("lili");
        user.setAge(33);
        user.setEmail("lily@qq.com");

//        user.setCreateTime(new Date());
//        user.setUpdateTime(new Date());

        int insert = userMapper.insert(user);
        System.out.println(" ___"+insert);
    }

    //修改
    @Test
    public void updateUser(){
        User user = new User();
        user.setId(1298914867392585729L);
        user.setAge(120);

        int i = userMapper.updateById(user);
        System.out.println(i);
    }

}
