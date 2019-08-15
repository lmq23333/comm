package com.coffee.comm.controller;

import com.coffee.comm.dto.PaginationDTO;
import com.coffee.comm.model.User;
import com.coffee.comm.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * ProfileController
 * @author lmq
 */
@Controller
public class ProfileController {

    @Autowired
    private QuestionService questionService;

    /**
     * profile
     * @return String
     */
    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name="action") String action,
                          Model model, HttpServletRequest request,
                          @RequestParam(name="page",defaultValue = "1") Integer page,
                          @RequestParam(name ="size",defaultValue = "2") Integer size){
        if("questions".equals(action)){
            model.addAttribute("section","questions");
            model.addAttribute("sectionName","我的问题");
            User user = (User) request.getSession().getAttribute("user");
            Integer userId = user.getId();
            PaginationDTO pagination = questionService.showMyQuestion(page, size, userId);
            if(pagination.getQuestions().size()!=0){
                model.addAttribute("pagination",pagination );
                model.addAttribute("address", "/profile/questions?page=");
            }else{
                model.addAttribute("msg", "没有符合要求的话题");
            }
        }
        if("replies".equals(action)){
            model.addAttribute("section","replies");
            model.addAttribute("sectionName","最新回复");
        }
        return "profile";
    }
}
