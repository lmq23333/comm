package com.coffee.comm.controller;

import com.coffee.comm.dto.AccessTokenDTO;
import com.coffee.comm.dto.GithubUser;
import com.coffee.comm.model.User;
import com.coffee.comm.provider.GithubPrivider;
import com.coffee.comm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

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
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/callback")
    public String callBack(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(client_id);
        accessTokenDTO.setClient_secret(client_secret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri(redirect_uri);
        String accessToken = githubPrivider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubPrivider.getUser(accessToken);
        if(githubUser!=null){
            //登录成功
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubUser.getName());
            user.setAccount_id(String.valueOf(githubUser.getId()));
            user.setGmt_create(System.currentTimeMillis());
            user.setGmt_modified(user.getGmt_create());
            user.setBio(githubUser.getBio());
            user.setAvatar_url(githubUser.getAvatar_url());

            userService.insertUser(user);

            response.addCookie(new Cookie("token",token));
            return "redirect:/";
        }else{
            //登录失败
            return "redirect:/";
        }
    }
}
