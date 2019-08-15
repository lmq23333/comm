package com.coffee.comm.service.Impl;

import com.coffee.comm.dao.UserMapper;
import com.coffee.comm.dto.AccessTokenDTO;
import com.coffee.comm.dto.GithubUser;
import com.coffee.comm.model.User;
import com.coffee.comm.provider.GithubPrivider;
import com.coffee.comm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * UserServiceImpl
 * @author lmq
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private GithubPrivider githubPrivider;
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

    @Override
    public User findById(Integer creator) {
        return userMapper.findById(creator);
    }

    @Override
    public GithubUser login(String client_id,
                      String client_secret,
                      String redirect_uri,
                      String code,
                      String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(client_id);
        accessTokenDTO.setClient_secret(client_secret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri(redirect_uri);
        String accessToken = githubPrivider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubPrivider.getUser(accessToken);

        return githubUser;
    }

    @Override
    public User loginSuccess(GithubUser githubUser,HttpServletResponse response) {
        User user = new User();
        String token = UUID.randomUUID().toString();
        user.setToken(token);
        user.setName(githubUser.getName());
        user.setAccount_id(String.valueOf(githubUser.getId()));
        user.setGmt_modified(user.getGmt_create());
        user.setGmt_create(System.currentTimeMillis());
        user.setBio(githubUser.getBio());
        user.setAvatar_url(githubUser.getAvatar_url());
        response.addCookie(new Cookie("token",token));
        return user;
    }

    @Override
    public void createOrUpdate(User user) {
        User u = userMapper.findByAccountId(user.getAccount_id());
        if(u==null){
            user.setGmt_create(System.currentTimeMillis());
            user.setGmt_modified(user.getGmt_create());
            userMapper.insertUser(user);
        }else{
            user.setGmt_modified(u.getGmt_create());
            user.setGmt_create(System.currentTimeMillis());
            userMapper.updateUser(user);
        }
    }

    @Override
    public User findByToken(String token) {
       return userMapper.findByToken(token);
    }
}
