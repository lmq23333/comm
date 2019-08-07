package com.coffee.comm.controller;

import com.coffee.comm.dto.AccessTokenDTO;
import com.coffee.comm.dto.GithubUser;
import com.coffee.comm.provider.GithubPrivider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubPrivider githubPrivider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect_uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callBack(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri(redirectUri);
        String accessToken = githubPrivider.getAccessToken(accessTokenDTO);
        GithubUser user = githubPrivider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
