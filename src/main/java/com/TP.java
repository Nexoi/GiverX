package com;

/**
 * Created by neo on 13/01/2017.
 */
public class TP {
    /**
     * 数据请求返回码
     */
    public static final int RESCODE_SUCCESS = 1000;                //成功
    public static final int RESCODE_FAILURE = 1001;                //失败
    public static final int RESCODE_EXCEPTION = 1002;              //请求抛出异常
    public static final int RESCODE_NOLOGIN = 1003;                //未登陆状态
    public static final int RESCODE_NOEXIST = 1004;                //查询结果为空
    public static final int RESCODE_NOAUTH = 1005;                 //无操作权限
    public static final int RESCODE_NOUSER = 1006;                 //无此账户
    public static final int RESCODE_SUCCESS_LOGIN = 1007;          //登录成功


    public static final String PATH_USERHEAD = "user//headicon";    //头像存储地址
    public static final String PATH_USER_PROJECT = "user//project";    //头像存储地址

}
