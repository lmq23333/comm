package com.coffee.comm.controller;

import com.coffee.comm.dto.QuestionDTO;
import com.coffee.comm.model.User;
import com.coffee.comm.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable("id") Integer id,
                           Model model){
        QuestionDTO questionDTO = questionService.selectQuestionById(id);
        if(questionDTO!=null){
            model.addAttribute("question",questionDTO);
        }else{
            model.addAttribute("msg","error");
        }

        return "question";
    }
}
