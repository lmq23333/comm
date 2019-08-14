package com.coffee.comm.dto;

import com.coffee.comm.model.User;
import lombok.Data;

/**
 * QuestionDTO
 *
 * @author lmq
 */
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
    private User user;

}
