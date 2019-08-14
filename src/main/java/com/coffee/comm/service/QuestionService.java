package com.coffee.comm.service;

import com.coffee.comm.dto.PaginationDTO;
import com.coffee.comm.dto.QuestionDTO;
import com.coffee.comm.model.Question;

import java.util.List;
import java.util.Map;

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
      *
     * @param page
     * @param size*/
    List<QuestionDTO> list(Integer page, Integer size);

    /**
     * totalCount
     * @return Integer
     */
    Integer totalCount();

    PaginationDTO showIndexQuestion(Integer page, Integer size);

    PaginationDTO showMyQuestion(Integer page, Integer size,Integer userId);
}
