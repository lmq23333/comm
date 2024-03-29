package com.coffee.comm.model;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String name;
    private String account_id;
    private String token;
    private Long gmt_create;
    private Long gmt_modified;
    private String bio;
    private String avatar_url;

}
