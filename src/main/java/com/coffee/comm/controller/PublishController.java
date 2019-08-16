package com.coffee.comm.controller;

import com.coffee.comm.dao.QuestionMapper;
import com.coffee.comm.dao.UserMapper;
import com.coffee.comm.dto.QuestionDTO;
import com.coffee.comm.model.Question;
import com.coffee.comm.model.User;
import com.coffee.comm.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * PublicController
 *
 * @author lmq
 */
@Controller
public class PublishController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/publish")
    public String publish(Model model) {
        Question question= new Question();
        model.addAttribute("question",question);
        model.addAttribute("msg","提问");
        model.addAttribute("sub","发布");
        return "publish";
    }

    @PostMapping("/publish")
    public String toPublish(@RequestParam("title") String title,
                            @RequestParam("description") String description,
                            @RequestParam("tag") String tag,
                            HttpServletRequest request,
                            Model model) {
        Question question = questionService.turnToQuestion(title,description,tag);
        model.addAttribute("question",question);
        model.addAttribute("msg","发起");
        model.addAttribute("sub","发布");
        model.addAttribute("link","/publish");
        String s=questionService.judge(title,description,tag,model,request);
        if(s!=null){
            return s;
        }
        User user = (User) request.getSession().getAttribute("user");
        question.setCreator(user.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(user.getGmt_create());
        questionService.create(question);
        return "redirect:/";
    }
    @GetMapping("/publish/{id}")
    public String showEditQuestion(@PathVariable("id") Integer id,Model model){
        QuestionDTO question = questionService.selectQuestionById(id);
        model.addAttribute("question",question);
        model.addAttribute("msg","编辑");
        model.addAttribute("sub","修改");
        model.addAttribute("link","/edit/"+id);
        return "publish";
    }
    @PostMapping("/edit/{id}")
    public String editQuestion(@PathVariable("id") Integer id,
                               @RequestParam("title") String title,
                               @RequestParam("description") String description,
                               @RequestParam("tag") String tag,
                               HttpServletRequest request,
                               Model model){
        Question question =questionService.turnToQuestion(title,description,tag);
        model.addAttribute("question",question);
        model.addAttribute("msg","编辑");
        model.addAttribute("sub","修改");
        question.setId(id);
        questionService.judge(title,description,tag,model,request);

        QuestionDTO questionDTO = questionService.selectQuestionById(id);
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(questionDTO.getUser().getGmt_create());
        questionService.updateQuestion(question);
        return "redirect:/profile/questions";
    }
}
