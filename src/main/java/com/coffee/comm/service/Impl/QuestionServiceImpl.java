package com.coffee.comm.service.Impl;

import com.coffee.comm.dao.QuestionMapper;
import com.coffee.comm.dao.UserMapper;
import com.coffee.comm.dto.QuestionDTO;
import com.coffee.comm.model.Question;
import com.coffee.comm.model.User;
import com.coffee.comm.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * QuestionServiceImpl
 * @author lmq
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public void create(Question question) {
        questionMapper.create(question);
    }

    @Override
    public List<QuestionDTO> list() {
        List<Question> questions = questionMapper.findAllQuestion();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question:questions) {
            User u = userService.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(u);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
