package com.coffee.comm.model;

public class User {
    /**
      * id
      **/
    private Integer id;
    /**
     * name
     **/
    private String name;
    /**
     * accountId
     **/
    private String accountId;
    /**
     * token
     **/
    private String token;
    /**
     * gmtCreate
     **/
    private Long gmtCreate;
    /**
     * gmtModified
     **/
    private Long gmtModified;

    /**
      * getId
      * @return Integer
      * @date 2019/8/8 11:14
      **/
    public Integer getId() {
        return id;
    }

    /**
      * setId
      * @param id
      * @date 2019/8/8 11:19
      **/
    public void setId(Integer id) {
        this.id = id;
    }

    /**
      * getName
      * @return String
      * @date 2019/8/8 11:20
      **/
    public String getName() {
        return name;
    }

    /**
      * setName
      * @param name
      * @date 2019/8/8 11:20
      **/
    public void setName(String name) {
        this.name = name;
    }

    /**
      * getAccountId
      * @return String
      * @date 2019/8/8 11:20
      **/
    public String getAccountId() {
        return accountId;
    }

    /**
     *
     * @param
     * @return
     * @date 2019/8/8 11:17
     **/
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
      * getToken
      * @return String
      * @date 2019/8/8 11:19
      **/
    public String getToken() {
        return token;
    }

    /**
      * setToken
      * @param token
      * @date 2019/8/8 11:20
      **/
    public void setToken(String token) {
        this.token = token;
    }

    /**
      * getGmtCreate
      * @return Long
      * @date 2019/8/8 11:21
      **/
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
      * setGmtCreate
      * @param gmtCreate
      * @date 2019/8/8 11:21
      **/
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
      * getGmtModified
      * @return Long
      * @date 2019/8/8 11:21
      **/
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
      * setGmtModified
      * @param gmtModified
      * @date 2019/8/8 11:21
      **/
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
      * toString
      * @return String
      * @date 2019/8/8 11:21
      **/
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accountId='" + accountId + '\'' +
                ", token='" + token + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
