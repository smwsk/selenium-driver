package com.smu.selenium.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smu.selenium.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
