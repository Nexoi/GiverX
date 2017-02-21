package com.seeu.task.controller;

import com.seeu.task.service.QueryTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by neo on 19/01/2017.
 */
@RestController
@RequestMapping("task")
public class QueryTaskController {

    @Autowired
    QueryTaskService queryTaskService;


    @RequestMapping("querynew")
    public String querynew(@RequestAttribute(value = "UID", required = false) Integer UID, @RequestParam(value = "currentTID", required = false) Integer TID) {
        if (TID == null)
            TID = 0;
        return queryTaskService.queryNewFromWhichTID(UID, TID);
    }

    @RequestMapping("queryold")
    public String queryold(@RequestAttribute(value = "UID", required = false) Integer UID, @RequestParam(value = "currentTID", required = false) Integer TID) {
        if (TID == null)
            TID = 0;
        return queryTaskService.queryMoreOldByUID(UID, TID);
    }


    @RequestMapping("querybyTID")
    public String queryByTID(@RequestParam(value = "currentTID", required = false) Integer TID) {
        return queryTaskService.queryByTID(TID);
    }
}
