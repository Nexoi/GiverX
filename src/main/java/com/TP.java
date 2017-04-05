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


    public static final int RESCODE_TASKBIDDER_NOBIDDER = 3001;       //该任务无竞标人
    public static final int RESCODE_TASKBIDDER_TOKEN = 3002;          //该任务竞标人已经被选取为领取人


    public static final int RESCODE_TASKQUERY_SUCCESS_NOCLEAN = 4000;        //查询成功，不清除原有缓存数据，并连接上该返回数据
    public static final int RESCODE_TASKQUERY_SUCCESS_CLEAN = 4001;          //查询成功，并清除原有缓存数据做更新
    public static final int RESCODE_TASKQUERY_NONEEDMORE = 4002;             //已经没有更新的数据可以查询了
    public static final int RESCODE_TASKQUERY_NOSUCHTASK = 4003;             //无此任务信息
    /**
     * 数据库存储键值对应表
     */
//    public static final int TASK_STATUS_UNTOKEN = 0;        //该任务未被领取
    public static final int TASK_STATUS_BIDDING = 1;          //该任务正在竞标
    public static final int TASK_STATUS_TOKEN = 2;            //该任务已被领取
    public static final int TASK_STATUS_CLOSED = 3;           //该任务已完成

    public static final int TASKBIDDER_STATUS_BIDDING = 1;         //该任务已竞标
    public static final int TASKBIDDER_STATUS_TOKEN = 1;           //该任务已获取
    public static final int TASKBIDDER_STATUS_FINISHED = 1;        //该任务已完成

    public static final int ORDER_NOSUCH = 5001;                     //无此订单信息
    public static final int ORDER_FINISH_WITH_PURCHASE = 5002;       //订单关闭成功_支付成功
    public static final int ORDER_FINISH_WITHOUT_PURCHASE = 5003;    //订单关闭成功_无支付环节
    public static final int ORDER_UNFINISH = 5004;                   //订单关闭失败
    public static final int ORDER_PURCHASE_SUCCESS = 5005;           //支付成功
    public static final int ORDER_PURCHASE_FAILURE = 5006;           //支付失败
    public static final int ORDER_PURCHASE_EXCEPTION = 5006;           //支付失败


    public static final String PATH_USER_PROJECT = "user//project";    //头像存储地址

}
