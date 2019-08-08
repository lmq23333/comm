package com.coffee.comm.dto;

public class AccessTokenDTO {
    /**
     * 用户ID
     */
    private  String client_id;
    /**
     * 用户密码
     */
    private  String clientSecret;
    /**
     * code
     */
    private  String code;
    /**
     * 重定向地址
     */
    private  String redirect_uri;
    /**
     * 状态
     */
    private  String state;

    /**
     * getClient_id
     * @return String
     */
    public String getClient_id() {
        return client_id;
    }

    /**
     * setClient_id
     * @param client_id
     */
    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    /**
     * getClientSecret
     * @return String
     */
    public String getClientSecret() {
        return clientSecret;
    }

    /**
     * setClientSecret
     * @param clientSecret
     */
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    /**
     * getCode
     * @return String
     */
    public String getCode() {
        return code;
    }

    /**
     * setCode
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * getRedirect_uri
     * @return
     */
    public String getRedirect_uri() {
        return redirect_uri;
    }

    /**
     * setRedirect_uri
     * @param redirect_uri
     */
    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    /**
     * getState
     * @return String
     */
    public String getState() {
        return state;
    }

    /**
     * setState
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }
}
