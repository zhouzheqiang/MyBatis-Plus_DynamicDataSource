package com.zzq.pro.model;

import com.baomidou.mybatisplus.annotations.TableName;

/**
 * Created by Administrator on 2018/5/4.
 */
@TableName("login_log")
public class LoginLog {
    private String id;

    private String loginUserId;

    private String loginUserName;

    private String loginCompId;

    private String loginIp;

    private String loginTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginUserId() {
        return loginUserId;
    }

    public void setLoginUserId(String loginUserId) {
        this.loginUserId = loginUserId;
    }

    public String getLoginUserName() {
        return loginUserName;
    }

    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName;
    }

    public String getLoginCompId() {
        return loginCompId;
    }

    public void setLoginCompId(String loginCompId) {
        this.loginCompId = loginCompId;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }
}
