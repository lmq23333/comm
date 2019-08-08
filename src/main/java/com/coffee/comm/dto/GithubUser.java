package com.coffee.comm.dto;
/**
 * GithubUser
 * @author lmq
 */
public class GithubUser {
    private String name;
    private Long id;
    private  String bio;

/**
  *
  * @return String
  * @date    2019/8/8 11:10
  **/
    public String getName() {
        return name;
    }

    /**
      * setName
      * @param  name
      * @date 2019/8/8 11:11
      **/
    public void setName(String name) {
        this.name = name;
    }

    /**
      * getId
      * @return
      * @date 2019/8/8 11:11
      **/
    public Long getId() {
        return id;
    }

    /**
      * setId
      * @param id
      * @date 2019/8/8 11:12
      **/
    public void setId(Long id) {
        this.id = id;
    }

    /**
      * getBio
      * @return String
      * @date 2019/8/8 11:13
      **/
    public String getBio() {
        return bio;
    }

    /**
      * setBio
      * @param bio
      * @date 2019/8/8 11:13
      **/
    public void setBio(String bio) {
        this.bio = bio;
    }
}
