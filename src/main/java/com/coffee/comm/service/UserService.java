package com.coffee.comm.service;

import com.coffee.comm.dto.GithubUser;
import com.coffee.comm.model.User;

import javax.servlet.http.HttpServletResponse;

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

    GithubUser login(String client_id, String client_secret,
                     String redirect_uri, String code, String state);

    User loginSuccess(GithubUser githubUser,HttpServletResponse response);

    void createOrUpdate(User user);
}
