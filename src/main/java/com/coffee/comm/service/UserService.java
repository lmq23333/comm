package com.coffee.comm.service;

import com.coffee.comm.model.User;

/**
 * UserService
 * @author lmq
 */
public interface UserService {

    /**
     * insertUser
     * @param user
     */
    void insertUser(User user);

    /**
      * findByToken
      * @param token
      * @return User
      * @date 2019/8/9 16:47
      **/
    User findByToken(String token);

    /**
      * findById
      * @param creator
      * @return User
      * @date 2019/8/9 17:00
      **/
    User findById(Integer creator);
}
