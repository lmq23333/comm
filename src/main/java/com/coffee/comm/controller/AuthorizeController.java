package com.coffee.comm.controller;

import com.coffee.comm.dto.GithubUser;
import com.coffee.comm.model.User;
import com.coffee.comm.provider.GithubPrivider;
import com.coffee.comm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

/**
 * AuthorizeController
 * @author lmq
 */
@Controller
public class AuthorizeController {

    /**
     * githubPrivider
     */
    @Autowired
    private GithubPrivider githubPrivider;

    /**
     * client_id
     */
    @Value("${github.client.id}")
    private String client_id;

    /**
     * client_secret
     */
    @Value("${github.client.secret}")
    private String client_secret;

    /**
     * redirect_uri
     */
    @Value("${github.redirect_uri}")
    private String redirect_uri;

    /**
     * userService
     */
    @Autowired
    private UserService userService;

    /**
     * callBack
     * @param code
     * @param state
     * @param response
     * @return
     */
    @GetMapping("/callback")
    public String callBack(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state,
                           HttpServletResponse response){
        GithubUser githubUser = userService.login(client_id, client_secret, redirect_uri, code, state);
        if(githubUser!=null){
            //登录成功
            User user = userService.loginSuccess(githubUser, response);
            userService.createOrUpdate(user);
            return "redirect:/";
        }else{
            //登录失败
            return "redirect:/";
        }
    }
}
