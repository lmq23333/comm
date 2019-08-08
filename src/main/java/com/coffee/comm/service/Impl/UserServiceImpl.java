package com.coffee.comm.service.Impl;

import com.coffee.comm.dao.UserMapper;
import com.coffee.comm.model.User;
import com.coffee.comm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 * @author lmq
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * userMapper
     */
    @Autowired
    UserMapper userMapper;

    /**
     * insertUser
     * @param user
     */
    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
}
