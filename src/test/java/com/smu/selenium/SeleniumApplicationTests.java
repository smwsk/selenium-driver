package com.smu.selenium;

import com.smu.selenium.sys.entity.User;
import com.smu.selenium.sys.service.IUserService;
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
    IUserService userService;

    @Test
    public void contextLoads() {
        List<User> list = userService.list();
        for(User user: list){
            System.out.println(user.getName());
        }
    }

}

