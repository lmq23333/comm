package com.coffee.comm.service.Impl;

import com.coffee.comm.dao.QuestionMapper;
import com.coffee.comm.model.Question;
import com.coffee.comm.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * QuestionServiceImpl
 * @author lmq
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public void create(Question question) {
        questionMapper.create(question);
    }
}
