package com.coffee.comm.service;

import com.coffee.comm.dto.QuestionDTO;
import com.coffee.comm.model.Question;

import java.util.List;

/**
  *QuestionService
 * @author lmq
  * @date 2019/8/8 16:13
  **/
public interface QuestionService {
    /**
      * create
      * @param question
      * @date 2019/8/8 16:23
      **/
    void create(Question question);

    /**
      * list
      * @return List<Question>
      * @date 2019/8/9 16:48
      **/
    List<QuestionDTO> list();
}
