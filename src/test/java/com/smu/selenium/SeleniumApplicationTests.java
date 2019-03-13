package com.smu.selenium;

import com.smu.selenium.entity.User;
import com.smu.selenium.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeleniumApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {

        List<User> users = userMapper.selectList(null);
        for(User user: users){
            System.out.println(user.getName());
        }
    }

}

