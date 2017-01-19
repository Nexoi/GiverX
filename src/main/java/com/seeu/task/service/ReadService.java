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
public class ReadService {
    @Autowired
    TurnBackUtil turnBackUtil;
    @Autowired
    TaskBasicMapper taskBasicMapper;

    public String readPlusOne(Integer TID) {
        taskBasicMapper.updateReadPlusOne(TID);
        return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "阅读数 +1", null);
    }
}
