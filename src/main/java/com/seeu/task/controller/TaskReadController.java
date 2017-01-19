package com.seeu.task.controller;

import com.seeu.task.service.ReadService;
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
public class TaskReadController {
    @Autowired
    ReadService readService;

    @RequestMapping("readplus")
    public String plusOne(@RequestAttribute("UID") Integer UID, @RequestParam("TID") Integer TID) {
        return readService.readPlusOne(TID);
    }
}
