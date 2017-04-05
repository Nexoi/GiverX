package com.seeu.task.controller;

import com.seeu.task.service.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by neo on 19/01/2017.
 */

@RestController
@RequestMapping("task")
public class TaskReadController {
    @Autowired
    ReadService readService;

    @RequestMapping(value = "readplus",method = RequestMethod.POST)
    public String plusOne(@RequestAttribute("UID") Integer UID, @RequestParam("TID") Integer TID) {
        return readService.readPlusOne(TID);
    }
}
