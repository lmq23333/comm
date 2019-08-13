package com.coffee.comm.service.Impl;

import com.coffee.comm.dao.QuestionMapper;
import com.coffee.comm.dto.QuestionDTO;
import com.coffee.comm.model.Question;
import com.coffee.comm.model.User;
import com.coffee.comm.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<QuestionDTO> list(Integer page, Integer size) {
        page = size*(page-1);
        Map<String, Object> map = new HashMap();
        map.put("page",page);
        map.put("size" ,size);

        List<Question> questions = questionMapper.findAllQuestion(map);
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

    @Override
    public int totalCount() {
        return questionMapper.totalCount();
    }
}
