package com.seeu.task.service;

import com.TP;
import com.TurnBackUtil;
import com.seeu.task.dao.TaskBasicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by neo on 19/01/2017.
 */
@Service
public class LikerClickService {
    @Autowired
    TurnBackUtil turnBackUtil;
    @Autowired
    TaskBasicMapper taskBasicMapper;

    public String likeIt(Integer UID, Integer TID) {
        // Do nothing for UID, dont store his record about like or not.????????
        taskBasicMapper.updateLikerPlusOne(TID);
        return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "点赞成功", null);
    }

    public String dislikeIt(Integer UID, Integer TID) {
        // Do nothing for UID, dont store his record about like or not.????????
        taskBasicMapper.updateLikerDecreaseOne(TID);
        return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "取消点赞成功", null);
    }
}
