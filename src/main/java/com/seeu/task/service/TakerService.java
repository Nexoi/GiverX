package com.seeu.task.service;

import com.TP;
import com.TurnBackUtil;
import com.alibaba.fastjson.JSONObject;
import com.seeu.task.dao.TaskBasicMapper;
import com.seeu.task.dao.TaskBidderMapper;
import com.seeu.task.model.TaskBasic;
import com.seeu.task.model.TaskBidder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by neo on 19/01/2017.
 */
@Service
public class TakerService {
    private static final Logger logger = LogManager.getLogger(TakerService.class);

    @Autowired
    TurnBackUtil turnBackUtil;
    @Autowired
    TaskBidderMapper taskBidderMapper;

    @Autowired
    TaskBasicMapper taskBasicMapper;


    public String takeBidder(Integer myUID, Integer myTID, Integer bidderUID) {
        if ((myTID != null) && (myTID != null) && (bidderUID != null)) {
            if (!isTaskAvaliable(myTID))
                return turnBackUtil.formIt(TP.RESCODE_FAILURE, "操作失败，该任务不在竞标状态", null);
            // 查询是否在bidder
            try {
                TaskBidder bidder = taskBidderMapper.selectByTIDandBidderUID(myTID, bidderUID);
                if (bidder == null) return turnBackUtil.formIt(TP.RESCODE_FAILURE, "选取失败，无此竞标人信息", null);
                try {
                    if (bidder.getStatus() == TP.TASKBIDDER_STATUS_TOKEN)
                        return turnBackUtil.formIt(TP.RESCODE_TASKBIDDER_TOKEN, "该竞标人已被选中，请勿重复选择", JSONObject.toJSON(bidder));
                    bidder.setStatus(TP.TASKBIDDER_STATUS_TOKEN);
                    taskBidderMapper.updateByPrimaryKey(bidder);
                    return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "选取成功", JSONObject.toJSON(bidder));
                } catch (Exception ee) {
                    logger.error(ee.getMessage());
                    return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "选取失败，请稍后再试", null);
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
                return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "选取失败，请稍后再试", null);
            }
        } else
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "选取失败，请确认传入信息后再试", null);
    }

    public String cancelBidder(Integer myUID, Integer myTID, Integer bidderUID) {
        if ((myTID != null) && (myTID != null) && (bidderUID != null)) {
            if (!isTaskAvaliable(myTID))
                return turnBackUtil.formIt(TP.RESCODE_FAILURE, "操作失败，该任务不在竞标状态", null);
            // 查询是否在bidder
            try {
                TaskBidder bidder = taskBidderMapper.selectByTIDandBidderUID(myTID, bidderUID);
                if (bidder == null) return turnBackUtil.formIt(TP.RESCODE_FAILURE, "取消失败，无此竞标人信息", null);
                try {
                    if (bidder.getStatus() == TP.TASKBIDDER_STATUS_BIDDING)
                        return turnBackUtil.formIt(TP.RESCODE_TASKBIDDER_TOKEN, "该竞标人未被选中，请确认后再操作", JSONObject.toJSON(bidder));
                    bidder.setStatus(TP.TASKBIDDER_STATUS_BIDDING);
                    taskBidderMapper.updateByPrimaryKey(bidder);
                    return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "取消成功", JSONObject.toJSON(bidder));
                } catch (Exception ee) {
                    logger.error(ee.getMessage());
                    return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "取消失败，请稍后再试", null);
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
                return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "取消失败，请稍后再试", null);
            }
        } else
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "取消失败，请确认传入信息后再试", null);
    }

    private boolean isTaskAvaliable(Integer TID) {
        // 查询 task 状态是否可以编辑
        TaskBasic basic = taskBasicMapper.selectByPrimaryKey(TID);
        if (basic != null)
            if (basic.getStatus() == TP.TASK_STATUS_BIDDING)//正在竞标中
                return true;
        return false;
    }


    // 改变任务状态
    // 1. 竞标中——>完成竞标
    // 2. 完成竞标——>继续竞标？？
    public String changeStatus(Integer UID, Integer TID, Integer STATUS) {
        try {
            TaskBasic task = taskBasicMapper.selectStatusByPrimaryKey(TID);
            if (task == null) return turnBackUtil.formIt(TP.RESCODE_FAILURE, "无此任务，请确认后再更改", null);
            if (task.getStatus() == TP.TASK_STATUS_CLOSED)
                return turnBackUtil.formIt(TP.RESCODE_FAILURE, "该任务已被关闭，无法修改", null);
            task.setStatus(STATUS);
            taskBasicMapper.updateByPrimaryKey(task);
            return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "修改成功", null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "修改失败，请稍后再试", null);
        }
    }
    /**
     *
     * 暂时不考虑这种做法，事务性过于复杂
     *
     * 转移：
     * 添加 taker 表数据，from bidder
     * 删除 bidder 表数据
     *
     * @param myUID
     * @param myTID
     * @param bidderUID
     * @return
     */
//    public String itakeBidder(Integer myUID, Integer myTID, Integer bidderUID) {
//        if ((myTID != null) && (myTID != null) && (bidderUID != null)) {
//            // 查询是否在bidder
//            try {
//                TaskBidder bidder = taskBidderMapper.selectByTIDandBidderUID(myTID, bidderUID);
//                if (bidder == null) return turnBackUtil.formIt(TP.RESCODE_FAILURE, "选取失败，无此竞标人信息", null);
//                TaskTaker taskTaker = new TaskTaker();
//                taskTaker.setTID(myTID);
//                taskTaker.setRole(bidder.getRole());
//                taskTaker.setTakerUID(bidder.getBidderUID());
//                try {
//                    int resultKeyID = taskTakerMapper.insertSelective(taskTaker);
//                    taskTaker.setId(resultKeyID);
//                    // 删除 bidder 信息
//                    taskBidderMapper.deleteByPrimaryKey(bidder.getId());
//                    return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "选取成功", JSONObject.toJSON(taskTaker));
//                } catch (Exception ee) {
//                    logger.error(ee.getMessage());
//                    return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "选取失败，请稍后再试", null);
//                }
//            } catch (Exception e) {
//                logger.error(e.getMessage());
//                return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "选取失败，请稍后再试", null);
//            }
//
//        }
//    }
}
