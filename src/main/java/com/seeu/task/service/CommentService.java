package com.seeu.task.service;

import com.TP;
import com.TurnBackUtil;
import com.alibaba.fastjson.JSONObject;
import com.seeu.task.dao.TaskBasicMapper;
import com.seeu.task.dao.TaskCommentMapper;
import com.seeu.task.model.TaskBasic;
import com.seeu.task.model.TaskComment;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by neo on 19/01/2017.
 */
@Service
public class CommentService {
    private static final Logger logger = LogManager.getLogger(CommentService.class);
    @Autowired
    TaskCommentMapper taskCommentMapper;
    @Autowired
    TaskBasicMapper taskBasicMapper;

    @Autowired
    TurnBackUtil turnBackUtil;

    public String commentIt(TaskComment comment) {
        Integer id = 0;
        Integer TID = comment.getTID();
        if (TID == null)
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "评论失败，该任务已经被删除", null);
        try {
            id = taskCommentMapper.insertSelective(comment);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "评论失败", null);
        }
        try {
            if (id == 0) return turnBackUtil.formIt(TP.RESCODE_FAILURE, "评论成功，获取评论数据失败", null);
            TaskComment taskComment = taskCommentMapper.selectByPrimaryKey(id);
            Object jo = JSONObject.toJSON(taskComment);
            // 评论数+1
            taskBasicMapper.updateCommentPlusOne(TID);
            return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "评论成功", jo);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "评论失败", null);
        }
    }

    public String delComment(Integer UID, Integer commentID) {
        TaskComment comment = taskCommentMapper.selectByPrimaryKey(commentID);
        if (comment == null)
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "该评论已经被删除，请勿重复操作", null);
        if (comment.getCommentUID() != UID)
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "无法删除非本人的评论信息", null);
        int lines = taskCommentMapper.deleteCommentByIDandUID(comment.getId(), UID);
        if (lines == 0)
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "该评论已经被删除，请勿重复操作", null);

        // 评论数-1
        taskBasicMapper.updateCommentDecreaseOne(comment.getTID());
        return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "删除评论成功", null);
    }
}
