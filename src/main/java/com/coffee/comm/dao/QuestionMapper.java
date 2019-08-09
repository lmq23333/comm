package com.coffee.comm.dao;

import com.coffee.comm.model.Question;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
  * QuestionMapper
  * @author lmq
  * @date 2019/8/8 16:14
  **/
@Mapper
@Repository
public interface QuestionMapper {
    /**
     * create
     * @param question
     * @date 2019/8/8 16:23
     **/
    void create(Question question);
}