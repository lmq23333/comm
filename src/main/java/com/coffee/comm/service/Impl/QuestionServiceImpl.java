package com.coffee.comm.service.Impl;

import com.coffee.comm.dao.QuestionMapper;
import com.coffee.comm.dto.PaginationDTO;
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

    public Map turnToMap(Integer page, Integer size){
        page = size*(page-1);
        Map<String, Object> map = new HashMap();
        map.put("page",page);
        map.put("size" ,size);
        return map;
    }
    public List<QuestionDTO> turnToQuestionDTO(List<Question> questions){
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
    public List<QuestionDTO> list(Integer page, Integer size) {
        Map<String, Object> map =turnToMap(page,size);
        List<Question> questions = questionMapper.findAllQuestion(map);
        return turnToQuestionDTO(questions);
    }


    @Override
    public QuestionDTO selectQuestionById(Integer id) {
        Question question = questionMapper.selectQuestionById(id);
        User u = userService.findById(question.getCreator());
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question,questionDTO);
        questionDTO.setUser(u);
        return questionDTO;
    }

    @Override
    public PaginationDTO search(String title, Integer page, Integer size) {
        Map map = turnToMap(page,size);
        map.put("title",title);
        List<Question> questionList =questionMapper.search(map);
        List<QuestionDTO> questionDTOList = turnToQuestionDTO(questionList);
        PaginationDTO pagination = new PaginationDTO();
        Integer totalCount = questionMapper.totalCountByTitle(title);
        pagination.setPagination(totalCount, page, size);
        pagination.setQuestions(questionDTOList);
        return pagination;
    }

    @Override
    public PaginationDTO showMyQuestion(Integer page, Integer size,Integer userId) {
        Map map =turnToMap(page,size);
        map.put("userId",userId);
        List<Question> questionList =questionMapper.selectQuestionsByCreator(map);
        List<QuestionDTO> questionDTOList = turnToQuestionDTO(questionList);
        PaginationDTO pagination = new PaginationDTO();
        Integer totalCount = questionMapper.totalCountById(userId);
        pagination.setPagination(totalCount, page, size);
        pagination.setQuestions(questionDTOList);
        return pagination;
    }

    public PaginationDTO showIndexQuestion(Integer page, Integer size) {
        List<QuestionDTO> questionList = list(page,size);
        PaginationDTO pagination = new PaginationDTO();
        int totalCount = totalCount();
        pagination.setPagination(totalCount, page, size);
        pagination.setQuestions(questionList);
        return pagination;
    }

        @Override
        public Integer totalCount () {
            return questionMapper.totalCount();
        }
    }
