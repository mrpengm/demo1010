package com.example.demo1010;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo1010.entity.User;
import com.example.demo1010.mapper.UserMapper;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
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
//    @Test
    public void addUser(){
        User user = new User();
        user.setName("王五");
        user.setAge(20);
        user.setEmail("wangwu@qq.com");

//        user.setCreateTime(new Date());
//        user.setUpdateTime(new Date());
        System.out.println(userMapper);

        int insert = userMapper.insert(user);
        System.out.println(" ___"+insert);
    }

    //修改
//    @Test
    public void updateUser(){
        User user = new User();
        user.setId(1298996589896982529L);
        user.setAge(120);

        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    //测试乐观锁
//    @Test
    public void testOptimisticLocker(){
        //根据id查询数据
        User user = userMapper.selectById(1298996589896982529L);
        //进行修改
        user.setAge(200);
        userMapper.updateById(user);
    }
    @Test
    public void testSelectDemo1(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        System.out.println(users);
    }

    //分页查询
//    @Test
    public void testPage(){
        //创建page对象
        //闯入两个参数，当前页和每页显示记录
        Page<User> page = new Page<>(1, 3);
        userMapper.selectPage(page, null);

        //通过page对象获取分页数据
        System.out.println(page.getCurrent());
        System.out.println(page.getRecords());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());

        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }
//    @Test
    public void testDeleteById(){
        int result = userMapper.deleteById(1299001129484484609L);
        System.out.println(result);
    }

    @Test
    public void testSelectQquery(){
        //创建QueryWrapper对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //通过QueryWrapper设置条件
        //ge/gt/le/lt
//        wrapper.ge("age", 30);

//        wrapper.eq("name","张三");
//        wrapper.ne("name", "李四");

        //between
        //年龄在20到30件
//        wrapper.between("age", 20, 30);

        wrapper.select("id", "name");

        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);

    }

}
