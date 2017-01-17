package com.seeu.task.controller;

import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by neo on 18/01/2017.
 */
@RestController
@RequestMapping("task")
public class AddTaskController {
    @RequestMapping("add")
    public String addTask(@RequestAttribute("UID") Integer UID) {
        return null;
    }
}
