package com.seeu.task.service;

import com.TP;
import com.TurnBackUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.seeu.task.dao.TaskBasicMapper;
import com.seeu.task.dao.TaskBidderMapper;
import com.seeu.task.model.TaskBasic;
import com.seeu.task.model.TaskBidder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by neo on 19/01/2017.
 */
@Service
public class BidderService {
    private static final Logger logger = LogManager.getLogger(BidderService.class);
    @Autowired
    TurnBackUtil turnBackUtil;
    @Autowired
    TaskBidderMapper taskBidderMapper;

    @Autowired
    TaskBasicMapper taskBasicMapper;

    public String queryBidders(Integer TID) {
        if (TID == null || TID < 1)
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "查询失败，请确认TID是否正确", null);
        try {
            List<TaskBidder> list = taskBidderMapper.selectByTID(TID);
            if (list == null || list.size() == 0)
                return turnBackUtil.formIt(TP.RESCODE_TASKBIDDER_NOBIDDER, "该任务没有竞标人", null);
            JSONArray ja = new JSONArray();
            for (TaskBidder bidder : list) {
                ja.add(JSONObject.toJSON(bidder));
            }
            return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "查询成功", ja);
        } catch (Exception e) {
            return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "查询异常，请稍后再试", null);
        }
    }

    public String bidIt(Integer UID, TaskBidder bidder) {
        if (bidder.getTID() == null)
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "竞标失败，请确认TID是否正确", null);
        try {
            if (!isTaskAvaliable(bidder.getTID()))
                return turnBackUtil.formIt(TP.RESCODE_FAILURE, "竞标失败，该任务不在竞标状态", null);
            bidder.setBidderUID(UID);
            taskBidderMapper.insertSelective(bidder);
            return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "竞标成功", null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "竞标提交失败，请重新尝试", null);
        }
    }

    public String cancelBidding(Integer UID, Integer TID) {
        if (TID == null || TID < 1)
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "竞标取消失败，请确认TID是否正确", null);
        try {
            if (!isTaskAvaliable(TID))
                return turnBackUtil.formIt(TP.RESCODE_FAILURE, "取消失败，该任务已经完成竞标", null);
            int lines = taskBidderMapper.deleteByBidderUIDandTID(TID, UID);
            if (lines == 0)
                return turnBackUtil.formIt(TP.RESCODE_FAILURE, "您未竞标该任务，无需取消竞标", null);
            if (lines != 1)
                logger.warn("WARNING 竞标取消删除纪录超过一行 删除行数: " + lines + "\tUID : " + UID + "\tTID : " + TID);
            return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "取消竞标成功", null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "竞标取消失败，请重新尝试", null);
        }
    }

    private boolean isTaskAvaliable(Integer TID) {
        // 查询 task 状态是否可以支持竞标操作
        TaskBasic basic = taskBasicMapper.selectByPrimaryKey(TID);
        if (basic != null)
            if (basic.getStatus() == TP.TASK_STATUS_BIDDING)//正在竞标中
                return true;
        return false;
    }
}
