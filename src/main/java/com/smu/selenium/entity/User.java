package com.smu.selenium.entity;

import lombok.Data;

/**
 * @author wangshaokui
 * @version 1.0
 * @className User
 * @time 2019/3/13 15:18
 **/
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
