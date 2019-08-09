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
     * account_id
     **/
    private String account_id;
    /**
     * token
     **/
    private String token;
    /**
     * gmtCreate
     **/
    private Long gmt_create;
    /**
     * gmtModified
     **/
    private Long gmt_modified;

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
        return account_id;
    }

    /**
     *
     * @param
     * @return
     * @date 2019/8/8 11:17
     **/
    public void setAccountId(String account_id) {
        this.account_id = account_id;
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
        return gmt_create;
    }

    /**
      * setGmtCreate
      * @param gmt_create
      * @date 2019/8/8 11:21
      **/
    public void setGmtCreate(Long gmt_create) {
        this.gmt_create = gmt_create;
    }

    /**
      * getGmtModified
      * @return Long
      * @date 2019/8/8 11:21
      **/
    public Long getGmtModified() {
        return gmt_modified;
    }

    /**
      * setGmtModified
      * @param gmt_modified
      * @date 2019/8/8 11:21
      **/
    public void setGmtModified(Long gmt_modified) {
        this.gmt_modified = gmt_modified;
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
                ", accountId='" + account_id + '\'' +
                ", token='" + token + '\'' +
                ", gmtCreate=" + gmt_create +
                ", gmtModified=" + gmt_modified +
                '}';
    }
}
