package com.wjinyu.service;

import com.wjinyu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jinyu.wen
 * @description
 * @created 2023-06-14 10:27
 */
@Component
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void test(){
        System.out.println(userMapper.getName());
    }
}
