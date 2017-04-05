package com.seeu.task.controller;

import com.seeu.task.service.QueryTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by neo on 19/01/2017.
 */
@RestController
@RequestMapping("task")
public class QueryTaskController {

    @Autowired
    QueryTaskService queryTaskService;


    @RequestMapping(value = "querynew",method = RequestMethod.POST)
    public String querynew(@RequestAttribute(value = "UID", required = false) Integer UID, @RequestParam(value = "currentTID", required = false) Integer TID) {
        if (TID == null)
            TID = 0;
        return queryTaskService.queryNewFromWhichTID(UID, TID);
    }

    @RequestMapping(value = "queryold",method = RequestMethod.POST)
    public String queryold(@RequestAttribute(value = "UID", required = false) Integer UID, @RequestParam(value = "currentTID", required = false) Integer TID) {
        if (TID == null)
            TID = 0;
        return queryTaskService.queryMoreOldByUID(UID, TID);
    }


    @RequestMapping(value = "querybyTID",method = RequestMethod.POST)
    public String queryByTID(@RequestParam(value = "currentTID", required = false) Integer TID) {
        return queryTaskService.queryByTID(TID);
    }
}
