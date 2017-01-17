package com.seeu.userOAuth.config;

public class Constant {

    /**
     * 数据请求返回码
     */
    public static final int RESCODE_SUCCESS = 1000;                //成功
    public static final int RESCODE_SUCCESS_MSG = 1001;            //成功(有返回信息)
    public static final int RESCODE_EXCEPTION = 1002;              //请求抛出异常
    public static final int RESCODE_NOLOGIN = 1003;                //未登陆状态
    public static final int RESCODE_NOEXIST = 1004;                //查询结果为空
    public static final int RESCODE_NOAUTH = 1005;                 //无操作权限
    public static final int RESCODE_NOUSER = 1006;                 //无此账户
    public static final int RESCODE_SUCCESS_LOGIN = 1007;          //登录成功


    /**
     * jwt
     */
    public static final String JWT_ID = "jwt";
    public static final String JWT_SECRET = "s7786df7fc3a34e26a61c034d5ec8245d";
    public static final int JWT_TTL = 7 * 24 * 60 * 60 * 1000;  //millisecond
    public static final int JWT_REFRESH_INTERVAL = 1 * 24 * 60 * 60 * 1000;  //millisecond
    public static final int JWT_REFRESH_TTL = 1 * 24 * 60 * 60 * 1000;  //millisecond

}
