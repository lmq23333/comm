package com.coffee.comm.controller;

import com.coffee.comm.dto.PaginationDTO;
import com.coffee.comm.model.User;
import com.coffee.comm.service.Impl.QuestionServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * IndexController
 *
 * @author lmq
 */
@Controller
public class IndexController {

    @Autowired
    private QuestionServiceImpl questionService;

    @GetMapping(value={"/index","/"})
    public String hello(Model model,
                        @RequestParam(name="page",defaultValue = "1") Integer page,
                        @RequestParam(name ="size",defaultValue = "2") Integer size) {

        PaginationDTO pagination = questionService.showIndexQuestion(page,size);
        if(pagination.getQuestions().size()!=0){
            model.addAttribute("pagination", pagination);
            model.addAttribute("address","index?page=");
        }else{
            model.addAttribute("msg", "没有符合要求的话题");
        }

        return "index";
    }
    @GetMapping("/search")
    public String search(@RequestParam(name="search") String title,
                         @RequestParam(name="page",defaultValue = "1") Integer page,
                         @RequestParam(name ="size",defaultValue = "2") Integer size,
                         Model model){
        PaginationDTO pagination = questionService.search(title,page,size);
        if(StringUtils.isBlank(title)){
            return "redirect:/index";
        }
        model.addAttribute("pagination",pagination);
        model.addAttribute("title",title);
        model.addAttribute("address","search?search="+title+"&page=");
        return "index";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("token",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/index";
    }
}
